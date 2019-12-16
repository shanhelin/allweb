package com.b505.redis.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 描述:针对redis的常规操作
 * author:yulin
 * Create date 2019-12-9 12:35
 */
@Service
@SuppressWarnings("unchecked")
public class RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    //批量删除对应的value
    public void deleteAll(String...keys){//类似String key[] = {"key1", "key2", "key3"};

        for(String key:keys){

            delete(key);
        }
    }

    //删除指定key的value
    public void delete(String key){
        //如果key存在，那么就会执行删除操作
        if(exists(key)){

            redisTemplate.delete( key );
        }
    }

    //批量删除key
    public void deletePattern(String pattern){

        Set<Serializable> keys=redisTemplate.keys( pattern );
        if(keys.size()>0)
            redisTemplate.delete( keys );
    }

    //判断缓存中是否存在value
    public boolean exists(String key){
        return redisTemplate.hasKey( key );
    }

    //读取缓存
    public Object get(String key){

        ValueOperations<Serializable,Object>  operations=redisTemplate.opsForValue();
        return operations.get( key );
    }

    //写入缓存，不带时间
    public boolean set(String key, Object value) {
        boolean flag = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    //写入缓存，带时间
    public boolean set(String key, Object value, Long expireTime) {
        boolean flag = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

}
