package com.shipinfo.admin.modules.sys.controller;

import com.shipinfo.admin.modules.sys.entity.Button;
import com.shipinfo.admin.modules.sys.entity.Menu;
import com.shipinfo.admin.modules.sys.entity.User;
import com.shipinfo.admin.modules.sys.service.IUserService;
import com.shipinfo.admin.modules.sys.service.LoginService;
import com.shipinfo.admin.utils.Const;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhen_Tomcat on 2018/01/03.
 */
@RestController
@RequestMapping(value = "/sys")
public class LoginController extends BaseController{

    @Autowired
    private LoginService loginService;

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/registry",method = RequestMethod.POST)
    public ResponseEntity<?> registry(String username, String password){
        User user=new User();
        user.setLoginName(username);
        user.setDelFlag(Const.DEL_FLAG_NORMAL);
        BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
        String p=encode.encode(password);
        user.setPassword(p);
        userService.insert(user);


        return ResponseEntity.ok(user);
    }

    @GetMapping("/index")
    public List<Menu> login_index(){
        int userId=getCurrentUser().getId();

        List<Menu> menus = loginService.getRightsParentMenus(userId);
        for (Menu menu : menus) {


            Map<String, Integer> params = new HashMap<>();
            params.put("userId", userId);
            params.put("menuId", menu.getId());
            List<Menu> subMenus = loginService.getRightsSubMenus(params);
            menu.setSubMenu(subMenus);
        }
        return menus;
    }

    @GetMapping("/urls")
    @ApiOperation("登录成功后，获取当前用户的所有的权限和资源信息")
    private List<String> urls(){
        // 当前用户下的所有button
        List<Button> buttonList = new ArrayList<>();

        List<String> allRightsUrls = new ArrayList<>();

        Integer id=getCurrentUser().getId();
        List<Menu> menus = loginService.getRightsParentMenus(id);
        for (Menu menu : menus) {
            allRightsUrls.add(menu.getMenuUrl());

            Map<String, Integer> params = new HashMap<>();
            params.put("userId", id);
            params.put("menuId", menu.getId());

            List<Menu> subMenus = loginService.getRightsSubMenus(params);
            menu.setSubMenu(subMenus);

            for (Menu subMenu : subMenus) {
                allRightsUrls.add(subMenu.getMenuUrl());
            }

        }

        // 添加按钮权限信息
        List<Button> buttons = loginService.getRightsButtons(id);
        buttonList.addAll(buttons);
        for (Button button : buttons) {
            allRightsUrls.add(button.getButtonUrl());
        }
        return allRightsUrls;
    }
}
