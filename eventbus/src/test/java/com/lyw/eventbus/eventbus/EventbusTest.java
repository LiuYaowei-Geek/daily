package com.lyw.eventbus.eventbus;

import com.lyw.eventbus.PersonInfoEventPoster;
import com.lyw.eventbus.base.BaseBizTest;
import com.lyw.eventbus.base.EventBusPublisher;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author liuyaowei488
 * @date created in 2019-8-19 16:42
 */
@Slf4j
public class EventbusTest extends BaseBizTest {

    @Autowired
    private EventBusPublisher eventBusPublisher;
    @Autowired
    private PersonInfoEventPoster personInfoEventPoster;

    @Test
    public void testEventbus() {
        try {
            log.info("{} start test eventbus", this.getClass().getSimpleName());
            personInfoEventPoster.postEvent();
            log.info("{} end test eventbus", this.getClass().getSimpleName());
        } catch (Exception e) {
            log.error("error", e);
        }
    }
}
