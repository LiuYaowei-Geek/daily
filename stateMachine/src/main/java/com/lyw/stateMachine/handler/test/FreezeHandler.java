package com.lyw.stateMachine.handler.test;

import com.lyw.stateMachine.context.TestContext;
import com.lyw.stateMachine.enums.TestEvent;
import com.lyw.stateMachine.enums.TestStateEnum;
import com.lyw.stateMachine.handler.AbstractHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 冻结.
 *
 * @author WANGERKANG501
 * @date 2019-3-13 15:10
 */
@Slf4j
@Component
public class FreezeHandler extends AbstractHandler<TestStateEnum, TestEvent, TestContext> {

    @Override
    protected void preHandle(TestContext context) {
        log.info("preHandle");
    }

    @Override
    protected void doHandle(TestContext context) {
        log.info("preHandle");
        context.setEvent(TestEvent.FREEZE_SUCCESS);
    }

    @Override
    protected void afterHandle(TestContext context) {
        log.info("preHandle");
    }
}
