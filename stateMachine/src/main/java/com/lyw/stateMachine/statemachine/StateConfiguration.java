package com.lyw.stateMachine.statemachine;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuyaowei488
 * @date created in 2020-4-2 14:27
 */
public class StateConfiguration<S, E, H> {

    private S currentState;
    private Map<E, H> eventHandleMap;
    private Map<E, S> nextStateMap;

    public StateConfiguration(S state) {
        this.currentState = state;
        eventHandleMap = new HashMap<>(8);
        nextStateMap = new HashMap<>(8);
    }

    public void configEventHandle(E e, H h) {
        eventHandleMap.put(e, h);
    }

    public void configEventNextState(E e, S s) {
        nextStateMap.put(e, s);
    }

    public H getHandle(E e) {
        return eventHandleMap.get(e);
    }

    public S getNextStats(E e) {
        return nextStateMap.get(e);
    }
}
