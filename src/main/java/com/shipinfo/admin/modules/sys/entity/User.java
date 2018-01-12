package com.shipinfo.admin.modules.sys.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhenTomcat
 * @since 2017-12-22
 */
@TableName("sys_user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 登录名
     */
	@TableField("login_name")
	private String loginName;
    /**
     * 密码
     */
	private String password;
    /**
     * 姓名
     */
	private String name;
    /**
     * 上次登录时间
     */
	@TableField("last_login")
	private Date lastLogin;
    /**
     * IP
     */
	private String ip;
    /**
     * 状态
     */
	@TableField("del_flag")
	private Integer delFlag;

	private String description;
    /**
     * 邮箱
     */
	private String email;
	private String phone;
    /**
     * 身份证
     */
	private String identification;
    /**
     * 创建时间
     */
	@TableField("create_date")
	private Date createDate;
    /**
     * 更新时间
     */
	@TableField("update_date")
	private Date updateDate;
    /**
     * 创建者
     */
	@TableField("create_by")
	private Integer createBy;
    /**
     * 更新者
     */
	@TableField("update_by")
	private Integer updateBy;
    /**
     * 地址
     */
	private String address;
    /**
     * 头像图片地址
     */
	@TableField("head_img_url")
	private String headImgUrl;
	@TableField("style_id")
	private Integer styleId;
	@TableField("company_id")
	private Integer companyId;
    /**
     * 邮箱验证状态
     */
	@TableField("email_status")
	private Integer emailStatus;
    /**
     * 邮箱验证开始时间
     */
	@TableField("email_time")
	private Date emailTime;
    /**
     * 邮箱验证码
     */
	@TableField("email_code")
	private String emailCode;

	@TableField(exist = false)
	private List<Role> roles;

	@TableField(exist = false)
	private String roleIds;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}


	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}

	public Integer getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Integer updateBy) {
		this.updateBy = updateBy;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHeadImgUrl() {
		return headImgUrl;
	}

	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}

	public Integer getStyleId() {
		return styleId;
	}

	public void setStyleId(Integer styleId) {
		this.styleId = styleId;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public Integer getEmailStatus() {
		return emailStatus;
	}

	public void setEmailStatus(Integer emailStatus) {
		this.emailStatus = emailStatus;
	}

	public Date getEmailTime() {
		return emailTime;
	}

	public void setEmailTime(Date emailTime) {
		this.emailTime = emailTime;
	}

	public String getEmailCode() {
		return emailCode;
	}

	public void setEmailCode(String emailCode) {
		this.emailCode = emailCode;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}


	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

	@Override
	public String toString() {
		return "User{" +
			", id=" + id +
			", loginName=" + loginName +
			", password=" + password +
			", name=" + name +
			", lastLogin=" + lastLogin +
			", ip=" + ip +
			", delFlag=" + delFlag +
			", description=" + description +
			", email=" + email +
			", phone=" + phone +
			", identification=" + identification +
			", createDate=" + createDate +
			", updateDate=" + updateDate +
			", createBy=" + createBy +
			", updateBy=" + updateBy +
			", address=" + address +
			", headImgUrl=" + headImgUrl +
			", styleId=" + styleId +
			", companyId=" + companyId +
			", emailStatus=" + emailStatus +
			", emailTime=" + emailTime +
			", emailCode=" + emailCode +
			"}";
	}
}
