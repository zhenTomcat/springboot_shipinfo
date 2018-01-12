package com.shipinfo.admin.modules.admin.mapper;

import com.shipinfo.admin.modules.admin.entity.PublicShipType;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhenTomcat
 * @since 2018-01-05
 */
public interface PublicShipTypeMapper extends BaseMapper<PublicShipType> {

    List<PublicShipType> listTypes(String type);

    Integer selectIdByShipType(String type);

}
