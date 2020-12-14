package com.jackrain.pay.pi.model.pospay;

import com.alibaba.fastjson.JSONObject;
import com.jackrain.pay.pi.model.PiPayEntity;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 *
 * @author: z.c
 * @since: 2019/11/25
 * create at : 2019/11/25 11:12 AM
 *
 */
@Data
public class PosRefundReverseEntity extends PiPayEntity {


    /**
     * 请求编号，每次请求必须唯一
     */
    private String requestId;


    /**
     * 退款订单号
     */
    private String outRefundNo;

    /**
     * 原始商户门店编号
     */
    private String storeCode;

    /**
     * 收钱吧为该订单生成的退款订单序列号
     */
    private String refundTradeNo;

    /**
     * 反射参数
     */
    private String reflect;

    /**
     * 平台支付单号
     */
    private String platformNo;

    /**
     * 原交易凭证号 银联商务使用
     */
    private String traceNo;

    /**
     * 订单总金额 分为单位
     */
    private Integer totalAmount;

    /**
     * 订单标题
     */
    private String subject;

    /**
     * 撤销单号
     */
    private String outReverseNo;

    private String customerId;

    private String payChannel;

    public Map<String,String> toMap(){
        Map<String,String> map = new HashMap<>();
        map.put("request_id",getRequestId());
        map.put("out_refund_no",getOutRefundNo());
        map.put("refund_trade_no",getRefundTradeNo());
        map.put("customer_id",getCustomerId());
        map.put("store_code",getStoreCode());
        map.put("pay_channel",getPayChannel());
        map.put("reflect",getReflect());
        map.put("out_reverse_no",getOutReverseNo());
        return map;
    }

    public JSONObject toJSONObject(){

        JSONObject paramObject = new JSONObject();
        paramObject.put("request_id",getRequestId());
        paramObject.put("out_refund_no",getOutRefundNo());
        paramObject.put("refund_trade_no",getRefundTradeNo());
        paramObject.put("customer_id",getCustomerId());
        paramObject.put("store_code",getStoreCode());
        paramObject.put("pay_channel",getPayChannel());
        paramObject.put("reflect",getReflect());
        paramObject.put("out_reverse_no",getOutReverseNo());

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("developer_id",getDeveloperId());
        jsonObject.put("timestamp",getTimestamp());
        jsonObject.put("sign",getSign());
        jsonObject.put("notify_url",getNotifyUrl());
        jsonObject.put("redirect_url",getRedirectUrl());
        jsonObject.put("param",paramObject);

        return jsonObject;
    }

}
