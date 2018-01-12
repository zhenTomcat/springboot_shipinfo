package com.shipinfo.admin.modules.sys.service;

import com.shipinfo.admin.modules.sys.entity.Role;
import com.baomidou.mybatisplus.service.IService;
import com.shipinfo.admin.modules.sys.entity.RoleTree;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhenTomcat
 * @since 2017-12-22
 */
public interface IRoleService extends IService<Role> {

    Role selectRoleById(Integer id);

    Boolean insertRole(Role role);

    List<Role> selectAllRoles();

    Collection<GrantedAuthority> selectRolesByUserId(Integer id);

    List<RoleTree> listTreeData(Integer roleId);

    void editRight(String selRes, Integer roleId);

}
