package com.lyw.eventbus;

import com.google.common.eventbus.Subscribe;
import com.lyw.eventbus.base.AbstractSubscriber;
import com.lyw.eventbus.base.EventBusSubscriber;
import com.lyw.eventbus.model.PersonInfoEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuyaowei488
 * @date created in 2019-8-19 14:55
 */
@Slf4j
@Service
public class PersonInfoEventSubscribler extends AbstractSubscriber {
    @Autowired
    private EventBusSubscriber subscriber;

    @Subscribe
    private void subscribleEvent(PersonInfoEvent event) {
        log.info("{} start subscribe person information event = {}",this.getClass().getSimpleName(), event.toString());
    }
}
