package com.shipinfo.admin.modules.sys.mapper;

import com.shipinfo.admin.modules.sys.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhenTomcat
 * @since 2017-12-22
 */
public interface UserMapper extends BaseMapper<User> {

    User selectUserByUsername(String username);

}
