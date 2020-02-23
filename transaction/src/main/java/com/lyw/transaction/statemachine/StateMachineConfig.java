package com.lyw.transaction.statemachine;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuyaowei488
 * @date created in 2019-8-26 16:24
 */
public class StateMachineConfig<S, E, H> {
    private S tempCurrentState;
    private H tempHandler;
    private E tempEvent;
    private S tempNextState;

    private final Map<S, StateConfiguration<S, E, H>> stateConfigurationMap = new HashMap<>(8);

    public StateMachineConfig<S, E, H> from(S s) {
        this.tempCurrentState = s;
        return this;
    }

    public StateMachineConfig<S, E, H> permit(E e) {
        this.tempEvent = e;
        return this;
    }

    public StateMachineConfig<S, E, H> handle(H h) {
        this.tempHandler = h;
        return this;
    }

    public StateMachineConfig<S, E, H> to(S s) {
        this.tempNextState = s;
        return this;
    }

    public void build() {
        StateConfiguration<S, E, H> stateConfiguration = createOrGetStateConfiguration(tempCurrentState);
        stateConfiguration.configEventHandle(tempEvent, tempHandler);
        stateConfiguration.configEventNextState(tempEvent, tempNextState);
        this.tempCurrentState = null;
        this.tempHandler = null;
        this.tempEvent = null;
        this.tempNextState = null;
    }

    private StateConfiguration<S, E, H> createOrGetStateConfiguration(S s) {
        if (null == stateConfigurationMap.get(s)) {
            StateConfiguration<S, E, H> stateConfiguration = new StateConfiguration<>(s);
            stateConfigurationMap.put(s, stateConfiguration);
        }
        return stateConfigurationMap.get(s);
    }

    public H getHandler(S s, E e) {
        StateConfiguration<S, E, H> stateConfiguration = stateConfigurationMap.get(s);
        if (null == stateConfiguration) {
            return null;
        }
        return stateConfiguration.getHandle(e);
    }

    public S getNextState(S s, E e) {
        return stateConfigurationMap.get(s) == null ? null : stateConfigurationMap.get(s).getNextState(e);
    }
}
