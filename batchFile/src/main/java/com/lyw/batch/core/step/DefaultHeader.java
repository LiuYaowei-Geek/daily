package com.lyw.batch.core.step;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DefaultHeader {
    private int totalCount;

    private BigDecimal totalAmount;
    private boolean isNeedAmount;
    private boolean isNeedCount;

    public DefaultHeader() {
    }
}
