package com.andy.common.es;

import com.alibaba.fastjson.JSON;
import com.andy.common.https.LocalHttpClient;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;

import java.nio.charset.Charset;

/**
 * <p>Description: ES 请求工具类  </p>
 *
 * @author wuqiong  2017年6月7日
 */
public class EsRequestApi {

    private static final Log log = LogFactory.getLog(EsRequestApi.class);

    public EsRequestApi() {
    }

    private static class Inner {
        public static final EsRequestApi requetApi = new EsRequestApi();
    }

    public static final EsRequestApi getInstance() {
        return Inner.requetApi;
    }

    /**
     * 方法描述: 集中请求es 服务器
     *
     * @param esUrl es服务器域名地址
     * @param args  参数
     * @param clazz 返回数据泛型类
     * @return EsPostResponse
     * @author wuqiong 2017年6月7日 下午4:25:26
     */
    public EsPostResponse getEsPostResponse(String esUrl, String args, Class<? extends EsDataModel> clazz) {
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(new BasicHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_FORM_URLENCODED.toString()))
                .setUri(esUrl)
                .setEntity(new StringEntity(args, Charset.forName("utf-8")))
                .build();
        EsPostResponse res = LocalHttpClient.executeEsResult(httpUriRequest, clazz);
        log.info(String.format("EsRequestApi==>> esUrl:%s  args:%s  className:%s  res:%s", esUrl, args, clazz.getName(), JSON.toJSONString(res)));
        return res;
    }

}
