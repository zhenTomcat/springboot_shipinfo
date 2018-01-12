package com.shipinfo.admin.msg;

/**
 * Created by zhen_Tomcat on 2018/01/09.
 */
public class ObjectRestResponse<T> extends BaseResponse {
    T Data;
    boolean rel;

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }

    public boolean isRel() {
        return rel;
    }

    public void setRel(boolean rel) {
        this.rel = rel;
    }

    public ObjectRestResponse rel(boolean rel) {
        this.setRel(rel);
        return this;
    }


    public ObjectRestResponse data(T data) {
        this.setData(data);
        return this;
    }
}
