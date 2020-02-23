package com.lyw.distributedLock.impl;

import cn.hutool.core.util.StrUtil;
import com.lyw.distributedLock.DistributedLockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCommands;

import java.util.UUID;

/**
 * @author liuyaowei488
 * @date created in 2019-8-19 17:59
 */
@Slf4j
@Service
public class DistributedLockServiceImpl implements DistributedLockService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public boolean tryLock(String lockName, long expire) {
        log.info("start try lock, lockName = {}, expire = {}", lockName, expire);
        try {
            String lockId = UUID.randomUUID().toString();
            String result =redisTemplate.execute((RedisCallback<String>) connection -> {
                JedisCommands commands = (JedisCommands) connection.getNativeConnection();
                return commands.set(lockName, lockId, "NX", "EX", expire);
            });
            log.info("lock result is {}", result);
            return StrUtil.isNotEmpty(result);
        } catch (Exception e) {
            log.error("try lock occurred error", e);
        }
        return false;
    }

    @Override
    public boolean tryLock(String lockName, long interval, long expire, long periods) throws InterruptedException {
        // 如果加锁失败
        try {
            if (!tryLock(lockName, expire)) {
                // 再次尝试获取锁
                long current = System.currentTimeMillis();
                // 在指定时间内再次获取锁
                while ((System.currentTimeMillis() - current) / 1000 < periods) {
                    Thread.sleep(interval * 1000);
                    if (tryLock(lockName, expire)) {
                        return true;
                    }
                }
                // 超时获取锁未成功，返回false
                log.info("acquire the lock timeout return false");
                return false;
            } else {
                log.info("try lock true");
                return true;
            }
        } catch (InterruptedException e) {
            log.error("interrupted error", e);
        } catch (Exception e) {
            log.error("try lock error", e);
        }
        log.info("try lock false");
        return false;
    }

    @Override
    public void release(String lockName) {
        try {
            log.info("redis delete start key={}", lockName);
            redisTemplate.delete(lockName);
            log.info("redis delete end key={}", lockName);
        } catch (Exception e) {
            log.error("redis delete key={}", lockName, e);
        }
    }

}
