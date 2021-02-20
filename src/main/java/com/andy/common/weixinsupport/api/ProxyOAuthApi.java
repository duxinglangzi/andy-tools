package com.andy.common.weixinsupport.api;

import com.andy.common.https.LocalHttpClient;
import com.andy.common.weixinsupport.model.OAuthAccessToken;
import com.andy.common.weixinsupport.model.OAuthUserInfo;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 微信开放平台代公众号网页授权
 */
public class ProxyOAuthApi {
    private ProxyOAuthApi() {
    }

    private static class Inner {
        private static final ProxyOAuthApi instance = new ProxyOAuthApi();
    }

    public static final ProxyOAuthApi getInstance() {
        return Inner.instance;
    }

    /**
     * 生成网页授权 URL
     *
     * @param appid          (授权)公众号的AppId
     * @param redirectUri    重定向地址，需要urlencode，这里填写的应是服务开发方的回调地址
     * @param snsapiUserinfo 授权作用域
     * @param state          重定向后会带上state参数，开发者可以填写任意参数值，最多128字节
     * @param componentAppid (第三方开放平台)服务方的appid
     * @return
     */
    public String convertOauth2Authorize(String appid, String redirectUri, boolean snsapiUserinfo, String state, String componentAppid) {
        try {
            StringBuilder uri = new StringBuilder();
            uri.append("https://open.weixin.qq.com/connect/oauth2/authorize?")
                    .append("appid=").append(appid)
                    .append("&redirect_uri=").append(URLEncoder.encode(redirectUri, "utf-8"))
                    .append("&response_type=code")
                    .append("&scope=").append(snsapiUserinfo ? "snsapi_userinfo" : "snsapi_base")
                    .append("&state=").append(state == null ? "" : state);
            if (componentAppid != null) {
                uri.append("&component_appid=").append(componentAppid);
            }
            uri.append("#wechat_redirect");
            return uri.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过code换取access_token
     *
     * @param appid                公众号的appid
     * @param code                 获取的code参数
     * @param componentAccessToken 服务开发方的appid
     * @param componentAppid       服务开发方的access_token
     * @return
     */
    public OAuthAccessToken oAuthAccessToken(String appid, String code, String componentAccessToken, String componentAppid) {
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri("https://api.weixin.qq.com/sns/oauth2/component/access_token")
                .addParameter("appid", appid)
                .addParameter("code", code)
                .addParameter("grant_type", "authorization_code")
                .addParameter("component_appid", componentAppid)
                .addParameter("component_access_token", componentAccessToken)
                .build();
        return LocalHttpClient.executeJSONResult(httpUriRequest, OAuthAccessToken.class);
    }

    /**
     * 刷新access_token（如果需要）
     *
     * @param appid
     * @param refreshToken
     * @param componentAccessToken
     * @param componentAppid
     * @return
     */
    public OAuthAccessToken refreshAccessToken(String appid, String refreshToken, String componentAccessToken, String componentAppid) {
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri("https://api.weixin.qq.com/sns/oauth2/component/refresh_token")
                .addParameter("appid", appid)
                .addParameter("grant_type", "authorization_code")
                .addParameter("component_appid", componentAppid)
                .addParameter("component_access_token", componentAccessToken)
                .addParameter("refresh_token", refreshToken)
                .build();
        return LocalHttpClient.executeJSONResult(httpUriRequest, OAuthAccessToken.class);
    }

    /**
     * 通过网页授权access_token获取用户基本信息（需授权作用域为snsapi_userinfo --> access_token）
     *
     * @param accessToken 网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
     * @param openid      用户的唯一标识
     * @param lang        返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
     * @return
     */
    public OAuthUserInfo oAuthUserInfo(String accessToken, String openid, String lang) {
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri("https://api.weixin.qq.com/sns/userinfo")
                .addParameter("access_token", accessToken)
                .addParameter("openid", openid)
                .addParameter("lang", lang)
                .build();
        return LocalHttpClient.executeJSONResult(httpUriRequest, OAuthUserInfo.class);
    }
}
