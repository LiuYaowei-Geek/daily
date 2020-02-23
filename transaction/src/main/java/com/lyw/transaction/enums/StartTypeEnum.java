package com.lyw.transaction.enums;

/**
 * @author liuyaowei488
 * @date created in 2019-8-26 16:14
 */
public enum StartTypeEnum {
    /**
     * 中断恢复，跳过preHandle
     */
    RESUM,
    /**
     * 异步回调，只执行afterHandle
     */
    CALLBACK,
    /**
     * 正常执行
     */
    PROCESS
}
