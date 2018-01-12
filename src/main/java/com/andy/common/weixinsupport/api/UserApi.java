package com.andy.common.weixinsupport.api;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.andy.common.https.LocalHttpClient;
import com.andy.common.weixinsupport.model.WXUserInfo;
import com.andy.common.weixinsupport.model.WXUserInfoList;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import java.nio.charset.Charset;
import java.util.List;


/**
 * <p>ClassName: 本方法 实现了基础公众号  获取用户信息的 接口 </p> 
 * <p>Description: 描述该类实现了什么功能 </p>
 * @author wuqiong  2015年11月10日
 */
public class UserApi {
	
	private UserApi(){}
    private static class Inner{
        public static final UserApi instance = new UserApi();
    }
    public static final UserApi getInstance(){
        return Inner.instance;
    }
	
    
    /**
     * 方法描述:获取用户 基本信息接口
     * @param accessToken      公众号token  包含开放平台信息的方式
     * @param openid		       用户的唯一标识
     * @param lang			       返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
     * @return WXUserInfo
     * @author wuqiong 2015年11月10日  下午3:32:04
     */
    public WXUserInfo getWXUserInfo(String accessToken, String openid, String lang){
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri("https://api.weixin.qq.com/cgi-bin/user/info")
                .addParameter("access_token", accessToken)
                .addParameter("openid", openid)
                .addParameter("lang",lang)
                .build();
        return LocalHttpClient.executeJSONResult(httpUriRequest,WXUserInfo.class);
    }
    
    
    /**
     * 方法描述:批量获取用户 基本信息接口
     * @param accessToken      公众号token  包含开放平台信息的方式
     * @param openids		       用户的唯一标识
     * @return WXUserInfo
     * @author wuqiong 2017年4月10日 下午4:17:41
     */
    public List<WXUserInfo> getWXUserInfoList(String accessToken, String[] openids){
    	JSONArray arr=new JSONArray();
    	for(String str:openids){
    		JSONObject json=new JSONObject();
    		json.put("openid", str);
    		json.put("lang", "zh-CN");
    		arr.add(json);
    	}
    	JSONObject requestJson=new JSONObject();
    	requestJson.put("user_list", arr);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri("https://api.weixin.qq.com/cgi-bin/user/info/batchget")
                .addParameter("access_token", accessToken)
                .setEntity(new StringEntity(requestJson.toJSONString(), Charset.forName("utf-8")))
                .build();
        WXUserInfoList infoList=LocalHttpClient.executeJSONResult(httpUriRequest,WXUserInfoList.class);
        return (infoList.getErrcode()==null || "0".equals(infoList.getErrcode()))?infoList.getUser_info_list():null;
    }
    
}
