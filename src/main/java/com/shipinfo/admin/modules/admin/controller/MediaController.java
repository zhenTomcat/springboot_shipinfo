package com.shipinfo.admin.modules.admin.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.shipinfo.admin.modules.admin.entity.Media;
import com.shipinfo.admin.modules.admin.service.IMediaService;
import com.shipinfo.admin.modules.sys.controller.BaseController;
import com.shipinfo.admin.utils.Const;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhenTomcat
 * @since 2018-01-05
 */
@RestController
@RequestMapping(value = "/file")
public class MediaController extends BaseController{

    @Autowired
    private IMediaService mediaService;

    @GetMapping
    @ApiOperation("查询所有的文件信息")
    public JSONObject list(){
        EntityWrapper<Media> ew=getEntityWrapper();
        ew.addFilter("status<>{0}", Const.FILE_SHIP);
        Page<Media> page = mediaService.selectPage(getPage(),ew);
        return jsonPage(page);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("根据id删除文件信息")
    public JSONObject delteMedia(@PathVariable Integer id){
        JSONObject jsonObject = new JSONObject();
        try {
            Media media = mediaService.selectById(id);
            media.setDelFlag(Const.DEL_FLAG_DELETE);
            mediaService.updateById(media);
            jsonObject.put("status", 200);
        } catch (Exception e) {
            jsonObject.put("status", 500);
            jsonObject.put("msg", "删除错误，请稍后再试");
        }

        return jsonObject;
    }

    @PostMapping
    @ApiOperation("添加文件的信息")
    public JSONObject add(@RequestBody Media media) {
        JSONObject jsonObject = new JSONObject();
        media.setDelFlag(Const.DEL_FLAG_NORMAL);
        media.setCreateDate(new Date());
        mediaService.insert(media);
        jsonObject.put("mediaId",media.getId());

        return jsonObject;
    }

    @PutMapping
    @ApiOperation("修改文件的信息")
    public JSONObject edit(@RequestBody Media media){
        JSONObject jsonObject = new JSONObject();

        try {
            Media m = mediaService.selectById(media.getId());
            m.setUpdateDate(new Date());
            m.setFileName(media.getFileName());
            m.setFileDes(media.getFileDes());
            m.setStatus(media.getStatus());
            mediaService.updateById(m);

            jsonObject.put("status", 200);
        } catch (Exception e) {
            jsonObject.put("status", 500);
        }
        return jsonObject;
    }

    @GetMapping(value = "/download")
    public JSONObject downloadList() {
        JSONObject jsonObject = new JSONObject();
        EntityWrapper<Media> ew = new EntityWrapper();
        ew.addFilter("del_flag = 0 and status = {0}", Const.FILE_DOWNLOAD);
        List<Media> list = mediaService.selectList(ew);
        jsonObject.put("list", list);
        return jsonObject;
    }

}

