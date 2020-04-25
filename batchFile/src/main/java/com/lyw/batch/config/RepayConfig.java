package com.lyw.batch.config;

import com.lyw.batch.core.job.BatchJob;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepayConfig {
    @Bean("repayJob")
    public BatchJob repayJob() {
        BatchJob batchJob = new BatchJob();
        return batchJob;
    }
}
