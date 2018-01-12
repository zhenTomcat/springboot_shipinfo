package com.shipinfo.admin.security;

import com.shipinfo.admin.modules.sys.entity.Role;
import com.shipinfo.admin.modules.sys.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by zhen_Tomcat on 2017/12/25.
 */

public class SecurityUser extends User implements UserDetails{
    public  SecurityUser(User user){
        if (user!=null){
            this.setId(user.getId());
            this.setLoginName(user.getLoginName());
            this.setPassword(user.getPassword());
            this.setRoles(user.getRoles());
        }
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> auths=new ArrayList<>();
        List<Role> roles=this.getRoles();
        if(roles!=null){
            for (Role role:roles){
                auths.add(new SimpleGrantedAuthority(role.getRoleName()));
            }
        }
        return auths;
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getLoginName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
