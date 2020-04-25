package com.lyw.batch.repay.writer;

import com.lyw.batch.core.ExecutionContext;
import com.lyw.batch.core.writer.DBWriter;
import com.lyw.batch.repay.model.RepayRecord;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RepayRecordWriter implements DBWriter<RepayRecord> {

    @Override
    public void write(List<RepayRecord> items, ExecutionContext context) {
        for (RepayRecord repayRecord : items) {
            //generate repay task list
        }
        //batch insert repay tasks into db
    }
}
