package com.shipinfo.admin.modules.sys.mapper;

import com.shipinfo.admin.modules.sys.entity.Button;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhenTomcat
 * @since 2017-12-22
 */
public interface ButtonMapper extends BaseMapper<Button> {

    List<Button> selectAllButtons(Integer id);

    List<Button> findButtonsByUserId(Integer userId);
}
