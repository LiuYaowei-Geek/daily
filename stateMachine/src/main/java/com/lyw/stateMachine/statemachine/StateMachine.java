package com.lyw.stateMachine.statemachine;

import lombok.extern.slf4j.Slf4j;

/**
 * @author liuyaowei488
 * @date created in 2020-4-2 14:23
 */
@Slf4j
public class StateMachine<S, E, H extends Handler> {

    private static final String CURRENT_STATE = "CURRENT_STATE";

    private StateMachineConfig<S, E, H> stateMachineConfig;

    public StateMachine(StateMachineConfig<S, E, H> config) {
        this.stateMachineConfig = config;
    }

    public S currentState(Context<S, E> context) {
        return context.getState(CURRENT_STATE);
    }

    public void fire(E event, Context<S, E> context) {
        S mainStateEnum = context.getState(CURRENT_STATE);
        if (null == mainStateEnum) {
            throw new IllegalStateException("current state is missing, cannot fire");
        }

        H handler = stateMachineConfig.getHandler(mainStateEnum, event);
        if (null == handler) {
            throw new IllegalArgumentException("current handle is missing, cannot fire");
        }

        context.clearEvent();
        S currentState = currentState(context);
        S nextState = stateMachineConfig.getNextState(mainStateEnum, event);
        log.info("stateMachine be fired, from state {} to state {} by trigger {}", currentState, nextState, event);
        context.setData(CURRENT_STATE, nextState);
        handler.handle(context, this);
    }
}
