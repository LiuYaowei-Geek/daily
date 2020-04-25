package com.lyw.batch.repay.subscriber.event;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class RepayFileEvent {
    private String fileRecordId;
    private String filePath;
    private String batchNo;
}
