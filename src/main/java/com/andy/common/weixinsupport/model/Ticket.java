package com.andy.common.weixinsupport.model;

public class Ticket extends BaseEntity {

    private static final long serialVersionUID = -3801392469910738546L;

    private String ticket;

    private Integer expires_in;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Integer getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
    }


}
