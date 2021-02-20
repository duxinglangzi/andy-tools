package com.andy.common.weixinsupport.api;

import com.andy.common.https.LocalHttpClient;
import com.andy.common.weixinsupport.model.Ticket;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;

public class TicketAPI {

    private TicketAPI() {
    }

    private static class Inner {
        private static final TicketAPI instance = new TicketAPI();
    }

    public static final TicketAPI getInstance() {
        return Inner.instance;
    }

    public Ticket jsTicket(String access_token) {
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri("https://api.weixin.qq.com/cgi-bin/ticket/getticket")
                .addParameter("access_token", access_token)
                .addParameter("type", "jsapi")
                .build();
        return LocalHttpClient.executeJSONResult(httpUriRequest, Ticket.class);
    }

    public Ticket cardTicket(String access_token) {
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri("https://api.weixin.qq.com/cgi-bin/ticket/getticket")
                .addParameter("access_token", access_token)
                .addParameter("type", "wx_card")
                .build();
        return LocalHttpClient.executeJSONResult(httpUriRequest, Ticket.class);
    }
}
