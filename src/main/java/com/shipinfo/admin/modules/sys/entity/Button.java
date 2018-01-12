package com.shipinfo.admin.modules.sys.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
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
 * @since 2017-12-22
 */
@TableName("sys_button")
public class Button extends Model<Button> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 子菜单名称
     */
	@TableField("menu_id")
	private Integer menuId;
    /**
     * 按钮名称
     */
	@TableField("button_name")
	private String buttonName;
    /**
     * 按钮路径
     */
	@TableField("button_url")
	private String buttonUrl;
	@TableField("del_flag")
	private Integer delFlag;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getButtonName() {
		return buttonName;
	}

	public void setButtonName(String buttonName) {
		this.buttonName = buttonName;
	}

	public String getButtonUrl() {
		return buttonUrl;
	}

	public void setButtonUrl(String buttonUrl) {
		this.buttonUrl = buttonUrl;
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
		return "Button{" +
			", id=" + id +
			", menuId=" + menuId +
			", buttonName=" + buttonName +
			", buttonUrl=" + buttonUrl +
			", delFlag=" + delFlag +
			"}";
	}
}
