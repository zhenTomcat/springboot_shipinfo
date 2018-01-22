package com.shipinfo.admin.modules.sys.mapper;

import com.shipinfo.admin.modules.sys.entity.Role;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhenTomcat
 * @since 2017-12-22
 */
public interface RoleMapper extends BaseMapper<Role> {

    Role selectRoleById(Integer id);

    List<Role> selectAllRoles();

    List<Role> selectByUserId(Integer id);

    List<String> findRolesIdByUserId(String userId);

    List<Role> selectRolesByUriAndMethod(@Param("url")String buttonUrl, @Param("method") String buttonMethod);
}
