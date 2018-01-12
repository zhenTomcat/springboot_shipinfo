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
@TableName("t_media")
public class Media extends Model<Media> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	@TableField("file_name")
	private String fileName;
	@TableField("file_des")
	private String fileDes;
	@TableField("oss_url")
	private String ossUrl;
	@TableField("shipinfo_id")
	private Integer shipinfoId;
	@TableField("create_by")
	private String createBy;
	@TableField("create_date")
	private Date createDate;
	@TableField("update_by")
	private String updateBy;
	@TableField("update_date")
	private Date updateDate;
	@TableField("del_flag")
	private Integer delFlag;
	private Integer status;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileDes() {
		return fileDes;
	}

	public void setFileDes(String fileDes) {
		this.fileDes = fileDes;
	}

	public String getOssUrl() {
		return ossUrl;
	}

	public void setOssUrl(String ossUrl) {
		this.ossUrl = ossUrl;
	}

	public Integer getShipinfoId() {
		return shipinfoId;
	}

	public void setShipinfoId(Integer shipinfoId) {
		this.shipinfoId = shipinfoId;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Media{" +
			", id=" + id +
			", fileName=" + fileName +
			", fileDes=" + fileDes +
			", ossUrl=" + ossUrl +
			", shipinfoId=" + shipinfoId +
			", createBy=" + createBy +
			", createDate=" + createDate +
			", updateBy=" + updateBy +
			", updateDate=" + updateDate +
			", delFlag=" + delFlag +
			", status=" + status +
			"}";
	}
}
