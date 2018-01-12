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
@TableName("sys_role")
public class Role extends Model<Role> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 角色名称
     */
	@TableField("role_name")
	private String roleName;
    /**
     * 可被删除 0=不行 1=可以
     */
	private Integer removable;
    /**
     * 可被分配 0=不行 1=可以
     */
	private Integer allocatable;
	private String description;
    /**
     * 是否删除
     */
	@TableField("del_flag")
	private Integer delFlag;

	@TableField(exist = false)
	private List<Menu> menus;
	@TableField(exist = false)
	private List<Button> buttons;

	@TableField(exist = false)
	private Boolean checked;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getRemovable() {
		return removable;
	}

	public void setRemovable(Integer removable) {
		this.removable = removable;
	}

	public Integer getAllocatable() {
		return allocatable;
	}

	public void setAllocatable(Integer allocatable) {
		this.allocatable = allocatable;
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

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public List<Button> getButtons() {
		return buttons;
	}

	public void setButtons(List<Button> buttons) {
		this.buttons = buttons;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	@Override
	public String toString() {
		return "Role{" +
			", id=" + id +
			", roleName=" + roleName +
			", removable=" + removable +
			", allocatable=" + allocatable +
			", description=" + description +
			", delFlag=" + delFlag +
			"}";
	}


}
