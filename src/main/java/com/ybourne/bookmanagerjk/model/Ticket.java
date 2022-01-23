package com.ybourne.bookmanagerjk.model;

import lombok.Data;

import java.util.Date;

@Data
public class Ticket {

    private int id;

    /**
     * 绑定的userId
     */
    private int userId;

    /**
     * 票实体
     */
    private String ticket;

    /**
     * 过期时间
     */
    private Date expiredAt;
}
