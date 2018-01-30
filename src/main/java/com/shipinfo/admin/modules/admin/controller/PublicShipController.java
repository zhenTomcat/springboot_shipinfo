package com.shipinfo.admin.modules.admin.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.shipinfo.admin.modules.admin.entity.Media;
import com.shipinfo.admin.modules.admin.entity.PublicShip;
import com.shipinfo.admin.modules.admin.entity.PublicShipType;
import com.shipinfo.admin.modules.admin.service.IMediaService;
import com.shipinfo.admin.modules.admin.service.IPublicShipService;
import com.shipinfo.admin.modules.admin.service.IPublicShipTypeService;
import com.shipinfo.admin.modules.sys.controller.BaseController;
import com.shipinfo.admin.utils.Const;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhenTomcat
 * @since 2018-01-05
 */
@RestController
@RequestMapping(value = "/ship")
public class PublicShipController extends BaseController{
    private static final String CATEGOTY_TYPE = "type";
    private static final String CATEGOTY_STATUS = "status";
    private static final String CATEGOTY_COUNTRY = "country";

    @Autowired
    private IPublicShipService publicShipService;


    @Autowired
    private IPublicShipTypeService publicShipTypeService;

    @Autowired
    private IMediaService mediaService;


    @GetMapping
    @ApiOperation("查询船舶信息")
    public JSONObject list(@RequestParam(required = false) String sqlInfo,
                           @RequestParam(required = false) String param,
                           @RequestParam(required = false) Boolean delFlag) {

//        Integer id=getCurrentUser().getId();
        EntityWrapper<PublicShip> ew = getEntityWrapper();
        if (StringUtils.isNotEmpty(sqlInfo)) {
            ew.addFilter(sqlInfo);
            if ("dwt".equals(param)) {
                ew.orderBy("CONVERT(REPLACE(dwt,',','') , SIGNED)", delFlag);
            }
            if ("build_year".equals(param)) {
                ew.orderBy("STR_TO_DATE(build_year,'%c/%Y')", delFlag);
            }
            if (param != null && !"".equals(param)) {
                ew.orderBy(param, delFlag);
            }
        }
        Page<PublicShip> portPage = publicShipService.selectPage(getPage(), ew);
        return jsonPage(portPage);
    }

    @GetMapping("/type")
    @ApiOperation("获取船舶类型")
    public List<PublicShipType> shipType(){
        List<PublicShipType> types = publicShipTypeService.listTypes(CATEGOTY_TYPE);
        return  types;
    }

    @GetMapping("/status")
    @ApiOperation("获取船舶售卖状态")
    public List<PublicShipType> shipStatus(){
        List<PublicShipType> status = publicShipTypeService.listTypes(CATEGOTY_STATUS);
        return  status;
    }

    @GetMapping("/country")
    @ApiOperation("获取所有的国家信息")
    public List<PublicShipType> shipCountry(){
        List<PublicShipType> status = publicShipTypeService.listTypes(CATEGOTY_COUNTRY);
        return  status;
    }

    @GetMapping("/{id}/medias")
    @ApiOperation("获取该船舶的文件信息")
    public List<Media> medias(@ApiParam("船舶id") @PathVariable Integer id){
        EntityWrapper<Media> ew = getEntityWrapper();
        ew.addFilter("shipinfo_id={0}", id);
        List<Media> medias = mediaService.selectList(ew);
        return medias;
    }

    @PutMapping
    @ApiOperation("更新该船舶的信息")
    public JSONObject editComplete(PublicShip publicShip, Integer tid, String dataJson) {
        JSONObject jsonObject = new JSONObject();

        publicShip.setTypeId(tid);
        try {
            publicShipService.updateShip(publicShip, dataJson);
            jsonObject.put("status", 200);
        } catch (RuntimeException e) {
            jsonObject.put("status", 500);
        }
        return jsonObject;
    }

    @PostMapping
    @ApiOperation("添加船舶信息")
    public JSONObject addShip(PublicShip publicShip) {
        JSONObject jsonObject = new JSONObject();
        try {
            publicShipService.addShip(publicShip);
            jsonObject.put("status", 200);
        } catch (Exception e) {
            jsonObject.put("status", 500);
        }
        return jsonObject;
    }

    @GetMapping("/imo")
    @ApiOperation("判断数据库中是否包含该船的imo")
    public JSONObject verifyImo(@RequestParam(required = false) String imo) {
        JSONObject jsonObject = new JSONObject();

        PublicShip ship = publicShipService.selectByImo(imo);
        if (ship != null) {
            jsonObject.put("status", 200);
        } else {
            jsonObject.put("status", 500);
        }

        return jsonObject;
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除该船的信息")
    public JSONObject deleteShip(@PathVariable Integer id) {
        JSONObject jsonObject = new JSONObject();
        try {
            PublicShip ship = publicShipService.selectById(id);
            ship.setDelFlag(Const.DEL_FLAG_DELETE);
            publicShipService.updateById(ship);
            jsonObject.put("status", 1);
        } catch (Exception e) {
            jsonObject.put("status", 0);
            jsonObject.put("msg", "删除错误，请稍后再试");
        }

        return jsonObject;
    }

    //导出excel
    @GetMapping("/excel/{ids}")
    @ApiOperation("导出excel表格")
    private void excel( HttpServletResponse response, @RequestParam String ids) {
        List<PublicShip> ships = new ArrayList<>();
        if (ids != null && ids != "") {
            String[] id = ids.substring(0, ids.length() - 1).split(",");

            for (int i = 0; i < id.length; i++) {
                PublicShip ship = publicShipService.selectByIdAndType(Integer.parseInt(id[i]));
                ships.add(ship);
            }
            publicShipService.exportExcel(ships, response);
        }
    }

    @PostMapping("/excel")
    @ApiOperation("保存excel中的信息")
    public JSONObject updates(@RequestParam(value = "file", required = false) MultipartFile file) {
        JSONObject jsonObject = new JSONObject();
        try {
            Boolean flag = publicShipService.updateByExcel(file);
            jsonObject.put("flag", flag);
            jsonObject.put("status", 200);
        } catch (Exception e) {
            jsonObject.put("status", 500);
        }

        return jsonObject;
    }

    @PostMapping("/update")
    @ApiOperation("该接口是给.Net项目访问的")
    public JSONObject crossDomain(@RequestParam(required = false) String dataJson) {
        JSONObject jsonObject = new JSONObject();
        if(publicShipService.updateShipAndMedia(dataJson)){
            jsonObject.put("mes", true);
        }else
        {
            jsonObject.put("mes", false);
        }

        return jsonObject;
    }
}

