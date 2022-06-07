package com.lyw.batch.repay.model;

import com.lyw.batch.core.step.DefaultHeader;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class RepayHeader extends DefaultHeader {
    private String lineType;
    private String recordType;
    private String fileDate;
}
