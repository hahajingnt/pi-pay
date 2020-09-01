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
public class PosReverseEntity extends PiPayEntity {

    private String payChannel;

    private String customerId;

    /**
     * 请求编号，每次请求必须唯一
     */
    private String requestId;


    /**
     * 原始商户订单号
     */
    private String outTradeNo;

    /**
     * 原始商户门店编号
     */
    private String storeCode;

    /**
     * 原始门店收银机编号，如果没有请传入“0”
     */
    private String cashRegisterNo;

    /**
     * 收钱吧为该订单生成的订单序列号
     */
    private String tradeNo;

    private String outReverseNo;

    /**
     * 反射参数
     */
    private String reflect;

    public Map<String,String> toMap(){
        Map<String,String> map = new HashMap<>();
        map.put("request_id",getRequestId());
        map.put("trade_no",getTradeNo());
        map.put("out_trade_no",getOutTradeNo());
        map.put("customer_id",getCustomerId());
        map.put("store_code",getStoreCode());
        map.put("pay_channel",getPayChannel());
        map.put("reflect",getReflect());
        map.put("cash_register_no",getCashRegisterNo());
        map.put("out_reverse_no",getOutReverseNo());
        return map;
    }

    public JSONObject toJSONObject(){

        JSONObject paramObject = new JSONObject();
        paramObject.put("request_id",getRequestId());
        paramObject.put("trade_no",getTradeNo());
        paramObject.put("out_trade_no",getOutTradeNo());
        paramObject.put("customer_id",getCustomerId());
        paramObject.put("store_code",getStoreCode());
        paramObject.put("pay_channel",getPayChannel());
        paramObject.put("reflect",getReflect());
        paramObject.put("cash_register_no",getCashRegisterNo());
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
