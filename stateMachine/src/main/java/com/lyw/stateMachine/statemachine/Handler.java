package com.lyw.stateMachine.statemachine;

/**
 * @author liuyaowei488
 * @date created in 2020-4-2 14:18
 */
public interface Handler<C extends Context> {

    void handle(C context, StateMachine stateMachine);
}
