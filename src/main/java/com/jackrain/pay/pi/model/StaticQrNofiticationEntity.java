package com.jackrain.pay.pi.model;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: z.c
 * @since: 2019/11/25
 * create at : 2019/11/25 11:12 AM
 */
@Data
public class StaticQrNofiticationEntity extends PiPayEntity {

    /**
     * fomo stan跟踪编号
     */
    private String stan;

    private String customerId;

    private String payChannel;

    private String storeCode;

    private String outTradeNo;

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        map.put("stan", getStan());
        map.put("customer_id", getCustomerId());
        map.put("pay_channel", getPayChannel());
        map.put("store_code", getStoreCode());
        map.put("out_trade_no", getOutTradeNo());
        return map;
    }

    public JSONObject toJSONObject() {

        JSONObject paramObject = new JSONObject();
        paramObject.put("stan", getStan());
        paramObject.put("customer_id", getCustomerId());
        paramObject.put("pay_channel", getPayChannel());
        paramObject.put("store_code", getStoreCode());
        paramObject.put("out_trade_no", getOutTradeNo());

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("developer_id", getDeveloperId());
        jsonObject.put("timestamp", getTimestamp());
        jsonObject.put("sign", getSign());
        jsonObject.put("notify_url", getNotifyUrl());
        jsonObject.put("redirect_url", getRedirectUrl());
        jsonObject.put("param", paramObject);

        return jsonObject;
    }

}
