package com.shipinfo.admin.modules.sys.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.shipinfo.admin.modules.sys.entity.Role;
import com.shipinfo.admin.modules.sys.entity.RoleTree;
import com.shipinfo.admin.modules.sys.service.IRoleService;
import com.shipinfo.admin.utils.Const;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhenTomcat
 * @since 2017-12-22
 */
@RestController
@RequestMapping(value = "/role")
public class RoleController extends BaseController{
    @Autowired
    private IRoleService roleService;


    @GetMapping
    @ApiOperation("查询角色信息")
    public JSONObject listMenu(@ApiParam("角色名称") @RequestParam String roleName) {
        EntityWrapper<Role> ew = getEntityWrapper();
        if (!StringUtils.isEmpty(roleName))
            ew.addFilter("role_name={0}",roleName);
        Page<Role> page = roleService.selectPage(getPage(), ew);
        return jsonPage(page);
    }


    @PostMapping
    @ApiOperation("添加角色信息")
    public JSONObject add(Role role) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 200);
        role.setDelFlag(Const.DEL_FLAG_NORMAL);
        roleService.insert(role);
        return jsonObject;
    }

    @PutMapping
    @ApiOperation("更新角色信息")
    public JSONObject edit(Role role) {
        JSONObject jsonObject = new JSONObject();
        roleService.updateById(role);
        jsonObject.put("status", 200);
        return jsonObject;
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除角色信息")
    public JSONObject delete(@PathVariable Integer id) {
        roleService.deleteById(id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 200);
        return jsonObject;
    }

    @DeleteMapping(value = "/batch/{ids}")
    @ApiOperation("批量删除角色信息")
    public JSONObject batchDelete(@PathVariable String ids) {
        JSONObject jsonObject = new JSONObject();
        roleService.deleteBatchIds(Arrays.asList(ids.split(",")));
        jsonObject.put("status", 200);
        return jsonObject;

    }


    //该角色下的所有资源
    @GetMapping(value = "/nodes/{id}")
    @ApiOperation("该权限下的所有资源信息")
    public List<RoleTree> resNodes(@PathVariable Integer id) {
        return roleService.listTreeData(id);
    }

    //该角色下的的资源重新分配
    @PutMapping("/{id}/right")
    @ApiOperation("更新该权限的资源信息")
    public JSONObject editRight(@RequestParam String selRes, @PathVariable(name = "id") Integer roleId) {

        JSONObject jsonObject = new JSONObject();
        roleService.editRight(selRes, roleId);

        jsonObject.put("status", 200);
        return jsonObject;
    }

}

