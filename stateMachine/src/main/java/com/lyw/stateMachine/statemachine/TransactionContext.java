package com.lyw.stateMachine.statemachine;

import com.lyw.stateMachine.enums.StartTypeEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuyaowei488
 * @date created in 2020-4-8 16:58
 */
public class TransactionContext<S, E> implements Context {

    private static final String EVENT_KEY = "eventKey";

    private static final String CURRENT_STATE = "CURRENT_STATE";

    private Map<String, Object> dataMap;

    private StartTypeEnum startType;

    public TransactionContext() {
        this.dataMap = new HashMap<>();
    }

    @Override
    public void setEvent(Object event) {
        dataMap.put(EVENT_KEY, event);
    }

    @Override
    public Object getEvent() {
        Object event = getData(EVENT_KEY);
        return null == event ? null : (E) event;
    }

    @Override
    public Object getState(String key) {
        Object state = getData(key);
        return null == state ? null : (S) state;
    }

    @Override
    public void clearEvent() {
        dataMap.remove(EVENT_KEY);
    }

    @Override
    public void setData(String key, Object value) {
        dataMap.put(key, value);
    }

    public Object getData(String key) {
        return dataMap.get(key);
    }

    @Override
    public StartTypeEnum getStartType() {
        return startType;
    }

    @Override
    public void setStartType(StartTypeEnum startType) {
        this.startType = startType;
    }

    @Override
    public void initState(Object state, StartTypeEnum startTypeEnum) {
        this.setData(CURRENT_STATE, state);
        this.startType = startTypeEnum;
    }
}
