package com.shipinfo.admin.modules.sys.mapper;

import com.shipinfo.admin.modules.sys.entity.Menu;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhenTomcat
 * @since 2017-12-22
 */
public interface MenuMapper extends BaseMapper<Menu> {


    List<Menu> selectAllMenus(Integer id);

    List<Menu> findParentMenusByUserId(int userId);

    List<Menu> findMenusByUserIdAndParent(Map<?, ?> params);

}
