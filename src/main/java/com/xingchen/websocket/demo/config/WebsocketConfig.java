package com.xingchen.websocket.demo.config;

import com.xingchen.websocket.demo.websocket.WebsocketHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebsocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new WebsocketHandler(), "/socket")
                .setAllowedOrigins("*")
                .addInterceptors(new WebsocketHandshakeInterceptor());

    }
}
