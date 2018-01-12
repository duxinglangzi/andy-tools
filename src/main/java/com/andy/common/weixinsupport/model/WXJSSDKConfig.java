package com.andy.common.weixinsupport.model;


/**
 * <p>ClassName: 微信页面签名 </p> 
 * <p>Description: 描述该类实现了什么功能 </p>
 * @author wuqiong  2015年9月28日
 */
public class WXJSSDKConfig {
	
	private String appId;        // 必填，公众号的唯一标识
	private String timestamp;    // 必填，生成签名的时间戳
	private String nonceStr;     // 必填，生成签名的随机串
	private String signature;    // 必填，签名
	
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getNonceStr() {
		return nonceStr;
	}
	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	
}
