package com.lyw.distributedLock;

/**
 * @author liuyaowei488
 * @date created in 2019-8-19 17:59
 */
public interface DistributedLockService {

    long HALF_AN_HOUR = 30 * 60;

    /**
     * 加锁
     *
     * @param lockName 锁的值
     * @param expire   过期时间 seconds
     * @return 加锁结果, 成功true, 失败false
     */
    boolean tryLock(String lockName, long expire);

    /**
     * 加锁
     *
     * @param lockName 锁的值
     * @param expire   过期时间 seconds
     * @param interval 获取锁的间隔 seconds
     * @param periods  在periods秒内尝试获取锁 seconds
     * @return 加锁结果, 成功true, 失败false
     */
    boolean tryLock(String lockName, long interval, long expire, long periods) throws InterruptedException;

    /**
     * 释放锁
     *
     * @param lockName 锁的值
     */
    void release(String lockName);
}
