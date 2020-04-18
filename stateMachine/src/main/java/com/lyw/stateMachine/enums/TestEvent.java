package com.lyw.stateMachine.enums;

/**
 * @author liuyaowei488
 * @date created in 2020-4-9 10:31
 */
public enum TestEvent {
    /** 启动事件 */
    START_CMD,

    /** 落主单成功 */
    ORDER_LAND_SUCCESS,

    /** 冻结成功 */
    FREEZE_SUCCESS,

    /** 冻结失败 */
    FREEZE_FAIL,

    /** 申请资方异步回调 */
    APPLY_CALLBACK,

    /** 申请资方借款成功 */
    APPLY_SUCCESS,

    /** 申请资方借款失败 */
    APPLY_FAIL,

    /** 解冻扣减成功 */
    UNFREEZE_SUCCESS,

    /** 解冻扣减失败 */
    UNFREEZE_FAIL,

    /** 解冻增加成功 */
    UNFREEZE_ADD_SUCCESS,

    /** 解冻增加失败 */
    UNFREEZE_ADD_FAIL
}
