package com.lyw.batch.core.job;


import com.lyw.batch.core.ExecutionContext;
import com.lyw.batch.core.exception.StepExecuteException;
import com.lyw.batch.core.listener.Listener;
import com.lyw.batch.core.step.Step;

import java.util.ArrayList;
import java.util.List;


/**
 * describe this file.
 *
 * @author WANGERKANG501
 * @time 2019-3-27 14:30
 */

public class BatchJob implements Job {

    private List<Step> steps;


    private Step headerStep;


    private Listener listener;


    @Override

    public void execute(ExecutionContext context) {
        if (listener != null) {
            listener.preExecute(context);
        }
        try {
            if (context.getStartStepIndex() == 0 && headerStep != null) {
                headerStep.execute(context);
            }

            for (int i = 0; i < steps.size(); i++) {
                if (i < context.getStartStepIndex()) {
                    continue;
                }
                steps.get(i).execute(context);
            }
        } catch (Exception e) {
            if (listener != null) {
                listener.handleException(context, e);
            }
            // throw e
        }

        if (listener != null) {
            listener.afterExecute(context);
        }
    }


    public BatchJob headerStep(Step step) {
        this.headerStep = step;
        return this;
    }

    public BatchJob step(Step step) {
        if (steps == null || steps.size() == 0) {
            steps = new ArrayList<>();
        }
        steps.add(step);
        return this;
    }

    public BatchJob listener(Listener listener) {
        this.listener = listener;
        return this;
    }
}