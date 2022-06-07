package com.lyw.batch.repay.step;

import com.lyw.batch.core.ExecutionContext;
import com.lyw.batch.core.step.AbstractFileStep;
import com.lyw.batch.repay.model.RepayHeader;
import com.lyw.batch.repay.model.RepayRecord;
import org.springframework.stereotype.Component;

@Component
public class RepayRecordStep extends AbstractFileStep<RepayRecord, RepayHeader> {

    @Override
    protected int checkPoint(ExecutionContext context) {
        //count equals repay tasks count by batchNo
        int count = 0;
        return count;
    }

    @Override
    protected int getPageSize() {
        return 5000;
    }
}
