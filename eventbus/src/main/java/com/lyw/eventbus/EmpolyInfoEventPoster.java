package com.lyw.eventbus;

import com.lyw.eventbus.base.EventBusPublisher;
import com.lyw.eventbus.model.EmpolyInfoEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuyaowei488
 * @date created in 2019-8-20 10:38
 */
@Slf4j
@Service
public class EmpolyInfoEventPoster {
    @Autowired
    private EventBusPublisher eventBusPublisher;

    public void postEmpolyEvent() {
        log.info("{} start post empoly information event", this.getClass().getSimpleName());
        EmpolyInfoEvent empolyInfoEvent = EmpolyInfoEvent.builder().sex("男").position("初级").build();
        log.info("empoly infomation event = {}", empolyInfoEvent);
        log.info("{} start post empoly information event, event = {}", eventBusPublisher, empolyInfoEvent);
        eventBusPublisher.post(empolyInfoEvent);
        log.info("{} end post empoly information event, event = {}", eventBusPublisher.toString(), empolyInfoEvent);
    }
}
