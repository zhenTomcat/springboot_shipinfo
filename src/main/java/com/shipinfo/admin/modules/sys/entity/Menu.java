package com.shipinfo.admin.modules.sys.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
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
@TableName("sys_menu")
public class Menu extends Model<Menu> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 菜单名称
     */
	@TableField("menu_name")
	private String menuName;
    /**
     * 菜单URL
     */
	@TableField("menu_url")
	private String menuUrl;
    /**
     * 父菜单ID
     */
	@TableField("parent_id")
	private Integer parentId;
    /**
     * 菜单顺序
     */
	@TableField("menu_order")
	private Integer menuOrder;
    /**
     * 菜单图标
     */
	@TableField("menu_icon")
	private String menuIcon;
    /**
     * 菜单类型 资源类型：1-分类； 2-菜单
     */
	@TableField("menu_type")
	private Integer menuType;
	private Integer removable;
	private String description;
	@TableField("del_flag")
	private Integer delFlag;

	private String method;

	@TableField(exist = false)
	private List<Menu> subMenu;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getMenuOrder() {
		return menuOrder;
	}

	public void setMenuOrder(Integer menuOrder) {
		this.menuOrder = menuOrder;
	}

	public String getMenuIcon() {
		return menuIcon;
	}

	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}

	public Integer getMenuType() {
		return menuType;
	}

	public void setMenuType(Integer menuType) {
		this.menuType = menuType;
	}

	public Integer getRemovable() {
		return removable;
	}

	public void setRemovable(Integer removable) {
		this.removable = removable;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public List<Menu> getSubMenu() {
		return subMenu;
	}

	public void setSubMenu(List<Menu> subMenu) {
		this.subMenu = subMenu;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	@Override
	public String toString() {
		return "Menu{" +
				"id=" + id +
				", menuName='" + menuName + '\'' +
				", menuUrl='" + menuUrl + '\'' +
				", parentId=" + parentId +
				", menuOrder=" + menuOrder +
				", menuIcon='" + menuIcon + '\'' +
				", menuType=" + menuType +
				", removable=" + removable +
				", description='" + description + '\'' +
				", delFlag=" + delFlag +
				", subMenu=" + subMenu +
				'}';
	}
}
