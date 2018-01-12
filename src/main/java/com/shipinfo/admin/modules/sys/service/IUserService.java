package com.shipinfo.admin.modules.sys.service;

import com.alibaba.fastjson.JSONObject;
import com.shipinfo.admin.modules.sys.entity.Role;
import com.shipinfo.admin.modules.sys.entity.User;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhenTomcat
 * @since 2017-12-22
 */
public interface IUserService extends IService<User> {
    User selectUserByUsername(String username);

    JSONObject editPassword(Integer id,String password, String oldPassword);

    boolean isNameExist(String loginName);

    List<Role> getRoles(Integer userId);

    void editRole(User user);
}
