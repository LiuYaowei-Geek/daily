package com.lyw.stateMachine.statemachine.config;

import com.lyw.stateMachine.enums.TestEvent;
import com.lyw.stateMachine.enums.TestStateEnum;
import com.lyw.stateMachine.handler.TestHandlerConfig;
import com.lyw.stateMachine.statemachine.Handler;
import com.lyw.stateMachine.statemachine.StateMachine;
import com.lyw.stateMachine.statemachine.StateMachineConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author liuyaowei488
 * @date created in 2020-4-9 10:47
 */
@Configuration
public class TestStateMachineConfig {

    @Resource
    private TestHandlerConfig testHandlerConfig;

    @Bean("testStateMachine")
    public StateMachine<TestStateEnum, TestEvent, Handler> createTestStateMachine() {
        StateMachineConfig<TestStateEnum, TestEvent, Handler> config = new StateMachineConfig<>();
        // 正向流程
        // 落单
        config.from(TestStateEnum.INIT).permit(TestEvent.START_CMD).handle(testHandlerConfig.getOrderLandHandler()).to(TestStateEnum.ORDER_LAND).build();
        // 落单成功->冻结扣减
        config.from(TestStateEnum.ORDER_LAND).permit(TestEvent.ORDER_LAND_SUCCESS).handle(testHandlerConfig.getFreezeHandler()).to(TestStateEnum.FREEZE).build();
        // 冻结扣减成功->提交借款申请，等待异步结果
        config.from(TestStateEnum.FREEZE).permit(TestEvent.FREEZE_SUCCESS).handle(testHandlerConfig.getSubmitApplyHandler()).to(TestStateEnum.APPLY).build();

        /* 借款申请异步结果处理 */
        config.from(TestStateEnum.SUBMIT_APPLY_ASYN).permit(TestEvent.APPLY_CALLBACK).handle(testHandlerConfig.getSubmitApplyHandler()).to(TestStateEnum.APPLY).build();

        // 借款申请成功->解冻
        config.from(TestStateEnum.APPLY).permit(TestEvent.APPLY_SUCCESS).handle(testHandlerConfig.getUnfreezeHandler()).to(TestStateEnum.UNFREEZE).build();
        // 解冻成功->主交易成功
        config.from(TestStateEnum.UNFREEZE).permit(TestEvent.UNFREEZE_SUCCESS).handle(testHandlerConfig.getMainSuccessHandler()).to(TestStateEnum.SUCCESS).build();

        // 逆向流程
        // 冻结扣减失败->主子交易失败
        config.from(TestStateEnum.FREEZE).permit(TestEvent.FREEZE_FAIL).handle(testHandlerConfig.getMainFailHandler()).to(TestStateEnum.FAIL).build();
        // 借款申请失败->解冻并增加
        config.from(TestStateEnum.APPLY).permit(TestEvent.APPLY_FAIL).handle(testHandlerConfig.getUnfreezeAddHandler()).to(TestStateEnum.UNFREEZE_ADD).build();
        // 解冻并增加成功->主交易失败
        config.from(TestStateEnum.UNFREEZE_ADD).permit(TestEvent.UNFREEZE_ADD_SUCCESS).handle(testHandlerConfig.getMainFailHandler()).to(TestStateEnum.FAIL).build();
        return new StateMachine<>(config);
    }
}
