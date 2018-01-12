package com.shipinfo.admin.modules.sys.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.shipinfo.admin.modules.sys.entity.Role;
import com.shipinfo.admin.modules.sys.entity.User;
import com.shipinfo.admin.modules.sys.entity.UserRole;
import com.shipinfo.admin.modules.sys.mapper.RoleMapper;
import com.shipinfo.admin.modules.sys.mapper.UserMapper;
import com.shipinfo.admin.modules.sys.mapper.UserRoleMapper;
import com.shipinfo.admin.modules.sys.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.shipinfo.admin.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhenTomcat
 * @since 2017-12-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;


    @Override
    public User selectUserByUsername(String username) {
        return userMapper.selectUserByUsername(username);
    }

    public JSONObject editPassword(Integer id,String password, String oldPassword) {
        JSONObject result = new JSONObject();


        User user = userMapper.selectById(id);
        String loginName = user.getLoginName();
        Md5PasswordEncoder md5PasswordEncoder=new Md5PasswordEncoder();
        String encodePwd= md5PasswordEncoder.encodePassword(oldPassword,null);
        if (user.getPassword().equals(encodePwd)) {
            User newer = new User();
            newer.setPassword(md5PasswordEncoder.encodePassword(password,null));
            newer.setId(id);
            userMapper.updateById(newer);
            result.put("status", 1);
        } else {
            result.put("status", 0);
            result.put("msg", "原密码错误");
        }
        return result;
    }

    public boolean isNameExist(String loginName) {
        Wrapper<User> ew=new EntityWrapper<>();
        ew.addFilter("login_name={0}",loginName);
        ew.addFilter("del_flag={0}",Const.DEL_FLAG_NORMAL);
        int count=userMapper.selectCount(ew);
        return count > 0;
    }

    public List<Role> getRoles(Integer userId) {
        Map<String, Object> map = new HashMap<>();
        map.put("del_flag", 1);
        map.put("allocatable", 1);
        java.util.List<Role> roles = roleMapper.selectByMap(map);
        map = new HashMap<>();
        map.put("user_id", userId);
        List<UserRole> userRoles = userRoleMapper.selectByMap(map);
        for (Role role : roles) {
            for (UserRole userRole : userRoles) {
                if (role.getId().equals(userRole.getRoleId())) {
                    role.setChecked(true);
                    break;
                }
            }
        }
        return roles;
    }

    public void editRole(User user) {
        String roleIds = user.getRoleIds();
        if (roleIds != null && roleIds.trim().length() > 0) {
            List<UserRole> list = new ArrayList<>();
            Integer userId = user.getId();
            String[] roleIdArr = roleIds.split(",");
            for (String roleId : roleIdArr) {
                UserRole userRole = new UserRole();
                userRole.setUserId(userId);
                userRole.setRoleId(Integer.valueOf(roleId));
                list.add(userRole);
            }
            Map<String, Object> map = new HashMap<>();
            map.put("user_id", userId);
            userRoleMapper.deleteByMap(map);
            for (UserRole userRole:list){
                userRoleMapper.insert(userRole);
            }
        }
    }
}
