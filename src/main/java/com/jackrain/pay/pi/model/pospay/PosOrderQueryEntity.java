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
public class PosOrderQueryEntity extends PiPayEntity {

    private String payChannel;

    private String customerId;

    //商户订单号
    private String outTradeNo;

    //交易订单号
    private String tradeNo;

    //商户门店编号
    private String storeCode;

    /**
     * 门店收银机编号，如果没有请传入“0”
     */
    private String cashRegisterNo;

    public Map<String,String> toMap(){
        Map<String,String> map = new HashMap<>();
        map.put("trade_no",getTradeNo());
        map.put("out_trade_no",getOutTradeNo());
        map.put("customer_id",getCustomerId());
        map.put("store_code",getStoreCode());
        map.put("pay_channel",getPayChannel());
        map.put("cash_register_no",getCashRegisterNo());

        return map;
    }

    public JSONObject toJSONObject(){

        JSONObject paramObject = new JSONObject();
        paramObject.put("trade_no",getTradeNo());
        paramObject.put("out_trade_no",getOutTradeNo());
        paramObject.put("customer_id",getCustomerId());
        paramObject.put("store_code",getStoreCode());
        paramObject.put("pay_channel",getPayChannel());
        paramObject.put("cash_register_no",getCashRegisterNo());

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
