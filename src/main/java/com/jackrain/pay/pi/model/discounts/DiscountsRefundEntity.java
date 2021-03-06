package com.jackrain.pay.pi.model.discounts;

import com.alibaba.fastjson.JSONObject;
import com.jackrain.pay.pi.model.PiPayEntity;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: z.c
 * @since: 2019/11/25
 * create at : 2019/11/25 11:12 AM
 */
@Data
public class DiscountsRefundEntity extends PiPayEntity {

    private String tradeNo;

    private String outTradeNo;

    private Integer totalAmount;

    private String storeCode;

    private String customerId;

    private String payChannel;


    /**
     * 扩展字段
     */
    private String extendField;

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        map.put("customer_id", getCustomerId());
        map.put("pay_channel", getPayChannel());
        map.put("store_code", getStoreCode());
        map.put("total_amount", String.valueOf(getTotalAmount()));
        map.put("out_trade_no", getOutTradeNo());
        map.put("trade_no", getTradeNo());
        return map;
    }

    public JSONObject toJSONObject() {

        JSONObject paramObject = new JSONObject();
        paramObject.put("customer_id", getCustomerId());
        paramObject.put("pay_channel", getPayChannel());
        paramObject.put("store_code", getStoreCode());
        paramObject.put("total_amount", getTotalAmount());
        paramObject.put("out_trade_no", getOutTradeNo());
        paramObject.put("trade_no", getTradeNo());


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
