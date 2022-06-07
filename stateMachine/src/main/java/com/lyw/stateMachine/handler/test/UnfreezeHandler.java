package com.lyw.stateMachine.handler.test;

import com.lyw.stateMachine.context.TestContext;
import com.lyw.stateMachine.enums.TestEvent;
import com.lyw.stateMachine.enums.TestStateEnum;
import com.lyw.stateMachine.handler.AbstractHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 解冻.
 *
 * @author WANGERKANG501
 * @date 2019-3-13 15:10
 */
@Component
@Slf4j
public class UnfreezeHandler extends AbstractHandler<TestStateEnum, TestEvent, TestContext> {
    @Override
    protected void preHandle(TestContext context) {
        log.info("preHandle");
    }

    @Override
    protected void doHandle(TestContext context) {
        log.info("doHandle");
        context.setEvent(TestEvent.UNFREEZE_SUCCESS);
    }

    @Override
    protected void afterHandle(TestContext context) {
        log.info("afterHandle");
    }
}
