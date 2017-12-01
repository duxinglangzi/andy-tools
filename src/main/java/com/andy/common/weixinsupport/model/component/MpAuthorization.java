package com.andy.common.weixinsupport.model.component;

public class MpAuthorization {

	private AuthorizerInfo authorizer_info;

	private String qrcode_url;

	private AuthorizationInfo authorization_info;

	public AuthorizerInfo getAuthorizer_info() {
		return authorizer_info;
	}

	public void setAuthorizer_info(AuthorizerInfo authorizer_info) {
		this.authorizer_info = authorizer_info;
	}

	public String getQrcode_url() {
		return qrcode_url;
	}

	public void setQrcode_url(String qrcode_url) {
		this.qrcode_url = qrcode_url;
	}

	public AuthorizationInfo getAuthorization_info() {
		return authorization_info;
	}

	public void setAuthorization_info(AuthorizationInfo authorization_info) {
		this.authorization_info = authorization_info;
	}



}
