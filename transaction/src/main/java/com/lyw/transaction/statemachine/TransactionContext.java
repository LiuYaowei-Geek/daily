package com.lyw.transaction.statemachine;

import com.lyw.transaction.enums.StartTypeEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuyaowei488
 * @date created in 2019-8-26 17:21
 */
public class TransactionContext<S, E> implements Context {
    private static final String EVENT_KEY = "eventKey";

    private static final String CURRENT_STATE = "currentState";

    private Map<String, Object> dataMap;

    private StartTypeEnum startTypeEnum;

    public TransactionContext() {
        this.dataMap = new HashMap<>();
    }

    @Override
    public void setEvent(Object event) {
        dataMap.put(EVENT_KEY, event);
    }

    @Override
    public S getState(String key) {
        Object state = dataMap.get(key);
        return null == state ? null : (S) state;
    }

    @Override
    public void clearEvent() {
        this.dataMap.remove(EVENT_KEY);
    }

    @Override
    public void setData(String key, Object value) {
        dataMap.put(key, value);
    }

    public Object getData(String key) {
        return this.dataMap.get(key);
    }

    public boolean contains(String key) {
        return this.dataMap.containsKey(key);
    }

    public E getEvent() {
        Object event = getData(EVENT_KEY);
        return null == event ? null : (E) event;
    }

    @Override
    public StartTypeEnum getStartType() {
        return startTypeEnum;
    }

    @Override
    public void setStartType(StartTypeEnum startTypeEnum) {
        this.startTypeEnum = startTypeEnum;
    }

    @Override
    public void initState(Object state, StartTypeEnum startTypeEnum) {
        this.setData(CURRENT_STATE, state);
        this.startTypeEnum = startTypeEnum;
    }
}
