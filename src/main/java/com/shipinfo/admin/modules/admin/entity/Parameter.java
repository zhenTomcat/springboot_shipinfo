package com.shipinfo.admin.modules.admin.entity;

/**
 * Created by zhen_Tomcat on 2016/12/06.
 */
public class Parameter {
    //船号
    private String imo;

    //船名
    private String name;

    //状态
    private String status;

    //船的类型ID
    private int tid;

    private String startBuiltYear;

    private String endBuiltYear;

    private String builder;

    private String shipType;

    private Long dwtMin;

    private Long dwtMax;

    private String startUpdate;

    private String endUpdate;

    private Integer startCount;

    private Integer lengthCount;





    public String getImo() {
        return imo;
    }

    public void setImo(String imo) {
        this.imo = imo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStartBuiltYear() {
        return startBuiltYear;
    }

    public void setStartBuiltYear(String startBuiltYear) {
        this.startBuiltYear = startBuiltYear;
    }

    public String getEndBuiltYear() {
        return endBuiltYear;
    }

    public void setEndBuiltYear(String endBuiltYear) {
        this.endBuiltYear = endBuiltYear;
    }

    public String getBuilder() {
        return builder;
    }

    public void setBuilder(String builder) {
        this.builder = builder;
    }

    public String getShipType() {
        return shipType;
    }

    public void setShipType(String shipType) {
        this.shipType = shipType;
    }

    public Long getDwtMin() {
        return dwtMin;
    }

    public void setDwtMin(Long dwtMin) {
        this.dwtMin = dwtMin;
    }

    public Long getDwtMax() {
        return dwtMax;
    }

    public void setDwtMax(Long dwtMax) {
        this.dwtMax = dwtMax;
    }

    public Integer getStartCount() {
        return startCount;
    }

    public void setStartCount(Integer startCount) {
        this.startCount = startCount;
    }

    public Integer getLengthCount() {
        return lengthCount;
    }

    public void setLengthCount(Integer lengthCount) {
        this.lengthCount = lengthCount;
    }


    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getStartUpdate() {
        return startUpdate;
    }

    public void setStartUpdate(String startUpdate) {
        this.startUpdate = startUpdate;
    }

    public String getEndUpdate() {
        return endUpdate;
    }

    public void setEndUpdate(String endUpdate) {
        this.endUpdate = endUpdate;
    }
}
