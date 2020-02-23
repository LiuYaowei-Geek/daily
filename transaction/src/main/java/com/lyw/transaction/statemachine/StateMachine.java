package com.lyw.transaction.statemachine;

import com.sun.corba.se.impl.activation.ServerMain;

/**
 * @author liuyaowei488
 * @date created in 2019-8-26 17:40
 */
public class StateMachine<S, E, H extends Handler> {
    private static final String CURRENT_STATE = "current_state";

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
            throw new IllegalStateException("currenrt state is missing, can not fire the state machine");
        }
        H handle = stateMachineConfig.getHandler(mainStateEnum, event);
        if (null == handle) {
            throw new IllegalStateException("current handler is missing, can not fire the state machine");
        }
        context.clearEvent();
        S currentState = currentState(context);
        S nextState = stateMachineConfig.getNextState(mainStateEnum, event);
        context.setData(CURRENT_STATE, nextState);
        handle.handle(context, this);
    }
}
