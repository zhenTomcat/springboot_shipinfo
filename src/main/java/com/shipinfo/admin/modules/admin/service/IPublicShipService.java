package com.shipinfo.admin.modules.admin.service;

import com.shipinfo.admin.modules.admin.entity.Parameter;
import com.shipinfo.admin.modules.admin.entity.PublicShip;
import com.baomidou.mybatisplus.service.IService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhenTomcat
 * @since 2018-01-05
 */
public interface IPublicShipService extends IService<PublicShip> {

    List<PublicShip> getPublicShip(Parameter parameter);

    Integer seleteByParamerSearchCount(Parameter parameter);

    Boolean updateShip(PublicShip ship,String dataJson);

    Boolean addShip(PublicShip ship);

    void exportExcel(List<PublicShip> ships,HttpServletResponse response);

    PublicShip selectByIdAndType(Integer id);

    PublicShip selectByImo(String imo);

    Boolean updateByExcel(MultipartFile file);

    Boolean updateShipAndMedia(String datajson);

}
