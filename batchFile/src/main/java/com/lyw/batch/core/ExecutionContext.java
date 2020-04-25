package com.lyw.batch.core;

import com.lyw.batch.core.reader.FileResource;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ExecutionContext {
    private String resource;

    private int startStepIndex;

    private String batchNo;

    private FileResource fileResource;

    private String fileRecordId;

    private String merchantCode;

    private Map<String, Object> dataMap = new HashMap<>();

    public ExecutionContext(String resource, String charset) {
        this.resource = resource;
        fileResource = new FileResource(resource, charset);
    }

}
