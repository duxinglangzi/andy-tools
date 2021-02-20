package com.andy.common.weixinsupport.model;

import java.util.List;

/**
 * <p>Description: 批量获取用户信息接口 </p>
 *
 * @author wuqiong  2017年4月13日
 */
public class WXUserInfoList extends BaseEntity {

    private static final long serialVersionUID = -1829975641846026658L;

    private List<WXUserInfo> user_info_list;

    public List<WXUserInfo> getUser_info_list() {
        return user_info_list;
    }

    public void setUser_info_list(List<WXUserInfo> user_info_list) {
        this.user_info_list = user_info_list;
    }
}
