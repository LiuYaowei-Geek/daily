package com.lyw.stateMachine.enums;

/**
 * @author liuyaowei488
 * @date created in 2020-4-9 10:31
 */
public enum TestStateEnum {
    /** 初始化 */
    INIT,

    /** 主交易创建 */
    ORDER_LAND,

    /** 冻结 */
    FREEZE,

    /** 提交借款申请 */
    APPLY,

    /** 提交借款申请异步处理 */
    SUBMIT_APPLY_ASYN,

    /** 解冻 */
    UNFREEZE,

    /** 解冻并增加 */
    UNFREEZE_ADD,

    /** 主交易成功 */
    SUCCESS,

    /** 主交易失败 */
    FAIL
}
