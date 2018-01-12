package com.shipinfo.admin.modules.admin.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.shipinfo.admin.modules.admin.entity.Media;
import com.shipinfo.admin.modules.admin.entity.Parameter;
import com.shipinfo.admin.modules.admin.entity.PublicShip;
import com.shipinfo.admin.modules.admin.mapper.MediaMapper;
import com.shipinfo.admin.modules.admin.mapper.PublicShipMapper;
import com.shipinfo.admin.modules.admin.mapper.PublicShipTypeMapper;
import com.shipinfo.admin.modules.admin.service.IPublicShipService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.shipinfo.admin.utils.Const;
import com.shipinfo.admin.utils.MailUtil;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhenTomcat
 * @since 2018-01-05
 */
@Service
public class PublicShipServiceImpl extends ServiceImpl<PublicShipMapper, PublicShip> implements IPublicShipService {

    @Autowired
    private PublicShipMapper publicShipMapper;

    @Autowired
    private MediaMapper mediaMapper;


    @Autowired
    private PublicShipTypeMapper publicShipTypeMapper;

    @Override
    public List<PublicShip> getPublicShip(Parameter parameter) {

        return publicShipMapper.getPublicShip(parameter);
    }

    @Override
    public Integer seleteByParamerSearchCount(Parameter parameter) {
        return publicShipMapper.seleteByParamerSearchCount(parameter).size();
    }

    @Transactional
    @Override
    public Boolean updateShip(PublicShip ship, String dataJson) {
        ship.setUpdateDate(new Date());
        publicShipMapper.updateById(ship);
        if (ship.getMedias() != null) {
            for (Media m : ship.getMedias()) {
                m.setCreateDate(new Date());
                m.setShipinfoId(ship.getId());
                m.setDelFlag(Const.DEL_FLAG_NORMAL);
                m.setStatus(Const.FILE_SHIP);
                mediaMapper.insert(m);
            }
        }
        return true;

    }

    @Override
    @Transactional
    public Boolean addShip(PublicShip ship) {
        ship.setDelFlag(Const.DEL_FLAG_NORMAL);
        ship.setCreateDate(new Date());
        ship.setUpdateDate(new Date());
        publicShipMapper.insert(ship);
        if (ship.getMedias() != null) {
            for (Media m : ship.getMedias()) {
                m.setShipinfoId(ship.getId());
                m.setDelFlag(Const.DEL_FLAG_NORMAL);
                m.setCreateDate(new Date());
                m.setStatus(Const.FILE_SHIP);
                mediaMapper.insert(m);
            }
        }
        return true;
    }

    @Override
    public PublicShip selectByIdAndType(Integer id) {
        return publicShipMapper.selectByIdAndType(id);
    }

    @Override
    public PublicShip selectByImo(String imo) {
        return publicShipMapper.selectByImo(imo);
    }

    @Override
    @Transactional
    public Boolean updateByExcel(MultipartFile file) {
        Boolean flag = true;
        String problemShip = "更新失败的船舶名称：";

        //获取Workbook的工作簿
        Workbook wb = getWorkBook(file);

        Sheet sheet = wb.getSheetAt(0);//获取sheet的对象
        if (sheet != null) {
            int rows = sheet.getLastRowNum();
            for (int i = 1; i <= rows; i++) {
                Row row = sheet.getRow(i);

                if (row != null) {
                    Cell cell1 = row.getCell(1);
                    if (cell1 != null) {
                        String shipName = cell1.getStringCellValue();
                        String shipType = row.getCell(0).getStringCellValue();
                        Integer typeId = publicShipTypeMapper.selectIdByShipType(shipType);
                        EntityWrapper<PublicShip> ew = new EntityWrapper<>();
                        ew.addFilter("del_flag={0} and name={1} and type_id={2}", Const.DEL_FLAG_NORMAL, shipName.trim(), typeId);
                        List<PublicShip> ships = publicShipMapper.selectList(ew);
                        if (ships.size() == 1) {
                            Cell cell2 = row.getCell(2);
                            if (cell2 != null) {
                                PublicShip ship = ships.get(0);
                                ship.setDynamic(cell2.getStringCellValue());
                                ship.setStatus("Onsale");
                                ship.setUpdateDate(new Date());
                                publicShipMapper.updateById(ship);
                            }
                        } else {
                            problemShip += shipName + ",";
                            flag = false;
                            continue;
                        }
                    }

                }
            }
        } else {
            flag = false;
        }
        MailUtil.sendEmail("601590910@qq.com", problemShip, "未更新船舶", null);/*snp@tocean.hk*/
        return flag;
    }

