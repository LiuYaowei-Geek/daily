package com.lyw.transaction.statemachine;

import java.util.HashMap;
import java.util.Map;

/**
 * 配置状态机
 *
 * @param <S> 代表State，状态
 * @param <E> 代表Event，事件
 * @param <H> 代表handler，处理类
 * @author liuyaowei488
 * @date created in 2019-8-26 16:27
 */
public class StateConfiguration<S, E, H> {
    private S currentState;
    private Map<E, H> eventHandleMap;
    private Map<E, S> nextStateMap;

    public StateConfiguration(S state) {
        this.currentState = state;
        this.eventHandleMap = new HashMap<>(8);
        this.nextStateMap = new HashMap<>(8);
    }

    public void configEventHandle(E e, H h) {
        this.eventHandleMap.put(e, h);
    }

    public void configEventNextState(E e, S s) {
        this.nextStateMap.put(e, s);
    }

    public H getHandle(E e) {
        return this.eventHandleMap.get(e);
    }

    public S getNextState(E e) {
        return this.nextStateMap.get(e);
    }

}
