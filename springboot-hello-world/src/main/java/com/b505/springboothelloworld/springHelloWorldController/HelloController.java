package com.b505.springboothelloworld.springHelloWorldController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述：跳转界面的映射
 * author:yulin
 * Create date 2019-12-10 20:08
 */
@Controller
public class HelloController {

    @RequestMapping("index")
    public String index(){
        return "index.html";
    }

}
