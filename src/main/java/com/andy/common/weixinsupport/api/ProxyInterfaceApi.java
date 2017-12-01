package com.andy.common.weixinsupport.api;

import com.andy.common.https.LocalHttpClient;
import com.andy.common.weixinsupport.model.BaseEntity;
import com.andy.common.weixinsupport.model.component.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;

import java.nio.charset.Charset;

/**
 * 第三方平台 (代公众号调用接口)
 */
public class ProxyInterfaceApi {
    
    private ProxyInterfaceApi(){}
    private static class Inner{
        public static final ProxyInterfaceApi instance = new ProxyInterfaceApi();
    }
    public static final ProxyInterfaceApi getInstance(){
        return Inner.instance;
    }

    private static final Log log = LogFactory.getLog(ProxyInterfaceApi.class);

    /**
     * 获取第三方平台access_token
     * @param componentAppid             第三方平台appid
     * @param componentAppsecret         第三方平台appsecret
     * @param componentVerifyTicket      微信后台推送的ticket
     * @return
     */
    public ComponentToken componentToken(String componentAppid, String componentAppsecret, String componentVerifyTicket){
        String postJsonData = String.format("{\"component_appid\":\"%1$s\" ,\"component_appsecret\": \"%2$s\",\"component_verify_ticket\": \"%3$s\"}",
                componentAppid,componentAppsecret,componentVerifyTicket);        
        log.info("method componentToken() param : postJsonData =  " + postJsonData);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(new BasicHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString()))
                .setUri("https://api.weixin.qq.com/cgi-bin/component/api_component_token")
                .setEntity(new StringEntity(postJsonData, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJSONResult(httpUriRequest, ComponentToken.class);
    }

    /**
     * 预授权码
     * @param componentAppid              第三方平台appid
     * @param componentAccessToken        第三方平台access_token
     * @return
     */
    public PreAuthCode preAuthCode(String componentAccessToken, String componentAppid){
        String postJsonData = String.format("{\"component_appid\":\"%1$s\"}", componentAppid);
        log.info("method preAuthCode() param : postJsonData =  "+postJsonData+" &componentAccessToken="+componentAccessToken);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(new BasicHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString()))
                .setUri("https://api.weixin.qq.com/cgi-bin/component/api_create_preauthcode")
                .addParameter("component_access_token", componentAccessToken)
                .setEntity(new StringEntity(postJsonData, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJSONResult(httpUriRequest, PreAuthCode.class);        
    }


    /**
     * 使用授权码换取公众号的授权信息
     * @param componentAccessToken          第三方平台access_token
     * @param componentAppid                第三方平台appid
     * @param authorizationCode             授权code,会在授权成功时返回给第三方平台
     * @return
     */
    public MpAuthorization mpAuthorization(String componentAccessToken, String componentAppid, String authorizationCode){
        String postJsonData = String.format("{\"component_appid\":\"%1$s\",\"authorization_code\":\"%2$s\"}",
                componentAppid,authorizationCode);
        log.info("method mpAuthorization() param : postJsonData =  "+postJsonData+" &componentAccessToken="+componentAccessToken);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(new BasicHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString()))
                .setUri("https://api.weixin.qq.com/cgi-bin/component/api_query_auth")
                .addParameter("component_access_token", componentAccessToken)
                .setEntity(new StringEntity(postJsonData, Charset.forName("utf-8")))
                .build();   
        return LocalHttpClient.executeJSONResult(httpUriRequest,MpAuthorization.class);
    }

    /**
     * 获取（刷新）授权公众号的令牌
     * @param componentAccessToken     第三方平台access_token
     * @param componentAppid           第三方平台appid
     * @param authorizerAppid          授权方appid
     * @param authorizerRefreshToken   授权方的刷新令牌
     * @return
     */
    public AuthorizerToken authorizerToken(String componentAccessToken, String componentAppid, String authorizerAppid, String authorizerRefreshToken){
        String postJsonData = String.format("{\"component_appid\":\"%1$s\",\"authorizer_appid\":\"%2$s\",\"authorizer_refresh_token\":\"%3$s\"}",
                componentAppid,authorizerAppid,authorizerRefreshToken);
        log.info("method authorizerToken() param : postJsonData =  "+postJsonData+" &componentAccessToken="+componentAccessToken);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(new BasicHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString()))
                .setUri("https://api.weixin.qq.com/cgi-bin/component/api_authorizer_token")
                .addParameter("component_access_token", componentAccessToken)
                .setEntity(new StringEntity(postJsonData, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJSONResult(httpUriRequest,AuthorizerToken.class);
    }

    /**
     * 获取授权方的账户信息
     * @param componentAccessToken    第三方平台access_token
     * @param componentAppid          第三方平台appid
     * @param authorizerAppid         授权方appid
     * @return
     */
    public MpAuthorization authorizerUser(String componentAccessToken, String componentAppid, String authorizerAppid){
        String postJsonData = String.format("{\"component_appid\":\"%1$s\",\"authorizer_appid\":\"%2$s\"}",
                componentAppid,authorizerAppid);
        log.info("method authorizerUser() param : postJsonData =  "+postJsonData+" &componentAccessToken="+componentAccessToken);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(new BasicHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString()))
                .setUri("https://api.weixin.qq.com/cgi-bin/component/api_get_authorizer_info")
                .addParameter("component_access_token", componentAccessToken)
                .setEntity(new StringEntity(postJsonData, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJSONResult(httpUriRequest,MpAuthorization.class);
    }

    /**
     * 获取授权方的选项设置信息
     * @param componentAccessToken     第三方平台access_token
     * @param componentAppid           第三方平台appid
     * @param authorizerAppid          授权方appid
     * @param optionName               选项名称
     * @return
     */
    public AuthorizerOption authorizerOption(String componentAccessToken, String componentAppid, String authorizerAppid, String optionName){
        String postJsonData = String.format("{\"component_appid\":\"%1$s\",\"authorizer_appid\":\"%2$s\",\"option_name\":\"%3$s\"}",
                componentAppid,authorizerAppid,optionName);
        log.info("method authorizerOption() param : postJsonData =  "+postJsonData+" &componentAccessToken="+componentAccessToken);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(new BasicHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString()))
                .setUri("https://api.weixin.qq.com/cgi-bin/component/api_get_authorizer_option")
                .addParameter("component_access_token", componentAccessToken)
                .setEntity(new StringEntity(postJsonData, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJSONResult(httpUriRequest,AuthorizerOption.class);
    }

    /**
     * 设置授权方的选项信息
     * @param componentAccessToken      第三方平台access_token
     * @param componentAppid            第三方平台appid
     * @param authorizerAppid           授权方appid
     * @param optionName                选项名称
     * @param optionValue               选项值
     * @return
     */
    public BaseEntity setAuthorizerOption(String componentAccessToken, String componentAppid, String authorizerAppid, String optionName, String optionValue){
        String postJsonData = String.format("{\"component_appid\":\"%1$s\",\"authorizer_appid\":\"%2$s\",\"option_name\":\"%3$s\",\"option_value\":\"%4$s\"}",
                componentAppid,authorizerAppid,optionName,optionValue);
        log.info("method setAuthorizerOption() param : postJsonData =  "+postJsonData+" &componentAccessToken="+componentAccessToken);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(new BasicHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString()))
                .setUri("https://api.weixin.qq.com/cgi-bin/component/api_set_authorizer_option")
                .addParameter("component_access_token", componentAccessToken)
                .setEntity(new StringEntity(postJsonData, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJSONResult(httpUriRequest,BaseEntity.class);
    }
}
