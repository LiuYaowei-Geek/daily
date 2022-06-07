package com.lyw.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author liuyaowei488
 * @date created in 2019-12-19 15:58
 */
@Slf4j
@Component
public class RedisCacheClient {
    @Autowired
    private StringRedisTemplate redisTemplate;
    private final RedisSerializer<Object> redisSerializer = new JdkSerializationRedisSerializer();
    private RedisSerializer<String> redisSerializerStr = new StringRedisSerializer();

    public void set(String key, Object value, int expire) {
        try {
            log.info("start, key = {}", key);
            if (value instanceof Map) {
                redisTemplate.opsForHash().putAll(key, (Map<?, ?>) value);
            }
        } catch (Exception e) {
            log.error("set occurred error", e);
        }

    }
}
