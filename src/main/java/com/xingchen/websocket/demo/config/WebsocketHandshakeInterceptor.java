package com.xingchen.websocket.demo.config;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Map;

public class WebsocketHandshakeInterceptor extends HttpSessionHandshakeInterceptor {

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        InetSocketAddress remoteAddr = request.getRemoteAddress();
        InetAddress addr = remoteAddr.getAddress();
        System.out.println(addr);
        return super.beforeHandshake(request, response, wsHandler, attributes);
    }
}
