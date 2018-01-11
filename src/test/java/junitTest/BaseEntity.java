package junitTest;

import java.io.Serializable;

/**
 * <p>ClassName: 请求钉钉接口 返回参数基础类 </p>
 * <p>Description: </p>
 * <p>Company:雅座在线（北京）科技发展有限公司 </p>
 * <p>@author wuqiong  2018/1/10 14:24 </p>
 */
public class BaseEntity implements Serializable{
    private static final long serialVersionUID = 7314967460997900002L;

    protected Integer errcode;      //返回状态码
    protected String errmsg;        //返回状态,
    protected Boolean hasMore;      //是否有下一页

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }



}
