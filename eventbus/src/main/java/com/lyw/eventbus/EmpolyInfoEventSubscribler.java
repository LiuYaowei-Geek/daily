package com.lyw.eventbus;

import com.google.common.eventbus.Subscribe;
import com.lyw.eventbus.base.AbstractSubscriber;
import com.lyw.eventbus.base.EventBusSubscriber;
import com.lyw.eventbus.model.EmpolyInfoEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author liuyaowei488
 * @date created in 2019-8-20 10:38
 */
@Slf4j
@Service
public class EmpolyInfoEventSubscribler extends AbstractSubscriber {
    @Autowired
    private EventBusSubscriber eventBusSubscriber;

    @Subscribe
    private void subscribeEmpolyInfoEvent(EmpolyInfoEvent event) {
        log.info("{} start subscribe empoly info event, event = {}", this.getClass().getSimpleName(), event);
    }
}
