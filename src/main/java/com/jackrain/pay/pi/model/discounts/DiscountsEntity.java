package com.jackrain.pay.pi.model.discounts;

import com.alibaba.fastjson.JSON;
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
public class DiscountsEntity extends PiPayEntity {

    private String outTradeNo;

    /**
     * 交易金额
     */
    private Integer totalAmount;

    /**
     * 门店号
     */
    private String storeCode;

    private String customerId;

    private String payChannel;

    /**
     * keyword - eg 蓝色-京A3456
     * keyType - 01：手机号 02：车牌号 03：掌银付款码
     * orgno - 手机号时必填 农行获取
     */
    private JSONObject userIdentity;

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        map.put("customer_id",getCustomerId());
        map.put("pay_channel",getPayChannel());
        map.put("store_code",getStoreCode());
        map.put("total_amount",String.valueOf(getTotalAmount()));
        map.put("out_trade_no",getOutTradeNo());
        if (getUserIdentity() != null){
            map.put("user_identity",getUserIdentity().toJSONString());
        }
        return map;
    }

    public JSONObject toJSONObject() {

        JSONObject paramObject = new JSONObject();
        paramObject.put("customer_id",getCustomerId());
        paramObject.put("pay_channel",getPayChannel());
        paramObject.put("store_code",getStoreCode());
        paramObject.put("total_amount",getTotalAmount());
        paramObject.put("out_trade_no",getOutTradeNo());
        if (getUserIdentity() != null){
            paramObject.put("user_identity",getUserIdentity().toJSONString());
        }

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
