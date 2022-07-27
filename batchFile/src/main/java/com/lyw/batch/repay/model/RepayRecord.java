package com.lyw.batch.repay.model;

import com.lyw.batch.core.step.DefaultItem;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class RepayRecord extends DefaultItem {
    /**
     * 序号
     */
    private String index;
    /**
     * 用户编号
     */
    private String finCustomerId;
    /**
     * 发起扣款的资方机构商户编号
     */
    private String orgMerchant;
    /**
     * 资方合作机构还款流水号
     */
    private String mercOrderNo;
    /**
     * 收单商户号
     */
    private String merchantId;
    /**
     * 是否主动还款 01 主动 02被动
     */
    private String isInitiative;

    /**
     * 的借款订单号
     */
    private String borrowTransId;
    /**
     * 还款类型：
     * <p>
     * NORMAL-正常还款
     * <p>
     * EARLY_SETTLE-提前结清
     * <p>
     * OVERDUE--逾期还款
     */
    private String repayType;
    /**
     * 还款金额
     */
    private BigDecimal transAmount;
    /**
     * 还款期数
     */
    private String periods;
    /**
     * 还款完成时间，格式：yyyyMMddhhmiss，对账时间
     */
    private String repayCompleteTime;
    /**
     * 还款银行卡卡号
     */
    private String bankCardNo;
    /**
     * 外部资方会员id
     */
    private String extCustomerId;
    /**
     * 交易币种，默认CNY
     */
    private String currency;
    /**
     * 是否逾期 Y(逾期)/N(未逾期)
     */
    private String overdue;
    /**
     * 代扣日期 yyyyMMdd
     */
    private String repayDate;

}