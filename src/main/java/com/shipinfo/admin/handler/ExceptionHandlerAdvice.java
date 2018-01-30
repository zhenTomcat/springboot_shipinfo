package com.shipinfo.admin.handler;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhen_Tomcat on 2018/01/26.
 */
@ControllerAdvice("com.shipinfo.admin")
@ResponseBody
public class ExceptionHandlerAdvice {
    private Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);
    @ExceptionHandler(Exception.class)
    public JSONObject baseExceptionHandler(HttpServletResponse response, Exception ex) {
        JSONObject jsonObject=new JSONObject();
        logger.error(ex.getMessage(),ex);
        jsonObject.put("status",500);
        jsonObject.put("message",ex.getMessage());
        return jsonObject;
    }
}
