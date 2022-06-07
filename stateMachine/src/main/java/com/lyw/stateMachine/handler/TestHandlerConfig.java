package com.lyw.stateMachine.handler;

import com.lyw.stateMachine.handler.test.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author liuyaowei488
 * @date created in 2020-4-9 10:53
 */
@Component
public class TestHandlerConfig {
    @Autowired
    private OrderLandHandler orderLandHandler;

    @Autowired
    private FreezeHandler freezeHandler;

    @Autowired
    private SubmitApplyHandler submitApplyHandler;

    @Autowired
    private UnfreezeHandler unfreezeHandler;

    @Autowired
    private MainSuccessHandler mainSuccessHandler;

    @Autowired
    private MainFailHandler mainFailHandler;

    @Autowired
    private UnfreezeAddHandler unfreezeAddHandler;

    public OrderLandHandler getOrderLandHandler() {
        return orderLandHandler;
    }

    public FreezeHandler getFreezeHandler() {
        return freezeHandler;
    }

    public SubmitApplyHandler getSubmitApplyHandler() {
        return submitApplyHandler;
    }

    public UnfreezeHandler getUnfreezeHandler() {
        return unfreezeHandler;
    }

    public MainSuccessHandler getMainSuccessHandler() {
        return mainSuccessHandler;
    }

    public MainFailHandler getMainFailHandler() {
        return mainFailHandler;
    }

    public UnfreezeAddHandler getUnfreezeAddHandler() {
        return unfreezeAddHandler;
    }
}
