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
 * 权限和资源（菜单+按钮）
 * </p>
 *
 * @author zhenTomcat
 * @since 2017-12-22
 */
@TableName("sys_role_resource")
public class RoleResource extends Model<RoleResource> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	@TableField("role_id")
	private Integer roleId;
	@TableField("resource_id")
	private Integer resourceId;
    /**
     * 资源类型：1-分类； 2-菜单；3-按钮
     */
	@TableField("resource_type")
	private Integer resourceType;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getResourceId() {
		return resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

	public Integer getResourceType() {
		return resourceType;
	}

	public void setResourceType(Integer resourceType) {
		this.resourceType = resourceType;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "RoleResource{" +
			", id=" + id +
			", roleId=" + roleId +
			", resourceId=" + resourceId +
			", resourceType=" + resourceType +
			"}";
	}
}
