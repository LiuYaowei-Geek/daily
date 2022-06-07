package com.lyw.batch.repay.listener;

import com.lyw.batch.core.ExecutionContext;
import com.lyw.batch.core.listener.Listener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RepayJobListener implements Listener {
    @Override
    public void preExecute(ExecutionContext context) {
        log.info("start execute");
    }

    @Override
    public void afterExecute(ExecutionContext context) {
        //update repay task from not ready to init by batchNo
        //update file record from dealing to success
        log.info("end execute");
    }

    @Override
    public void handleException(ExecutionContext context, Exception e) {
        //update file record from dealing to failed
        log.info("end error", e);
    }
}
