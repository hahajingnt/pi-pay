package com.jackrain.pay.pi.model;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:lin.jh
 * @Date:2020/12/4 上午9:43
 */
@Data
public class StaticQrBatchQueryEntity extends PiPayEntity {


    /**
     * 国家
     */
    private String country;

    /**
     * 默认50 最大250
     */
    private Integer limit;

    /**
     * 交易状态
     */
    private String tradeState;

    private String createAtMin;

    private String createAtMax;

    private String updateAtMin;

    private String updateAtMax;

    private String customerId;

    private String payChannel;

    private String storeCode;


    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        map.put("country", getCountry());
        map.put("limit", String.valueOf(getLimit()));
        map.put("trade_state", getTradeState());
        map.put("create_at_min", getCreateAtMin());
        map.put("create_at_max", getCreateAtMax());
        map.put("update_at_min", getUpdateAtMin());
        map.put("update_at_max", getUpdateAtMax());
        map.put("customer_id",getCustomerId());
        map.put("pay_channel",getPayChannel());
        map.put("storeCode",getStoreCode());
        return map;
    }

    public JSONObject toJSONObject() {

        JSONObject paramObject = new JSONObject();
        paramObject.put("country", getCountry());
        paramObject.put("limit", getLimit());
        paramObject.put("trade_state", getTradeState());
        paramObject.put("create_at_min", getCreateAtMin());
        paramObject.put("create_at_max", getCreateAtMax());
        paramObject.put("update_at_min", getUpdateAtMin());
        paramObject.put("update_at_max", getUpdateAtMax());
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
