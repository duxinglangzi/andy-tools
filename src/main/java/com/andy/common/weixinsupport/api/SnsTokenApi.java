package com.andy.common.weixinsupport.api;

import com.andy.common.https.LocalHttpClient;
import com.andy.common.weixinsupport.model.OAuthAccessToken;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;


public class SnsTokenApi {

    private SnsTokenApi(){}
    private static class Inner{
        public static final SnsTokenApi instance = new SnsTokenApi();
    }
    public static final SnsTokenApi getInstance(){
        return Inner.instance;
    }
    
	/**
	 * 通过code换取网页授权access_token
	 * @param appid
	 * @param secret
	 * @param code
	 * @return
	 */
	public OAuthAccessToken oauth2AccessToken(String appid, String secret, String code){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setUri("https://api.weixin.qq.com/sns/oauth2/access_token")
                .addParameter("grant_type", "authorization_code")
                .addParameter("appid",appid)
                .addParameter("secret",secret)
                .addParameter("code",code)
                .build();
		return LocalHttpClient.executeJSONResult(httpUriRequest, OAuthAccessToken.class);
	}
}
