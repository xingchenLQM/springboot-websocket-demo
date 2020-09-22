package com.xingchen.websocket.demo.webservice;

import javax.jws.WebService;
import java.time.LocalDateTime;

@WebService(serviceName = "WebDemoService", // 与接口中指定的name一致
        targetNamespace = "http://webservice.demo.websocket.xingchen.com", // 与接口中的命名空间一致,一般是接口的包名倒
        endpointInterface = "com.xingchen.websocket.demo.webservice.WebDemoService"// 接口地址
)
public class WebDemoServiceImpl implements WebDemoService {

    @Override
    public String sayHello(String user, Integer age) {
        return user + "，年龄：" + age + "，现在时间：" + "(" + LocalDateTime.now() + ")";
    }
}
