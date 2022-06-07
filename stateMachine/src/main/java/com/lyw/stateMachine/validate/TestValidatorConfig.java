package com.lyw.stateMachine.validate;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuyaowei488
 * @date created in 2020-4-9 10:34
 */
@Component
public class TestValidatorConfig {
    @Resource
    private TestValidator testValidator;

    public List<Validator> validators() {
        List<Validator> validators = new ArrayList<>();
        validators.add(testValidator);
        //validators.add(...);
        return validators;
    }
}
