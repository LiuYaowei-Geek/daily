package com.lyw.batch.repay;

import lombok.Data;

@Data
public class RepayFileResult {
    private String merchantCode;
    private String fileDate;
    private String filePath;
    private String fileType;
    private String fileName;
}
