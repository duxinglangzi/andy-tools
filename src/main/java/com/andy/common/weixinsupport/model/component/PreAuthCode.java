package com.andy.common.weixinsupport.model.component;


import com.andy.common.weixinsupport.model.BaseEntity;


public class PreAuthCode extends BaseEntity {

    private static final long serialVersionUID = -7884433341039724958L;

    private String pre_auth_code;
    private int expires_in;

    public String getPre_auth_code() {
        return pre_auth_code;
    }

    public void setPre_auth_code(String pre_auth_code) {
        this.pre_auth_code = pre_auth_code;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }


}
