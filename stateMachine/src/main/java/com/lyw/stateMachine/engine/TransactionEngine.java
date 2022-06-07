package com.lyw.stateMachine.engine;

import com.lyw.stateMachine.model.abs.AbstractReq;
import com.lyw.stateMachine.model.abs.AbstractRes;

/**
 * @author liuyaowei488
 * @date created in 2020-4-8 16:11
 */
public interface TransactionEngine<T extends AbstractReq, S extends AbstractRes> {
    S execute(T req);
}
