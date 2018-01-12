package com.shipinfo.admin.modules.sys.service.impl;

import com.shipinfo.admin.modules.sys.entity.UserRole;
import com.shipinfo.admin.modules.sys.mapper.UserRoleMapper;
import com.shipinfo.admin.modules.sys.service.IUserRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户和角色 服务实现类
 * </p>
 *
 * @author zhenTomcat
 * @since 2017-12-22
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
