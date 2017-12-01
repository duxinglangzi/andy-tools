package com.andy.common.weixinsupport.model.component;

import com.andy.common.weixinsupport.model.BaseEntity;

public class ComponentToken extends BaseEntity {

	private static final long serialVersionUID = 4288682848275677830L;

	private String component_access_token;

	private int expires_in;

	public String getComponent_access_token() {
		return component_access_token;
	}

	public void setComponent_access_token(String component_access_token) {
		this.component_access_token = component_access_token;
	}

	public int getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}


}
