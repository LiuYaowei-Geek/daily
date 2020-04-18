package com.lyw.stateMachine.validate;

import com.lyw.stateMachine.model.abs.AbstractReq;
import com.lyw.stateMachine.statemachine.Context;

/**
 * @author liuyaowei488
 * @date created in 2020-4-8 16:53
 */
public interface Validator<T extends AbstractReq, C extends Context> {
    void validate(T req, C context);
}
