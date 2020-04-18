package com.lyw.stateMachine.engine;

import com.lyw.stateMachine.base.BaseBizTest;
import com.lyw.stateMachine.model.TestReq;
import com.lyw.stateMachine.model.TestRes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

public class TestTransactionEngineTest extends BaseBizTest {

    @Autowired
    private TestTransactionEngine testTransactionEngine;

    @Test
    public void execute() {
        TestReq req = new TestReq();
        req.setRequestSeqId("lyw");
        TestRes res = testTransactionEngine.execute(req);
        System.out.println(res);
    }
}