package com.lyw.transaction.statemachine;

/**
 * @author liuyaowei488
 * @date created in 2019-8-26 16:23
 */
public interface Handler<C extends Context> {
    void handle(C context, StateMachine stateMachine);
}
