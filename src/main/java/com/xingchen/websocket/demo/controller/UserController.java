package com.xingchen.websocket.demo.controller;

import com.xingchen.websocket.demo.entity.WebsocketUser;
import com.xingchen.websocket.demo.websocket.WebsocketHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @PostMapping("/login")
    public String login(@RequestBody WebsocketUser user, HttpServletRequest request, HttpSession session) {
        System.out.println(user);
        System.out.println(request.getHeader("User-Agent"));
        System.out.println(request.getRemoteAddr());
        System.out.println(request.getRemoteHost());
        System.out.println(request.getRemotePort());
        System.out.println(request.getRemoteUser());
        System.out.println(request.getLocalAddr());
        System.out.println(request.getLocalPort());
        System.out.println(request.getRequestURI());
        session.setAttribute("user", user);

        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
            System.out.println("ip"+ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
            System.out.println("ip"+ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
            System.out.println("ip"+ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            System.out.println("ip"+ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            System.out.println("ip"+ip);
        }


        return "success";
    }

    @GetMapping("/sendMessage")
    public String sendMessage(String message) {
        WebsocketHandler.sendMessage(message, "444", "1");
        return "success";
    }
}
