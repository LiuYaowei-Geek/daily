package com.lyw.stateMachine.engine;

import com.lyw.stateMachine.context.TestContext;
import com.lyw.stateMachine.enums.StartTypeEnum;
import com.lyw.stateMachine.enums.TestEvent;
import com.lyw.stateMachine.enums.TestStateEnum;
import com.lyw.stateMachine.model.TestReq;
import com.lyw.stateMachine.model.TestRes;
import com.lyw.stateMachine.statemachine.Handler;
import com.lyw.stateMachine.statemachine.StateMachine;
import com.lyw.stateMachine.validate.TestValidatorConfig;
import com.lyw.stateMachine.validate.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author liuyaowei488
 * @date created in 2020-4-8 16:18
 */
@Component
public class TestTransactionEngine implements TransactionEngine<TestReq, TestRes> {

    @Autowired
    private TestValidatorConfig testValidatorConfig;

    @Autowired
    @Qualifier("testStateMachine")
    private StateMachine<TestStateEnum, TestEvent, Handler> stateMachine;


    @Override
    public TestRes execute(TestReq req) {
        TestContext<TestStateEnum, TestEvent> context = new TestContext();
        context.initState(TestStateEnum.INIT, StartTypeEnum.PROCESS);
        List<Validator> validators = testValidatorConfig.validators();

        for (Validator validator : validators) {
            validator.validate(req, context);
        }

        context.setReq(req);
        TestRes res = new TestRes();
        res.setRequestSeqId(req.getRequestSeqId());
        context.setRes(res);

        stateMachine.fire(TestEvent.START_CMD, context);

        return context.getRes();
    }
}
