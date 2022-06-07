package com.lyw.stateMachine.enums;

/**
 * @author liuyaowei488
 * @date created in 2020-4-2 10:25
 */
public enum StartTypeEnum {
    /**
     * 中断恢复，跳过preHandle
     */
    RESUME,
    /**
     * 异步回调，只执行afterHandle
     */
    CALLBACK,
    /**
     * 正常执行
     */
    PROCESS
}
