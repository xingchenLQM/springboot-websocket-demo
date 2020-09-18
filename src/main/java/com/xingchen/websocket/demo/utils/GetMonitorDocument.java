package com.xingchen.websocket.demo.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

@Component
public class GetMonitorDocument {

    public Document getDocument(String ip, Integer port) throws IOException, DocumentException {
        Socket socket = new Socket(ip, port);
        InputStreamReader input = new InputStreamReader(socket.getInputStream());
        BufferedReader bfr = new BufferedReader(input);
        StringBuilder XMLStr = new StringBuilder();
        while (true) {
            String name = bfr.readLine();
            if (name == null) {
                break;
            }
            XMLStr.append(name);
        }
        System.out.println("XMLStr:"+XMLStr);
        return DocumentHelper.parseText(XMLStr.toString());
    }
}
