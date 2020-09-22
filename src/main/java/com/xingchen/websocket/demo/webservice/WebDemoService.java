package com.xingchen.websocket.demo.webservice;

import javax.jws.WebService;

@WebService(name = "WebDemoService", // 暴露服务名称
        targetNamespace = "http://webservice.demo.websocket.xingchen.com"// 命名空间,一般是接口的包名倒序
)
public interface WebDemoService {

    String sayHello(String user, Integer age);

}
