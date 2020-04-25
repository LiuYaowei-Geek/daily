package com.lyw.batch.repay.step;

import com.lyw.batch.core.step.AbstractFileHeaderStep;
import com.lyw.batch.repay.model.RepayHeader;
import com.lyw.batch.repay.model.RepayRecord;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HeaderStep extends AbstractFileHeaderStep<RepayRecord, RepayHeader> {
    @Override
    protected int getPageSize() {
        return 5000;
    }

    @Override
    protected void preAdditional(RepayHeader header) {
        //validate file's header field by header
    }

    @Override
    protected void afterAdditional(RepayHeader header) {

    }
}
