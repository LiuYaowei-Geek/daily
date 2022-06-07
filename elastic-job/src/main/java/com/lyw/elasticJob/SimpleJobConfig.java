package com.lyw.elasticJob;

import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;

public class SimpleJobConfig {

    public static LiteJobConfiguration generateLiteJobConfig() {
        JobCoreConfiguration simpleCoreConfig = JobCoreConfiguration.newBuilder("lywSimpleJob",
                "0/15 * * * * ?",
                1).build();

        SimpleJobConfiguration simpleJobConfig = new SimpleJobConfiguration(simpleCoreConfig, LywSimpleJob.class.getCanonicalName());

        LiteJobConfiguration simpleJobRootConfig = LiteJobConfiguration.newBuilder(simpleJobConfig).build();
        return simpleJobRootConfig;
    }
}