    @Override
    @Transactional
    public Boolean updateShipAndMedia(String datajson) {
        PublicShip ship = JSONObject.parseObject(datajson, PublicShip.class);
        List<Media> medias = ship.getMedias();

        PublicShip publicShip = publicShipMapper.selectByImo(ship.getImo());
        if (publicShip != null) {
            publicShip.setSeaFoDo(ship.getSeaFoDo());
            publicShip.setPortFoDo(ship.getPortFoDo());
            publicShip.setAnchorageFoDo(ship.getAnchorageFoDo());
        } else {
            return false;
        }
        publicShipMapper.updateById(publicShip);
        for (Media media : medias) {
            media.setShipinfoId(publicShip.getId());
            media.setStatus(Const.FILE_SHIP);
            media.setDelFlag(Const.DEL_FLAG_NORMAL);
            media.setCreateDate(new Date());
            mediaMapper.insert(media);
        }
        return true;
    }

    @Override
    public void exportExcel(List<PublicShip> ships, HttpServletResponse response) {
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            exportExcelX(ships, os);
            byte[] content = os.toByteArray();
            InputStream is = new ByteArrayInputStream(content);
            // 设置response参数，可以打开下载页面
            response.reset();

            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + new String(("ship" + ".xls").getBytes(), "iso-8859-1"));
            response.setContentLength(content.length);
            ServletOutputStream outputStream = response.getOutputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            BufferedOutputStream bos = new BufferedOutputStream(outputStream);
            byte[] buff = new byte[8192];
            int bytesRead;
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);

            }
            bis.close();
            bos.close();
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /*
    * 获取Workbook的工作簿
    * */
    public Workbook getWorkBook(MultipartFile file) {
        //获取文件名称
        String fileName = file.getOriginalFilename();
        Workbook workbook = null;
        try {
            if (fileName.endsWith("xls")) {
                workbook = new HSSFWorkbook(file.getInputStream());
            } else if (fileName.endsWith("xlsx")) {
                workbook = new XSSFWorkbook(file.getInputStream());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return workbook;
    }


    public void exportExcelX(List<PublicShip> ships, OutputStream out) {
        File modelExcel = null;
        modelExcel = new File(getClass().getClassLoader().getResource("Ship.xls").getFile());
        HSSFWorkbook wb = null;

        try (FileInputStream is = new FileInputStream(modelExcel);) {
            wb = new HSSFWorkbook(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (wb != null) {
            HSSFSheet sheet = wb.getSheetAt(0);
            int num = 1;
            for (PublicShip ship : ships) {

                Row row = sheet.createRow(num);
                createCell(row);
                row.getCell(0).setCellValue(ship.getType().getCategory());
                row.getCell(1).setCellValue(ship.getImo());
                row.getCell(2).setCellValue(ship.getStatus());
                row.getCell(3).setCellValue(ship.getName());
                row.getCell(4).setCellValue(ship.getBuildYear());
                row.getCell(5).setCellValue(ship.getBuilder());
                row.getCell(6).setCellValue(ship.getShipType());
                row.getCell(7).setCellValue(ship.getDwt());

                String dateString = "";
                if (ship.getUpdateDate() != null) {
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    dateString = formatter.format(ship.getUpdateDate());
                }
                row.getCell(8).setCellValue(dateString);
                num++;
            }

            try {
                wb.write(out);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void createCell(Row row) {
        row.createCell(0);
        row.createCell(1);
        row.createCell(2);
        row.createCell(3);
        row.createCell(4);
        row.createCell(5);
        row.createCell(6);
        row.createCell(7);
        row.createCell(8);
    }
}
