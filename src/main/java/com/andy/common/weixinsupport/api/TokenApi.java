package com.andy.common.weixinsupport.api;

import com.andy.common.https.LocalHttpClient;
import com.andy.common.weixinsupport.model.Token;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;


public class TokenApi {

    private TokenApi(){}
    private static class Inner{
        public static final TokenApi instance = new TokenApi();
    }
    public static final TokenApi getInstance(){
        return Inner.instance;
    }
	/**
	 * AccessToken
	 * @param appId
	 * @param appSecret
	 * @return
	 */
	public Token token(String appId, String appSecret){
		HttpUriRequest httpUriRequest = RequestBuilder.get()
				.setUri("https://api.weixin.qq.com/cgi-bin/token")
				.addParameter("grant_type","client_credential")
				.addParameter("appid", appId)
				.addParameter("secret", appSecret)
				.build();
		return LocalHttpClient.executeJSONResult(httpUriRequest,Token.class);
	}

}
