package com.lyw.batch.core.step;

import com.lyw.batch.core.ExecutionContext;
import com.lyw.batch.core.exception.ComponentIsNullException;
import com.lyw.batch.core.exception.HeaderDataIsNotMatchException;
import com.lyw.batch.core.exception.StepExecuteException;
import com.lyw.batch.core.listener.Listener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTasklet implements Step {

    private Listener listener;

    @Override
    public void execute(ExecutionContext context) throws ComponentIsNullException, HeaderDataIsNotMatchException, StepExecuteException {
        if (null != listener) {
            listener.preExecute(context);
        }
        try {
            doExecute(context);
        } catch (Exception e) {
            log.error("AbstractTasklet occurred error", e);
            if (null != listener) {
                listener.handelException(context, e);
            }
            throw new StepExecuteException(e);
        }

        if (null != listener) {
            listener.afterExecute(context);
        }
    }

    public AbstractTasklet listener(Listener listener) {
        this.listener = listener;
        return this;
    }

    protected abstract void doExecute(ExecutionContext context);
}
