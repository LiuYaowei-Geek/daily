package com.lyw.batch.core.listener;

import com.lyw.batch.core.ExecutionContext;

public interface Listener {
    void preExecute(ExecutionContext context);

    void afterExecute(ExecutionContext context);

    void handleException(ExecutionContext context, Exception e);
}
