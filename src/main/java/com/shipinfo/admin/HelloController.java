package com.shipinfo.admin;

import com.alibaba.fastjson.JSONObject;
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
public class HelloController {

    @CrossOrigin
    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable String id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "product id : " + id;
    }

    /*获取到Authentication只能拿到里面的默认的信息，我们自己向token里面加的信息，是拿不到的，
    * 所以需要解析token来获取增加的信息*/
    @GetMapping("/me")
    public JSONObject getOrder(Authentication authentication, HttpServletRequest request) throws UnsupportedEncodingException {
        String header =request.getHeader("Authorization");
        String token= StringUtils.substringAfter(header,"bearer");

        Claims claims=Jwts.parser().setSigningKey("shipinfo".getBytes("UTF-8")).parseClaimsJws(token).getBody();
        String company= (String) claims.get("company");
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("company",company);
        return jsonObject;
    }


}
