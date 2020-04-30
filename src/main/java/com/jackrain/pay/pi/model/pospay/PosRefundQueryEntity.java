package com.jackrain.pay.pi.model.pospay;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jackrain.pay.pi.model.PiPayEntity;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:lin.jh
 * @Date:2020/4/29 10:54
 */
@Data
public class PosRefundQueryEntity extends PiPayEntity {

    private String customerId;

    private String payChannel;

    //商户退款单号
    private String outRefundNo;

    //渠道退款单号
    private String refundTradeNo;

    //商户门店编号
    private String storeCode;

    /**
     * 门店收银机编号，如果没有请传入“0”
     */
    private String cashRegisterNo;

    public Map<String,String> toMap(){
        Map<String,String> map = new HashMap<>();
        map.put("refund_trade_no",getRefundTradeNo());
        map.put("out_refund_no",getOutRefundNo());
        map.put("customer_id",getCustomerId());
        map.put("store_code",getStoreCode());
        map.put("pay_channel",getPayChannel());
        map.put("cash_register_no",getCashRegisterNo());

        return map;
    }

    public JSONObject toJSONObject(){

        JSONObject paramObject = new JSONObject();
        paramObject.put("refund_trade_no",getRefundTradeNo());
        paramObject.put("out_refund_no",getOutRefundNo());
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
