package com.b505.weixin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    /**
     * 描述：跳转界面
     * author：yulin
     * Createa date 2020-2-12 11:25
     */
    @RequestMapping("text")
    public String text(){
        return "text";
    }
}
