package com.lyw.batch.core.step;

import com.lyw.batch.core.ExecutionContext;
import com.lyw.batch.core.exception.ComponentIsNullException;
import com.lyw.batch.core.exception.HeaderDataIsNotMatchException;
import com.lyw.batch.core.exception.StepExecuteException;

public interface Step {
    void execute(ExecutionContext context) throws ComponentIsNullException, HeaderDataIsNotMatchException, StepExecuteException;
}
