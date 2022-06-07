package com.lyw.stateMachine.handler;

import com.lyw.stateMachine.enums.StartTypeEnum;
import com.lyw.stateMachine.statemachine.Context;
import com.lyw.stateMachine.statemachine.Handler;
import com.lyw.stateMachine.statemachine.StateMachine;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liuyaowei488
 * @date created in 2020-4-9 10:56
 */
@Slf4j
public abstract class AbstractHandler<S, E, C extends Context> implements Handler<C> {

    protected void preHandle(C context) {
//        log.info("preHandle");
    }

    @Override
    public void handle(C context, StateMachine stateMachine) {
        if (context.getStartType().equals(StartTypeEnum.PROCESS)) {
            preHandle(context);
        }
        if (!context.getStartType().equals(StartTypeEnum.CALLBACK)) {
            doHandle(context);
        } else {
            afterHandle(context);
        }

        if (context.getStartType().equals(StartTypeEnum.RESUME)) {
            context.setStartType(StartTypeEnum.PROCESS);
        }
        doNext(context, stateMachine);
    }

    protected abstract void doHandle(C context);

    protected void afterHandle(C context) {
//        log.info("afterHandle");
    }

    protected final void doNext(Context<S, E> context, StateMachine stateMachine) {
        E event = context.getEvent();
        if (null != event) {
            stateMachine.fire(event, context);
        } else {
            //log.info("event is null, state machine been suspended");
        }
    }
}
