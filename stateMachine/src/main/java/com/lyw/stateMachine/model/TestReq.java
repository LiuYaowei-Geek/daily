package com.lyw.stateMachine.model;

import com.lyw.stateMachine.model.abs.AbstractReq;

/**
 * @author liuyaowei488
 * @date created in 2020-4-8 16:20
 */
public class TestReq extends AbstractReq {
    private String requestSeqId;

    public String getRequestSeqId() {
        return requestSeqId;
    }

    public void setRequestSeqId(String requestSeqId) {
        this.requestSeqId = requestSeqId;
    }
}
