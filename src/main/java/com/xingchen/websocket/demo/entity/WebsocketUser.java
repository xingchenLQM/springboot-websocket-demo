package com.xingchen.websocket.demo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class WebsocketUser implements Serializable {
    private String username;
    private String password;
    private Integer userType;
}
