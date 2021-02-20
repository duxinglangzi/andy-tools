package com.andy.common.weixinsupport.api;

import com.andy.common.https.LocalHttpClient;
import com.andy.common.weixinsupport.model.QrcodeTicket;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * 二维码获取API
 */
public class QrcodeTicketApi {

    private QrcodeTicketApi() {
    }

    private static class Inner {
        private static final QrcodeTicketApi instance = new QrcodeTicketApi();
    }

    public static final QrcodeTicketApi getInstance() {
        return Inner.instance;
    }

    private static final Log log = LogFactory.getLog(QrcodeTicketApi.class);

    /**
     * 创建二维码ticket
     *
     * @param access_token 授权令牌
     * @param qrcodeJson   JSON数据
     * @return
     */
    public QrcodeTicket qrcodeCreate(String access_token, String qrcodeJson) {
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(new BasicHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString()))
                .setUri("https://api.weixin.qq.com/cgi-bin/qrcode/create")
                .addParameter("access_token", access_token)
                .setEntity(new StringEntity(qrcodeJson, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJSONResult(httpUriRequest, QrcodeTicket.class);
    }

    /**
     * 创建二维码ticket
     *
     * @param access_token   授权令牌
     * @param expire_seconds 该二维码有效时间，以秒为单位。 最大不超过604800（即7天）
     * @param action_name    二维码类型，QR_SCENE为临时,QR_LIMIT_SCENE为永久,QR_LIMIT_STR_SCENE为永久的字符串参数值
     * @param scene_id       场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
     * @return
     */
    public QrcodeTicket qrcodeCreate(String access_token, Integer expire_seconds, String action_name, long scene_id) {
        String qrcodeJson = String.format("{" + (expire_seconds == null ? "%1$s" : "\"expire_seconds\": %1$s, ") + "\"action_name\": \"%2$s\", \"action_info\": {\"scene\": {\"scene_id\": %3$d}}}",
                expire_seconds == null ? "" : expire_seconds, action_name, scene_id);
        return qrcodeCreate(access_token, qrcodeJson);
    }


    /**
     * 创建二维码ticket(临时二维码)
     *
     * @param access_token   授权令牌
     * @param expire_seconds 该二维码有效时间，以秒为单位。 最大不超过604800（即7天）
     * @param scene_id       场景值ID，临时二维码时为32位非0整型
     * @return
     */
    public QrcodeTicket qrcodeCreateTemp(String access_token, int expire_seconds, long scene_id) {
        return qrcodeCreate(access_token, expire_seconds, "QR_SCENE", scene_id);
    }

    /**
     * 创建二维码ticket(永久二维码)
     *
     * @param access_token 授权令牌
     * @param scene_id     场景值ID，永久二维码时最大值为100000（目前参数只支持1--100000）
     * @return
     */
    public QrcodeTicket qrcodeCreateForever(String access_token, int scene_id) {
        return qrcodeCreate(access_token, null, "QR_LIMIT_SCENE", scene_id);
    }

    /**
     * 创建二维码ticket(永久二维码)
     *
     * @param access_token 授权令牌
     * @param scene_str    场景值ID（字符串形式的ID），字符串类型，长度限制为1到64，仅永久二维码支持此字段 QR_LIMIT_STR_SCENE
     * @return
     */
    public QrcodeTicket qrcodeCreateForever(String access_token, String scene_str) {
        String qrcodeJson = String.format("{" + "\"action_name\": \"%1$s\", \"action_info\": {\"scene\": {\"scene_str\":\"%2$s\"}}}", "QR_LIMIT_STR_SCENE", scene_str);
        log.info(">>>>qrcodeCreateForever.qrcodeJson:" + qrcodeJson);
        return qrcodeCreate(access_token, qrcodeJson);
    }

    /**
     * 通过ticket换取二维码
     *
     * @param ticket TICKET记得进行UrlEncode
     * @return
     */
    public byte[] showQrcode(String ticket) {
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri("https://mp.weixin.qq.com/cgi-bin/showqrcode")
                .addParameter("ticket", ticket)
                .build();
        HttpResponse httpResponse = LocalHttpClient.execute(httpUriRequest);
        try {
            return EntityUtils.toByteArray(httpResponse.getEntity());
        } catch (IOException e) {
            log.info("通过ticket换取二维码异常：" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
