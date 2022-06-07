package com.lyw.eventbus.base;

import com.google.common.eventbus.AsyncEventBus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * describtion of the file
 *
 * @author WANGERKANG501
 * @Date 2018年12月07日 11:00
 */
@Slf4j
@Component
public class EventBusSubscriber {
    @Autowired
    private AsyncEventBus asyncEventBus;

    public void register(Object object) {
        log.info("{} start register object, object = {}, asyncEventBus = {}", this.getClass().getSimpleName(), object.toString(), asyncEventBus.toString());
        asyncEventBus.register(object);
    }
}
