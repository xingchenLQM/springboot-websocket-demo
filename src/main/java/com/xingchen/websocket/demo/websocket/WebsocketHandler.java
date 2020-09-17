package com.xingchen.websocket.demo.websocket;

import com.xingchen.websocket.demo.entity.WebsocketUser;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WebsocketHandler extends TextWebSocketHandler {

    private static Map<String, WebSocketSession> sessionPool = new ConcurrentHashMap<>();

    // 建立连接时候触发
    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        String username = getNameFromSession(session);
        System.out.println("连接用户：" + username);
        sessionPool.putIfAbsent(username, session);
    }


    // 关闭连接时候触发
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        String username = getNameFromSession(session);
        System.out.println("断开用户：" + username);
        sessionPool.remove(username);
    }

    // 处理消息
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // 防止中文乱码
        String msg = URLDecoder.decode(message.getPayload(), "utf-8");
        System.out.println(msg);
        String username = getNameFromSession(session);
        // 简单模拟群发消息
        TextMessage reply = new TextMessage(username + " : " + msg);
        sessionPool.forEach((s, webSocketSession)
                -> {
            try {
                webSocketSession.sendMessage(reply);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public static void sendMessage(String message, String username, String type) {
        TextMessage reply = new TextMessage(username + " : " + message);
        sessionPool.forEach((s, webSocketSession)
                -> {
            try {
                webSocketSession.sendMessage(reply);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }


    private String getNameFromSession(WebSocketSession session) {
        Map<String, Object> attributes = session.getAttributes();
        WebsocketUser user = (WebsocketUser) attributes.get("user");
        return user.getUsername();
    }
}
