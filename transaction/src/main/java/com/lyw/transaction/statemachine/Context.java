package com.lyw.transaction.statemachine;

import com.lyw.transaction.enums.StartTypeEnum;

/**
 * @author liuyaowei488
 * @date created in 2019-8-26 16:16
 */
public interface Context<S, E> {
    void setEvent(E e);

    E getEvent();

    S getState(String key);

    void clearEvent();

    void setData(String key, Object value);

    StartTypeEnum getStartType();

    void setStartType(StartTypeEnum startTypeEnum);

    void initState(S s, StartTypeEnum startTypeEnum);
}
