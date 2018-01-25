package com.shipinfo.admin.config.jwt;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhen_Tomcat on 2018/01/24.
 */
public class JwtTokenEnhancer implements TokenEnhancer{
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken auth2AccessToken, OAuth2Authentication authentication) {
        Map<String,Object> info=new HashMap<>();
        info.put("company","上海岙洋船务服务有限公司");

        /*因为OAuth2AccessToken是接口，他的默认实现的token，是DefaultOAuth2AccessToken，
        * 转换一下，添加一些附加信息，这样就将自定义信息添加到token里面*/
        ((DefaultOAuth2AccessToken)auth2AccessToken).setAdditionalInformation(info);
        return auth2AccessToken;
    }
}
