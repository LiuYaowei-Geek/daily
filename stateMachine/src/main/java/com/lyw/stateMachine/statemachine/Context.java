package com.lyw.stateMachine.statemachine;

import com.lyw.stateMachine.enums.StartTypeEnum;

/**
 * @author liuyaowei488
 * @date created in 2020-4-2 10:23
 */
public interface Context<S, E> {

    void setEvent(E e);

    E getEvent();

    S getState(String key);

    void clearEvent();

    void setData(String key, Object value);

    StartTypeEnum getStartType();

    void setStartType(StartTypeEnum startType);

    void initState(S s, StartTypeEnum startTypeEnum);
}
