package com.shipinfo.admin.modules.admin.service;

import com.shipinfo.admin.modules.admin.entity.PublicShipType;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhenTomcat
 * @since 2018-01-05
 */
public interface IPublicShipTypeService extends IService<PublicShipType> {

    List<PublicShipType> listTypes(String type);
}
