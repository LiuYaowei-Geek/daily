package com.lyw.eventbus.base;

import com.alibaba.dubbo.common.utils.NamedThreadFactory;
import com.google.common.eventbus.AsyncEventBus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
@Slf4j
@Configuration
public class EventBusConfig {
    @Bean
    public AsyncEventBus asyncEventBus() {
        log.info("{} start create thread pool executor", this.getClass().getSimpleName());
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1), new NamedThreadFactory("LYW-PUBLISHER"));
        log.info("{} end create thread pool executor, executor = {}", executor.toString());
        log.info("{} start init async event bus", this.getClass().getSimpleName());
        AsyncEventBus asyncEventBus = new AsyncEventBus("LYW-PUBLISHER", executor);
        log.info("{} end init async event bus, asyncEventBus = {}", this.getClass().getSimpleName(), asyncEventBus);
        return asyncEventBus;
    }
}
