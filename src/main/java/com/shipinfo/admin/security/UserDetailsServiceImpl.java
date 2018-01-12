package com.shipinfo.admin.security;

import com.shipinfo.admin.modules.sys.entity.User;
import com.shipinfo.admin.modules.sys.service.IRoleService;
import com.shipinfo.admin.modules.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/*
*
 * Created by zhen_Tomcat on 2017/12/22.

*/

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userService.selectUserByUsername(username);
        if (user==null){
            throw new UsernameNotFoundException("Usrname "+username+" not found");
        }

        return new SecurityUser(user);
    }
}
