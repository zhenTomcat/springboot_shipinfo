//package com.shipinfo.admin.security;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.apache.commons.collections.MapUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.crypto.codec.Base64;
//import org.springframework.security.oauth2.common.OAuth2AccessToken;
//import org.springframework.security.oauth2.common.exceptions.UnapprovedClientAuthenticationException;
//import org.springframework.security.oauth2.provider.*;
//import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
//import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
//import org.springframework.stereotype.Service;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///*
//*
// * Created by zhen_Tomcat on 2017/12/25.
//*/
//
//
//@Service
//public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{
//
//    @Autowired
//    private ClientDetailsService clientDetailsService;
//
//
//    @Autowired
//    private AuthorizationServerTokenServices authorizationServerTokenServices;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
//
//        String header = request.getHeader("Authorization");
//        if(header == null && !header.startsWith("Basic ")) {
//            throw new UnapprovedClientAuthenticationException("请求头中无client信息");
//        }
//        String[] info = this.extractAndDecodeHeader(header, request);
//
//        assert info.length == 2;
//
//        String clientId = info[0];
//        String clientSecret=info[1];
//
//        ClientDetails clientDetails=clientDetailsService.loadClientByClientId(clientId);
//        if (!clientDetails.getClientSecret().equals(clientSecret)){
//            throw new UnapprovedClientAuthenticationException("client信息有错，请核对");
//        }
//
//        TokenRequest tokenRequest = new TokenRequest(MapUtils.EMPTY_MAP, clientId, clientDetails.getScope(), "custom");
//
//        OAuth2Request oAuth2Request=tokenRequest.createOAuth2Request(clientDetails);
//
//        OAuth2Authentication oAuth2Authentication=new OAuth2Authentication(oAuth2Request,authentication);
//        OAuth2AccessToken token=authorizationServerTokenServices.createAccessToken(oAuth2Authentication);
//        response.getWriter().write(objectMapper.writeValueAsString(token));
//    }
//
//    public String getIpAddress(HttpServletRequest request) {
//        String ip = request.getHeader("x-forwarded-for");
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("Proxy-Client-IP");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("WL-Proxy-Client-IP");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("HTTP_CLIENT_IP");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getRemoteAddr();
//        }
//        return ip;
//    }
//
//    private String[] extractAndDecodeHeader(String header, HttpServletRequest request) throws IOException {
//        byte[] base64Token = header.substring(6).getBytes("UTF-8");
//
//        byte[] decoded;
//        try {
//            decoded = Base64.decode(base64Token);
//        } catch (IllegalArgumentException var7) {
//            throw new BadCredentialsException("Failed to decode basic authentication token");
//        }
//
//        String token = new String(decoded, "UTF-8");
//        int delim = token.indexOf(":");
//        if(delim == -1) {
//            throw new BadCredentialsException("Invalid basic authentication token");
//        } else {
//            return new String[]{token.substring(0, delim), token.substring(delim + 1)};
//        }
//    }
//}
