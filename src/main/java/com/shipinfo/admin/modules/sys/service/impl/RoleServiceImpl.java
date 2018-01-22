package com.shipinfo.admin.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.shipinfo.admin.modules.sys.entity.*;
import com.shipinfo.admin.modules.sys.mapper.ButtonMapper;
import com.shipinfo.admin.modules.sys.mapper.MenuMapper;
import com.shipinfo.admin.modules.sys.mapper.RoleMapper;
import com.shipinfo.admin.modules.sys.mapper.RoleResourceMapper;
import com.shipinfo.admin.modules.sys.service.IRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhenTomcat
 * @since 2017-12-22
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private ButtonMapper buttonMapper;

    @Autowired
    private RoleResourceMapper roleResourceMapper;

    @Override
    public Role selectRoleById(Integer id) {
        return roleMapper.selectRoleById(id);
    }

    @Transactional
    @Override
    public Boolean insertRole(Role role) {
        roleMapper.insert(role);
        return true;
    }

    @Override
    public List<Role> selectAllRoles() {
        List<Role> roles=roleMapper.selectAllRoles();
        return roles;
    }

    @Override
    public Collection<GrantedAuthority> selectRolesByUserId(Integer id) {
        Collection<GrantedAuthority> auths=new ArrayList<>();
        List<Role> roles=roleMapper.selectByUserId(id);
        for (Role role:roles){
            auths.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return auths;
    }

    public List<RoleTree> listTreeData(Integer roleId) {
        List<RoleTree> roleTrees = new ArrayList<>();
        EntityWrapper<Menu> ew1 = new EntityWrapper<>();
        ew1.addFilter("del_flag != -1 AND menu_type={0}", 1);
        List<Menu> menuList = menuMapper.selectList(ew1);

        for (Menu menu : menuList) {
            RoleTree roleTree = new RoleTree();
            roleTree.setId(menu.getId().toString());
            roleTree.setpId(menu.getParentId());
            roleTree.setName(menu.getMenuName());
            roleTree.setOpen("true");
            roleTree.setResFlag(menu.getId() + "_" + menu.getMenuType());
            roleTrees.add(roleTree);


            EntityWrapper<Menu> ew2 = new EntityWrapper<>();
            ew2.addFilter("del_flag != -1 AND menu_type={0} AND parent_id={1}", 2, menu.getId());
            List<Menu> subMenuList = menuMapper.selectList(ew2);
            for (Menu subMenu : subMenuList) {
                RoleTree subTree = new RoleTree();
                subTree.setId(subMenu.getId().toString());
                subTree.setpId(subMenu.getParentId());
                subTree.setName(subMenu.getMenuName());
                subTree.setOpen("true");
                subTree.setResFlag(subMenu.getId() + "_" + subMenu.getMenuType());
                roleTrees.add(subTree);
                EntityWrapper<Button> ew3 = new EntityWrapper<>();
                ew3.addFilter("del_flag != -1 AND menu_id={0} ", subMenu.getId());
                List<Button> buttonList = buttonMapper.selectList(ew3);
                for (Button button : buttonList) {
                    RoleTree butttonTree = new RoleTree();
                    butttonTree.setId(button.getMenuId() + "_" + button.getId());
                    butttonTree.setpId(button.getMenuId());
                    butttonTree.setName(button.getButtonName());
                    butttonTree.setOpen("true");
                    butttonTree.setResFlag(button.getId() + "_" + 3);
                    roleTrees.add(butttonTree);
                }
            }
        }


        Map<String, Object> map = new HashMap<>();
        map.put("role_id", roleId);
        List<RoleResource> roleResList = roleResourceMapper.selectByMap(map);
        for (RoleResource roleRes : roleResList) {
            String resFlag = roleRes.getResourceId() + "_" + roleRes.getResourceType();
            for (RoleTree tree : roleTrees) {
                if (resFlag.equals(tree.getResFlag())) {
                    tree.setChecked(true);
                    break;
                }
            }
        }
        return roleTrees;
    }

    public void editRight(String selRes, Integer roleId) {
        if (StringUtils.isNotBlank(selRes)) {
            List<RoleResource> list = new ArrayList<>();
            String[] resFlags = selRes.split(",");

            for (String resFlag : resFlags) {
                String[] resArr = resFlag.split("_");
                RoleResource roleResource = new RoleResource();
                roleResource.setRoleId(roleId);
                roleResource.setResourceId(Integer.valueOf(resArr[0]));
                roleResource.setResourceType(Integer.valueOf(resArr[1]));
                list.add(roleResource);
            }
            Map<String, Object> map = new HashMap<>();
            map.put("role_id", roleId);
            roleResourceMapper.deleteByMap(map);

            for (RoleResource rr:list){
                roleResourceMapper.insert(rr);
            }
        }
    }

    @Override
    public List<Role> selectRolesByUriAndMethod(String url, String method) {
        return roleMapper.selectRolesByUriAndMethod(url, method);
    }
}
