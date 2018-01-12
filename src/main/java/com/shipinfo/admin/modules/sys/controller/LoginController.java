package com.shipinfo.admin.modules.sys.controller;

import com.shipinfo.admin.modules.sys.entity.Menu;
import com.shipinfo.admin.modules.sys.entity.User;
import com.shipinfo.admin.modules.sys.service.IUserService;
import com.shipinfo.admin.modules.sys.service.LoginService;
import com.shipinfo.admin.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhen_Tomcat on 2018/01/03.
 */
@Controller
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
        Md5PasswordEncoder md5PasswordEncoder=new Md5PasswordEncoder();
        String p=md5PasswordEncoder.encodePassword(password,null);
        user.setPassword(p);
        userService.insert(user);


        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    @ResponseBody
    public List<Menu> login_index() {
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
}
