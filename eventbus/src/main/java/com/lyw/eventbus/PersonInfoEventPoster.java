package com.lyw.eventbus;

import com.lyw.eventbus.base.EventBusPublisher;
import com.lyw.eventbus.model.PersonInfoEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuyaowei488
 * @date created in 2019-8-19 14:52
 */
@Slf4j
@Service
public class PersonInfoEventPoster {
    @Autowired
    private EventBusPublisher publisher;

    public void postEvent() {
        log.info("start post person information event");
        PersonInfoEvent personInfoEvent = PersonInfoEvent.builder().name("lyw").age("23").build();
        log.info("post person information event = {}", personInfoEvent);
        publisher.post(personInfoEvent);
    }
}
