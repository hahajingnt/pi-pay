package com.jackrain.pay.pi.model.pospay;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * @Author:lin.jh
 * @Date:2020/4/28 14:14
 */
@Data
public class PosTendersEntity {

    /**
     * 支付方式类型
     * 0--OTHER--其他
     * 1--AUTHORIZATION--预授权
     * 2--BANKCARD--银行卡
     * 3--QRCODE--二维码
     * 4--INSTALMENT--分期
     * 99--EXTERNAL--外部
     */
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
    private String payWay;

    /**
     * 支付方式描述   当 tender_type 为 99 时，必填
     */
    private String payWayDesc;

    /**
     * 支付/退款金额，精确到分;
     */
    private Integer totalAmount;


    /**
     * 商户系统流水号，在商户系统中唯一
     */
    private String transactionSn;

    /**
     *  购买时 tender_type 为 1 时必填，内容为预授权订单 操作成功后，轻 POS 返回给商户的预授权流水号
     *  退款时 原支付成功后本系统返回的支付流水号
     */
    private String originalTenderSn;

    /**
     * 支付状态
     * 0--WAITOPERATION--待操作
     * 1--COMPLETE--已完成
     */
    private String payStatus;

    /**
     * tender 创建时间,当 pay_status 为1时必填
     */
    private String createTime;

    public String toJSONString(){
        return JSON.toJSONString(this);
    }
}
