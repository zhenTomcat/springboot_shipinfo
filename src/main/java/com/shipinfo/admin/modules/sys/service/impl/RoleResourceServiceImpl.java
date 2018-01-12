package com.shipinfo.admin.modules.sys.service.impl;

import com.shipinfo.admin.modules.sys.entity.RoleResource;
import com.shipinfo.admin.modules.sys.mapper.RoleResourceMapper;
import com.shipinfo.admin.modules.sys.service.IRoleResourceService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限和资源（菜单+按钮） 服务实现类
 * </p>
 *
 * @author zhenTomcat
 * @since 2017-12-22
 */
@Service
public class RoleResourceServiceImpl extends ServiceImpl<RoleResourceMapper, RoleResource> implements IRoleResourceService {

}
