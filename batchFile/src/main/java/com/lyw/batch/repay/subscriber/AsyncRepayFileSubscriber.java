package com.lyw.batch.repay.subscriber;

import com.google.common.eventbus.Subscribe;
import com.lyw.batch.core.ExecutionContext;
import com.lyw.batch.core.job.BatchJob;
import com.lyw.batch.repay.subscriber.event.RepayFileEvent;
import com.lyw.eventbus.base.AbstractSubscriber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AsyncRepayFileSubscriber extends AbstractSubscriber {
    @Autowired
    @Qualifier("repayJob")
    private BatchJob batchJob;


    @Subscribe
    public void process(RepayFileEvent event) {
        try {
            ExecutionContext context = new ExecutionContext(event.getFilePath(), "utf-8");
            context.setFileRecordId(event.getFileRecordId());
            context.setResource(event.getFilePath());
            context.setBatchNo(event.getBatchNo());
            batchJob.execute(context);
        } catch (Exception e) {
            log.error("process occurred error", e);
        }
    }
}
