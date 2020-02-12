package com.b505.weixin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
public class WeixinApplication {

    public static void main(String[] args) {
        SpringApplication.run( WeixinApplication.class, args );
    }

}
