package com.shipinfo.admin;

import com.alibaba.fastjson.JSONObject;
import com.shipinfo.admin.modules.sys.controller.BaseController;
import com.shipinfo.admin.modules.sys.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * Created by zhen_Tomcat on 2017/12/20.
 */
@RestController
public class HelloController extends BaseController{

    @GetMapping("/api/{id}")
    public String getProduct(@PathVariable Integer id) {
        return (1/1)+"";

    }

    /*获取到Authentication只能拿到里面的默认的信息，我们自己向token里面加的信息，是拿不到的，
    * 所以需要解析token来获取增加的信息*/
    @GetMapping("/me")
    public JSONObject getOrder(){
        JSONObject jsonObject=new JSONObject();
        User user=getCurrentUser();
        jsonObject.put("user",user);
        return jsonObject;
    }


}
