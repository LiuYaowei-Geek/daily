package com.lyw.distributedLock.distributedLock;

import com.lyw.distributedLock.DistributedLockService;
import com.lyw.distributedLock.base.BaseBizTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author liuyaowei488
 * @date created in 2019-8-20 16:41
 */
@Slf4j
public class DistributedLockTest extends BaseBizTest {
    @Autowired
    private DistributedLockService distributedLockService;

    @Test
    public void tryLockTest() {
        try {
            String lockName = "分布式锁";
            long expire = 1L;
            boolean result =  distributedLockService.tryLock(lockName, expire);
            System.out.println(result);
        } catch (Exception e) {
            log.error("error", e);
        }
    }

    @Test
    public void releaseLock() {
        try {
            String lockName = "分布式锁";
            distributedLockService.release(lockName);
        } catch (Exception e) {
            log.error("error", e);
        }
    }

    @Test
    public void tryLockWithInterval() {

    }
}
