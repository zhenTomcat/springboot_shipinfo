package com.shipinfo.admin.modules.admin.service.impl;

import com.shipinfo.admin.modules.admin.entity.PublicShipType;
import com.shipinfo.admin.modules.admin.mapper.PublicShipTypeMapper;
import com.shipinfo.admin.modules.admin.service.IPublicShipTypeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class PublicShipTypeServiceImpl extends ServiceImpl<PublicShipTypeMapper, PublicShipType> implements IPublicShipTypeService {
    @Autowired
    private PublicShipTypeMapper publicShipTypeMapper;

    @Override
    public List<PublicShipType> listTypes(String type) {
        List<PublicShipType> types= publicShipTypeMapper.listTypes(type);
        return types;
    }
}
