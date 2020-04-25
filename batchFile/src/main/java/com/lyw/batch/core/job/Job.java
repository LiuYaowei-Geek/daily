package com.lyw.batch.core.job;

import com.lyw.batch.core.ExecutionContext;


public interface Job {
    void execute(ExecutionContext context);
}
