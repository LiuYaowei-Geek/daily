package com.lyw.stateMachine.validate;

import com.lyw.stateMachine.context.TestContext;
import com.lyw.stateMachine.model.TestReq;
import org.springframework.stereotype.Component;

/**
 * @author liuyaowei488
 * @date created in 2020-4-8 16:54
 */
@Component
public class TestValidator implements Validator<TestReq, TestContext> {
    @Override
    public void validate(TestReq req, TestContext context) {
        //...
    }
}
