package com.shipinfo.admin.modules.sys.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.shipinfo.admin.modules.sys.entity.Button;
import com.shipinfo.admin.modules.sys.entity.Menu;
import com.shipinfo.admin.modules.sys.service.IButtonService;
import com.shipinfo.admin.modules.sys.service.IMenuService;
import com.shipinfo.admin.modules.sys.service.LoginService;
import com.shipinfo.admin.utils.Const;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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
@RequestMapping(value = "/right")
public class MenuController extends BaseController{

    /*
    * 查询 ：GET http://localhost:8080/right
    * 更新：PUT http://localhost:8080/right
    * 删除：DELETE http://localhost:8080/right/1
    * 添加：POST http://localhost:8080/right
    * */

    @Autowired
    private LoginService loginService;

    @Autowired
    private IMenuService menuService;

    @Autowired
    private IButtonService buttonService;

    //查询Menu信息
    @GetMapping
    @ApiOperation("查询菜单信息")
    public JSONObject subMenu(@ApiParam("菜单级别") @RequestParam(required = false) String menuType,
                              @RequestParam(required = false) Integer parentId,
                              @RequestParam(required = false) String menuName) {
        EntityWrapper<Menu> ew1 = getEntityWrapper();
        if (menuType != null)
            ew1.addFilter("menu_type={0}", menuType);
        if (parentId != null)
            ew1.addFilter("parent_id={0}", parentId);
        if (!StringUtils.isEmpty(menuName))
            ew1.addFilter("CONCAT(IFNULL(menu_name,''),IFNULL(menu_url,'')) like {0}", "%" + menuName + "%");
        return jsonPage(menuService.selectPage(getPage(), ew1));
    }

    //添加Menu信息
    @PostMapping
    @ApiOperation("添加菜单信息")
    public JSONObject addMenu(@RequestBody Menu menu) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 200);
        menu.setDelFlag(Const.DEL_FLAG_NORMAL);
        menuService.insert(menu);
        return jsonObject;
    }

    //更新菜单信息
    @PutMapping
    @ApiOperation("更新菜单信息")
    public JSONObject editMenu(@RequestBody Menu menu) {
        JSONObject jsonObject = new JSONObject();
        menuService.updateById(menu);
        jsonObject.put("status", 200);
        return jsonObject;
    }

    @GetMapping("/{id}")
    @ApiOperation("根据菜单id，获取信息")
    public Menu toEditMenu(@PathVariable Integer id) {
        Menu menu = menuService.selectById(id);
        return menu;
    }

    @DeleteMapping("/{id}")
    @ApiOperation("根据菜单id，删除信息")
    public JSONObject deleteMenu(@PathVariable Integer id) {
        menuService.deleteById(id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 200);
        return jsonObject;
    }

    @DeleteMapping(value = "/batch/{ids}")
    @ApiOperation("批量删除惨淡信息")
    public JSONObject batchDeleteMenu(@PathVariable String ids) {
        JSONObject jsonObject = new JSONObject();
        menuService.deleteBatchIds(Arrays.asList(ids.split(",")));
        jsonObject.put("status", 200);
        return jsonObject;
    }

    /************************Button*****************************/

    @ApiOperation("查看当前菜单里，资源信息")
    @GetMapping(value = "/{id}/button")
    public JSONObject listBtn(@ApiParam("菜单id") @PathVariable Integer id,
                              @ApiParam("搜索条件") @RequestParam String keyword) {
        EntityWrapper<Button> ew = new EntityWrapper<>();
        ew.where("del_flag={0}", Const.DEL_FLAG_NORMAL);
        ew.addFilter("menu_id={0}", id);
        if (!StringUtils.isEmpty(keyword))
            ew.addFilter(" CONCAT(IFNULL(button_name,''),IFNULL(button_url,'')) like {0}", "%" + keyword + "%");
        return jsonPage(buttonService.selectPage(getPage(), ew));
    }

    //添加按钮信息
    @PostMapping(value = "/button")
    @ApiOperation("添加资源信息")
    public JSONObject addBtn(@RequestBody Button button) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 200);
        button.setDelFlag(Const.DEL_FLAG_NORMAL);
        buttonService.insert(button);
        return jsonObject;
    }

    //更新按钮信息
    @PutMapping(value = "/button")
    @ApiOperation("更新资源信息")
    public JSONObject editBtn(@RequestBody Button button) {
        JSONObject jsonObject = new JSONObject();
        buttonService.updateById(button);
        jsonObject.put("status", 200);
        return jsonObject;
    }

    //根据按钮id删除
    @ApiOperation("删除button信息")
    @DeleteMapping("/button/{id}}")
    public JSONObject deleteBtn(@PathVariable Integer id) {
        buttonService.deleteById(id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 200);
        return jsonObject;
    }

    @ApiOperation("根据id，获取button信息")
    @GetMapping("/button/{id}")
    public Button getButton(@PathVariable String id) {
        Button button=buttonService.selectById(id);
        return button;
    }

    @ApiOperation("批量删除button信息")
    @DeleteMapping(value = "/button/batch/{ids}}")
    public JSONObject batchDeleteBtn(@PathVariable String ids) {
        JSONObject jsonObject = new JSONObject();
        buttonService.deleteBatchIds(Arrays.asList(ids.split(",")));
        jsonObject.put("status", 200);
        return jsonObject;
    }
}

