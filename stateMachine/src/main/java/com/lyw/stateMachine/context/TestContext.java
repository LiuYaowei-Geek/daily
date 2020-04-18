package com.lyw.stateMachine.context;

import com.lyw.stateMachine.enums.TestEvent;
import com.lyw.stateMachine.enums.TestStateEnum;
import com.lyw.stateMachine.model.TestReq;
import com.lyw.stateMachine.model.TestRes;
import com.lyw.stateMachine.statemachine.TransactionContext;

/**
 * @author liuyaowei488
 * @date created in 2020-4-8 16:56
 */
public class TestContext<S, E> extends TransactionContext<TestStateEnum, TestEvent> {
    /**
     * dto
     */
    private TestReq req;
    private TestRes res;

    public TestReq getReq() {
        return req;
    }

    public void setReq(TestReq req) {
        this.req = req;
    }

    public TestRes getRes() {
        return res;
    }

    public void setRes(TestRes res) {
        this.res = res;
    }

    /*
    @Getter
    @Setter
    private BorrowRequest request;

    @Getter
    @Setter
    private BorrowMoneyResponse response;

    @Getter
    @Setter
    private BorrowMainTransDTO mainTransDTO;

    @Getter
    @Setter
    private BorrowSubTransDTO freezeSubTransDTO;

    @Getter
    @Setter
    private BorrowSubTransDTO applySubTransDTO;

    @Getter
    @Setter
    private BorrowSubTransDTO unfreezeSubTransDTO;

    @Getter
    @Setter
    private BorrowSubTransDTO unfreezeAddSubTransDTO;

    @Getter
    @Setter
    private QuerySubAccountResDTO querySubAccountResDTO;

    @Getter
    @Setter
    private QuerySubProductResDTO querySubProductResDTO;

    @Getter
    @Setter
    private QueryOrgProductInfoResDTO orgProductInfoResDTO;
    */
}
