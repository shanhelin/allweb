package com.b505.redis.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

/**
 * 描述：redis学习项目启动类
 * author:yulin
 * Create date 2019-12-8 19:50
 */
@SpringBootApplication
@EnableRedisRepositories
public class RedisApplication {

    public static void main(String[] args) {
        SpringApplication.run( RedisApplication.class, args );
    }

}
