package com.andy.common.weixinsupport.model;

import java.io.Serializable;


public class BaseEntity implements Serializable{

	private static final long serialVersionUID = -4830335976041382725L;
	
	protected String errcode;
	protected String errmsg;
	
	public String getErrcode() {
		return errcode;		
	}
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	
	
}
