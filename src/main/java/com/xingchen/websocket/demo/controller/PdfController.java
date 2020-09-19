package com.xingchen.websocket.demo.controller;

import com.xingchen.websocket.demo.utils.PdfUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PdfController {
    @GetMapping("/getPng")
    public String getPng() {
        PdfUtils.pdf2png("","","png");
        return "success";
    }
}
