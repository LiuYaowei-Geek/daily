package com.lyw.eventbus.eventbus;

import com.lyw.eventbus.EmpolyInfoEventPoster;
import com.lyw.eventbus.base.BaseBizTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author liuyaowei488
 * @date created in 2019-8-20 10:51
 */
@Slf4j
public class EmpolyInfoEventTest extends BaseBizTest {
    @Autowired
    private EmpolyInfoEventPoster empolyInfoEventPoster;

    @Test
    public void emplotEventTest() {
        try {
            log.info("{} start test eventbus", this.getClass().getSimpleName());
            empolyInfoEventPoster.postEmpolyEvent();
            log.info("{} end test eventbus", this.getClass().getSimpleName());
        } catch (Exception e) {
            log.info("error", e);
        }

    }
}
