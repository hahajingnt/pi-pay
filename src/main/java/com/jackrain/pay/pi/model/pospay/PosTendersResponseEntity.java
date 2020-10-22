package com.jackrain.pay.pi.model.pospay;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @Author:lin.jh
 * @Date:2020/4/28 15:29
 */
@Data
public class PosTendersResponseEntity {

    /**
     * 支付方式类型
     * 0--OTHER--其他
     * 1--AUTHORIZATION--预授权
     * 2--BANKCARD--银行卡
     * 3--QRCODE--二维码
     * 4--INSTALMENT--分期
     * 99--EXTERNAL--外部
     */
    @JSONField(name = "tender_type")
    private String tenderType;

    /**
     * 二级支付方式类型:
     * 001--CASH--现金
     * 101--PREAUTHORIZATION--银行卡预授权
     * 201--UNIONPAY--银联支付
     * 301--WEIXINPAY--微信支付
     * 302--ALIPAY--支付宝
     * 401--INSTALMENT--银行卡分期
     */
    @JSONField(name = "pay_way")
    private String payWay;

    /**
     * 支付方式描述   当 tender_type 为 99 时，必填
     */
    @JSONField(name = "pay_way_desc")
    private String payWayDesc;

    /**
     * 支付/退款金额，单位元;
     */
    @JSONField(name = "total_amount")
    private String totalAmount;


    /**
     * 原始商户系统流水号，在商户系统中唯一
     */
    @JSONField(name = "transaction_sn")
    private String transactionSn;

    /**
     *支付/退款成功后，轻 POS 生成的唯一流水号
     */
    @JSONField(name = "tender_sn")
    private String tenderSn;

    /**
     * 退款对应的原购货订单完成后本系统返回的支付流水号
     */
    @JSONField(name = "original_tender_sn")
    private String originalTenderSn;

    /**
     * 支付时间
     */
    @JSONField(name = "gmt_payment")
    private String gmtPayment;

    /**
     * 参考枚举 TradeState
     * 2--WAIT_BUYER_PAY--用户支付中
     * 3--TRADE_SUCCESS--支付成功
     * 4--WAIT_REFUND--退款中
     * 5--TRADE_REFUNDED--已退款
     * 6--TRADE_FINISHED--交易结束，不可退款
     * 7--TRADE_FAIL--支付失败
     * 1或8--TRADE_FINISHED--未知状态
     */
    @JSONField(name = "trade_state")
    private String tradeState;

    /**
     * 商户实收金额 单位元
     */
    @JSONField(name = "receipt_amount")
    private String receiptAmount;

    /**
     * 买家支付金额 单位元
     */
    @JSONField(name = "buyer_pay_amount")
    private String buyerPayAmount;

    @JSONField(name = "internal_transaction_sn")
    private String internalTransactionSn;


    public String toJSONString(){
        return JSON.toJSONString(this);
    }
}
