package com.lyw.batch.repay;

import com.alibaba.fastjson.JSONObject;
import com.lyw.batch.repay.subscriber.event.RepayFileEvent;
import com.lyw.eventbus.base.EventBusPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RepayFileListener {
    @Autowired
    private EventBusPublisher publisher;

    public void messageHandler(String json) {
        log.info("start receive repayFile, json = {}", json);
        try {
            RepayFileResult repayFileResult = JSONObject.parseObject(json, RepayFileResult.class);
            //insert unique record into db

            //generate batchNO
            String batchNo = generateBatchNo();

            //insert dealing file record into db
            String fileRecordId = addFileRecord();

            publisher.post(RepayFileEvent.builder().batchNo(batchNo).fileRecordId(fileRecordId).filePath(repayFileResult.getFilePath()).build());
        } catch (Exception e) {
            log.error("deal repay file occurred error", e);
        }
        log.info("end receive repayFile");
    }

    private String generateBatchNo() {
        String batchNo = "";
        return batchNo;
    }

    private String addFileRecord() {
        String fileRecordId = "";
        return fileRecordId;
    }
}
