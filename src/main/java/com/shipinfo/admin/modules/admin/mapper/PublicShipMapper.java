package com.shipinfo.admin.modules.admin.mapper;

import com.shipinfo.admin.modules.admin.entity.Parameter;
import com.shipinfo.admin.modules.admin.entity.PublicShip;
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
public interface PublicShipMapper extends BaseMapper<PublicShip> {

    List<PublicShip> getPublicShip(Parameter parameter);

    List<PublicShip> seleteByParamerSearchCount(Parameter parameter);

    PublicShip selectByIdAndType(Integer id);

    PublicShip selectByImo(String imo);
}
