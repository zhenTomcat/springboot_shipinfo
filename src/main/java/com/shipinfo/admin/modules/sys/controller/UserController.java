package com.shipinfo.admin.modules.sys.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.shipinfo.admin.modules.sys.entity.User;
import com.shipinfo.admin.modules.sys.service.IRoleService;
import com.shipinfo.admin.modules.sys.service.IUserService;
import com.shipinfo.admin.utils.Const;
import freemarker.template.SimpleHash;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.security.auth.Subject;
import java.util.Arrays;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhenTomcat
 * @since 2017-12-22
 */
@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController{
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    /*
    * 查询 ：GET http://localhost:8080/user?keyword=
    * 更新：PUT http://localhost:8080/user
    * 删除：DELETE http://localhost:8080/user/1
    * 添加：POST http://localhost:8080/user
    * */

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    //查询
    @GetMapping
    @ApiOperation(value = "查询用户的所有信息，默认查询条件可以为空")
    public JSONObject page(@ApiParam("搜索条件") @RequestParam(required = false) String keyword) {
        EntityWrapper<User> ew = getEntityWrapper();
        if (!StringUtils.isEmpty(keyword))
            ew.addFilter("CONCAT(IFNULL(login_name,''),IFNULL(name,'')) like {0}", "%" + keyword + "%");
        return jsonPage(userService.selectPage(getPage(), ew));
    }

    //更新用户
    @PutMapping
    @ApiOperation(value = "更新用户信息")
    public JSONObject edit(@RequestBody User user) {
        JSONObject result = new JSONObject();
        if (StringUtils.isNotBlank(user.getPassword())) {
            User u = userService.selectById(user.getId());
            String loginName = u.getLoginName();
            Md5PasswordEncoder md5PasswordEncoder=new Md5PasswordEncoder();

            String password = md5PasswordEncoder.encodePassword(user.getPassword(),null);
            user.setPassword(password);
        } else {
            user.setPassword(null);
        }
        userService.updateById(user);
        /*Subject subject = SecurityUtils.getSubject();
        if (subject.hasRole(Const.ADMIN_ROLE)) userService.editRole(user);*/
        result.put("status", 200);
        result.put("message","修改成功");
        return result;
    }

    //查询
    @GetMapping("/{id}")
    @ApiOperation(value = "根据用户id，获取用户信息")
    public User get(@PathVariable Integer id) {
        User user=userService.selectById(id);
        return user;
    }

    //删除
    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据用户id删除用户信息")
    public JSONObject delete(@PathVariable Integer id) {
        JSONObject result = new JSONObject();
        User user=userService.selectById(id);
        user.setDelFlag(Const.DEL_FLAG_DELETE);
        userService.updateById(user);
        result.put("status", 200);
        return result;
    }

    //添加
    @PostMapping
    @ApiOperation(value = "添加用户信息")
    public JSONObject add(@RequestBody User user) {
        JSONObject jsonObject = new JSONObject();
        // 登录名统一转换成小写
        user.setLoginName(user.getLoginName().toLowerCase());
        if (userService.isNameExist(user.getLoginName())) {
            jsonObject.put("status", 0);
            jsonObject.put("msg", "用户名重复，请修改");
        } else {
            Md5PasswordEncoder md5PasswordEncoder=new Md5PasswordEncoder();

            String password = md5PasswordEncoder.encodePassword(user.getPassword(),null);
            user.setPassword(password);
            user.setDelFlag(Const.DEL_FLAG_NORMAL);
            userService.insert(user);
            jsonObject.put("status", 200);
        }
        return jsonObject;
    }

    //更新当前登录用户的用户名和密码
    @ApiOperation(value = "修改当前登录用户的密码")
    @PutMapping("/current")
    public JSONObject update(@ApiParam("新密码") @RequestParam String password,@ApiParam("旧密码") @RequestParam String oldPassword) {
        return userService.editPassword(getCurrentUser().getId(),password, oldPassword);
    }



    //检查当前用户名是否存在
    @GetMapping("/check/{name}")
    @ApiOperation(value = "检查当前数据库中是否有这个用户名")
    public JSONObject check(@PathVariable(name = "name") String loginName) {
        JSONObject result = new JSONObject();
        try {
            if (userService.isNameExist(loginName)) {
                result.put("status",200);
            }
        } catch (Exception e) {
            logger.error("check group name error", e);
        }
        return result;
    }



    //批量删除
    @DeleteMapping(value = "/batch/{ids}")
    @ApiOperation(value = "选择多个用户，进行批量删除")
    public JSONObject delete(@PathVariable String ids) {
        JSONObject result = new JSONObject();
        if (!StringUtils.isEmpty(ids))
            userService.deleteBatchIds(Arrays.asList(ids.split(",")));
        result.put("status", 200);
        return result;
    }


    @PutMapping(value = "/role")
    @ApiOperation(value = "给用户分配角色")
    public JSONObject editRole(@RequestBody User user) {
        JSONObject result = new JSONObject();
        userService.editRole(user);
        result.put("status", 200);
        return result;
    }
}

