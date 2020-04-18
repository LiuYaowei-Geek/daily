package com.lyw.stateMachine.statemachine;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuyaowei488
 * @date created in 2020-4-2 14:24
 */
public class StateMachineConfig<S, E, H> {

    private S currentState;
    private E event;
    private H handler;
    private S nextState;

    private final Map<S, StateConfiguration<S, E, H>> stateConfigurationMap = new HashMap<>(8);

    public StateMachineConfig<S, E, H> from(S s) {
        this.currentState = s;
        return this;
    }

    public StateMachineConfig<S, E, H> permit(E e) {
        this.event = e;
        return this;
    }

    public StateMachineConfig<S, E, H> handle(H h) {
        this.handler = h;
        return this;
    }

    public StateMachineConfig<S, E, H> to(S s) {
        this.nextState = s;
        return this;
    }

    public void build() {
        StateConfiguration<S, E, H> stateConfiguration = createOrGetStateConfiguration(currentState);
        stateConfiguration.configEventHandle(event, handler);
        stateConfiguration.configEventNextState(event, nextState);
        this.currentState = null;
        this.event = null;
        this.handler = null;
        this.nextState = null;
    }

    private StateConfiguration<S, E, H> createOrGetStateConfiguration(S s) {
        if (null == stateConfigurationMap.get(s)) {
            StateConfiguration<S, E, H> stateConfiguration = new StateConfiguration<S, E, H>(s);
            stateConfigurationMap.put(s, stateConfiguration);
        }
        return stateConfigurationMap.get(s);
    }

    public H getHandler(S s, E e) {
        return stateConfigurationMap.get(s) == null ? null : stateConfigurationMap.get(s).getHandle(e);
    }

    public S getNextState(S s, E e) {
        return stateConfigurationMap.get(s) == null ? null : stateConfigurationMap.get(s).getNextStats(e);
    }

    public static void main(String[] args) {
        for (Method method : StateMachineConfig.class.getDeclaredMethods()) {
            System.out.println(method.getName());
        }
    }
}
