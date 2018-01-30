package com.shipinfo.admin.security;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.shipinfo.admin.modules.sys.entity.Button;
import com.shipinfo.admin.modules.sys.entity.Menu;
import com.shipinfo.admin.modules.sys.entity.Role;
import com.shipinfo.admin.modules.sys.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import javax.annotation.PostConstruct;
import java.util.*;

/*
*
 * Created by zhen_Tomcat on 2017/12/21.

*/



@Service
public class MyInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource{

    @Autowired
    private IRoleService roleService;


    private AntPathMatcher antPathMatcher=new AntPathMatcher();


//    private static Map<String,Collection<ConfigAttribute>> resourceMap=new HashMap<>();


/*    //查询所有的资源和权限的对应关系
    @PostConstruct
    private void loadResourceDefine(){
        List<Role> roles=roleService.selectAllRoles();
        if (roles!=null){
            for (Role role:roles){
                ConfigAttribute ca = new SecurityConfig(role.getRoleName());

                for(Button button:role.getButtons()){
                    String url=button.getButtonUrl();
                    addUrlResourceMap(url,ca);
                }

                for(Menu menu:role.getMenus()){
                    String url=menu.getMenuUrl();
                    if(!url.trim().equals("#")){
                        addUrlResourceMap(url,ca);
                    }
                }
            }
        }
    }*/

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {

        String requestUri = ((FilterInvocation) o).getRequestUrl();

        String authorize=((FilterInvocation) o).getRequest().getHeader("Authorization");

        if (requestUri.contains("?")){
            requestUri=requestUri.substring(0,requestUri.indexOf("?"));
        }
        requestUri= requestUri.replaceAll( "[\\d]+","\\{\\*\\}");

        String method= ((FilterInvocation) o).getRequest().getMethod();
        List<Role> roles=roleService.selectRolesByUriAndMethod(requestUri,method);

        if (roles!=null && roles.size()>0){
            Collection<ConfigAttribute> attrs=new ArrayList<>();
            for (Role r:roles){
                attrs.add(new SecurityConfig(r.getRoleName()));
            }
            return attrs;
        }
        //直接放行，不去执行MyAccessDecisionManager
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return new ArrayList<ConfigAttribute>();
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

}
