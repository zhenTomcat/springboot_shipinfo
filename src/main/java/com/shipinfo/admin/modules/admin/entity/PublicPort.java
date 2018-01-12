package com.shipinfo.admin.modules.admin.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhenTomcat
 * @since 2018-01-05
 */
@TableName("t_public_port")
public class PublicPort extends Model<PublicPort> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	@TableField("port_code")
	private String portCode;
	@TableField("port_en")
	private String portEn;
	@TableField("port_ch")
	private String portCh;
	@TableField("country_code")
	private String countryCode;
    /**
     * 经度
     */
	private Double longitude;
    /**
     * 纬度
     */
	private Double latitude;
    /**
     * 验船师人数
     */
	@TableField("surveyors_count")
	private Integer surveyorsCount;
	@TableField("create_date")
	private Date createDate;
	@TableField("create_by")
	private String createBy;
	@TableField("update_date")
	private Date updateDate;
	@TableField("update_by")
	private String updateBy;
	@TableField("del_flag")
	private Integer delFlag;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPortCode() {
		return portCode;
	}

	public void setPortCode(String portCode) {
		this.portCode = portCode;
	}

	public String getPortEn() {
		return portEn;
	}

	public void setPortEn(String portEn) {
		this.portEn = portEn;
	}

	public String getPortCh() {
		return portCh;
	}

	public void setPortCh(String portCh) {
		this.portCh = portCh;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Integer getSurveyorsCount() {
		return surveyorsCount;
	}

	public void setSurveyorsCount(Integer surveyorsCount) {
		this.surveyorsCount = surveyorsCount;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "PublicPort{" +
			", id=" + id +
			", portCode=" + portCode +
			", portEn=" + portEn +
			", portCh=" + portCh +
			", countryCode=" + countryCode +
			", longitude=" + longitude +
			", latitude=" + latitude +
			", surveyorsCount=" + surveyorsCount +
			", createDate=" + createDate +
			", createBy=" + createBy +
			", updateDate=" + updateDate +
			", updateBy=" + updateBy +
			", delFlag=" + delFlag +
			"}";
	}
}
