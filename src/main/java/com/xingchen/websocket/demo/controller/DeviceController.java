package com.xingchen.websocket.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.xingchen.websocket.demo.utils.GetMonitorDocument;
import com.xingchen.websocket.demo.utils.XmlToJsonUtil;
import org.dom4j.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviceController {

    private final GetMonitorDocument getMonitorDocument;

    @Autowired
    public DeviceController(GetMonitorDocument getMonitorDocument) {
        this.getMonitorDocument = getMonitorDocument;
    }

    @GetMapping("/getDevice")
    public JSONObject getDevice() {
        System.out.println("getDevice");
        JSONObject object = new JSONObject();

        try {
            Document document = getMonitorDocument.getDocument("192.168.1.1", 9100);
            System.out.println();
            object = XmlToJsonUtil.xmlToJson(document.asXML());
            return object;
        } catch (Exception e) {
            e.printStackTrace();
        }
        object.put("500", "服务器错误!");
        return object;
    }
}
