package com.lyw.stateMachine.handler.test;

import com.lyw.stateMachine.context.TestContext;
import com.lyw.stateMachine.enums.StartTypeEnum;
import com.lyw.stateMachine.enums.TestEvent;
import com.lyw.stateMachine.enums.TestStateEnum;
import com.lyw.stateMachine.handler.AbstractHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 提交借款申请.
 *
 * @author WANGERKANG501
 * @date 2019-3-13 15:10
 */
@Slf4j
@Component
public class SubmitApplyHandler extends AbstractHandler<TestStateEnum, TestEvent, TestContext> {
    @Override
    protected void preHandle(TestContext context) {
        log.info("preHandle");
    }

    @Override
    protected void doHandle(TestContext context) {
        log.info("doHandle");
        context.initState(TestStateEnum.SUBMIT_APPLY_ASYN, StartTypeEnum.CALLBACK);
        context.setEvent(TestEvent.APPLY_CALLBACK);
    }

    @Override
    protected void afterHandle(TestContext context) {
        log.info("afterHandle");
        context.setEvent(TestEvent.APPLY_SUCCESS);
        context.setStartType(StartTypeEnum.PROCESS);
    }
}
