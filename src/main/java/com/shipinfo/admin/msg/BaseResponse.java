package com.shipinfo.admin.msg;

/**
 * Created by zhen_Tomcat on 2018/01/09.
 */
public class BaseResponse {
    private int status =200;
    private String message;

    public BaseResponse() {
    }

    public BaseResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
