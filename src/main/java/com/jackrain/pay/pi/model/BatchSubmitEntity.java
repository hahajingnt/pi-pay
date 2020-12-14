package com.jackrain.pay.pi.model;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:lin.jh
 * @Date:2020/11/10 10:05
 */
@Data
public class BatchSubmitEntity extends PiPayEntity {

    private String customerId;

    private String payChannel;

    private String storeCode;

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        map.put("customer_id",getCustomerId());
        map.put("pay_channel",getPayChannel());
        map.put("storeCode",getStoreCode());
        return map;
    }

    public JSONObject toJSONObject() {

        JSONObject paramObject = new JSONObject();
        paramObject.put("customer_id",getCustomerId());
        paramObject.put("pay_channel",getPayChannel());
        paramObject.put("storeCode",getStoreCode());

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
