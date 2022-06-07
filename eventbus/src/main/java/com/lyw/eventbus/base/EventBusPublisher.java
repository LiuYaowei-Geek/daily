package com.lyw.eventbus.base;

import com.google.common.eventbus.AsyncEventBus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * description of the file
 *
 * @author WANGERKANG501
 * @Date 2018年12月07日 10:46
 */
@Slf4j
@Component
public class EventBusPublisher {
    @Autowired
    private AsyncEventBus asyncEventBus;

    public void post(Object event) {
        log.info("start post event = {}", event.toString());
        asyncEventBus.post(event);
        log.info("end post event = {}", event.toString());
    }
}
