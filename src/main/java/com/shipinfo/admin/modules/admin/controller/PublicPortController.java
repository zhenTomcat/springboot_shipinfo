package com.shipinfo.admin.modules.admin.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.shipinfo.admin.modules.admin.entity.PublicPort;
import com.shipinfo.admin.modules.admin.service.IPublicPortService;
import com.shipinfo.admin.modules.sys.controller.BaseController;
import com.shipinfo.admin.utils.Const;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhenTomcat
 * @since 2018-01-05
 */
@RestController
@RequestMapping(value = "/port")
public class PublicPortController extends BaseController {

    @Autowired
    private IPublicPortService publicPortService;

    @GetMapping
    @ApiOperation("查询港口信息")
    public JSONObject list(@ApiParam("sql拼写的语句")@RequestParam(required = false) String sqlWhere) {
        EntityWrapper<PublicPort> ew = getEntityWrapper();
        if (StringUtils.isNotEmpty(sqlWhere)) {
            ew.addFilter(sqlWhere);
        }
        HttpServletRequest a = getRequest();
        Page<PublicPort> portPage = publicPortService.selectPage(getPage(), ew);
        return jsonPage(portPage);
    }

    @PostMapping
    @ApiOperation("添加港口信息")
    public JSONObject add(@RequestBody PublicPort publicPort) {
        JSONObject jsonObject = new JSONObject();
        if(publicPortService.insert(publicPort)){
            jsonObject.put("status",200);
        }else {
            jsonObject.put("status",500);
        }
        return jsonObject;
    }

    @GetMapping("/{id}")
    @ApiOperation("根据港口id，获取港口信息")
    public PublicPort get(@PathVariable Integer id) {
        PublicPort port=publicPortService.selectById(id);
        return port;
    }

    @PutMapping
    @ApiOperation("更新港口信息")
    public JSONObject edit(@RequestBody PublicPort publicPort) {
        JSONObject jsonObject = new JSONObject();
        publicPort.setUpdateDate(new Date());
        if(publicPortService.updateById(publicPort)){
            jsonObject.put("status",200);
        }else {
            jsonObject.put("status",500);
        }
        return jsonObject;
    }

    @RequestMapping(value = "/{id}")
    @ApiOperation("删除港口信息")
    public JSONObject delete(@PathVariable Integer id) {
        JSONObject jsonObject = new JSONObject();
        PublicPort publicPort=publicPortService.selectById(id);
        publicPort.setDelFlag(Const.DEL_FLAG_DELETE);
        if (publicPortService.updateById(publicPort)) {
            jsonObject.put("status", 200);
        }else {
            jsonObject.put("status",500);
        }
        return jsonObject;
    }

}

