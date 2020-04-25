package com.lyw.batch.config;

import com.lyw.batch.core.job.BatchJob;
import com.lyw.batch.core.reader.FlatFileReader;
import com.lyw.batch.repay.listener.RepayJobListener;
import com.lyw.batch.repay.mapper.RepayLineMapper;
import com.lyw.batch.repay.step.HeaderStep;
import com.lyw.batch.repay.step.RepayRecordStep;
import com.lyw.batch.repay.writer.RepayRecordWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepayConfig {
    @Bean("repayJob")
    public BatchJob repayJob(RepayRecordWriter repayRecordWriter, RepayRecordStep step, RepayJobListener listener) {
        BatchJob batchJob = new BatchJob();
        HeaderStep headerStep = new HeaderStep();
        headerStep.reader(new FlatFileReader())
                .headLineNumber(1)
                .lineMapper(new RepayLineMapper());

        step.reader(new FlatFileReader())
                .mapper(new RepayLineMapper())
                .writer(repayRecordWriter)
                .headLineNumber(1);

        batchJob.headerStep(headerStep).step(step).listener(listener);
        return batchJob;
    }
}
