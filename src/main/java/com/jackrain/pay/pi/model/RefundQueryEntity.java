package com.jackrain.pay.pi.model;

import com.alibaba.fastjson.JSONObject;
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
public class RefundQueryEntity extends PiPayEntity {

    private String tradeNo;

    private String outTradeNo;

    private String outRefundNo;

    private String customerId;

    private String storeCode;

    private String payChannel;


    public Map<String,String> toMap(){
        Map<String,String> map = new HashMap<>();
        map.put("trade_no",getTradeNo());
        map.put("out_trade_no",getOutTradeNo());
        map.put("out_refund_no",getOutRefundNo());
        map.put("customer_id",getCustomerId());
        map.put("store_code",getStoreCode());
        map.put("pay_channel",getPayChannel());
        return map;
    }

    public JSONObject toJSONObject(){

        JSONObject paramObject = new JSONObject();
        paramObject.put("trade_no",getTradeNo());
        paramObject.put("out_trade_no",getOutTradeNo());
        paramObject.put("out_refund_no",getOutRefundNo());
        paramObject.put("customer_id",getCustomerId());
        paramObject.put("store_code",getStoreCode());
        paramObject.put("pay_channel",getPayChannel());

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
