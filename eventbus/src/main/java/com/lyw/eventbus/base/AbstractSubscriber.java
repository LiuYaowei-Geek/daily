package com.lyw.eventbus.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * describtion of the file
 *
 * @author WANGERKANG501
 * @Date 2018年12月07日 11:08
 */
@Slf4j
@Component
public abstract class AbstractSubscriber {
    @Autowired
    private EventBusSubscriber subscriber;

    @PostConstruct
    private void init() {
        log.info("{} init", this.getClass().getSimpleName());
        log.info("{} start register, {}", this.getClass().getSimpleName(), this.toString());
        subscriber.register(this);
        log.info("{} end register, {}", this.getClass().getSimpleName(), this.toString());
    }
}
