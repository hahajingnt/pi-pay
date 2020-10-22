package com.jackrain.pay.pi.model;

import com.alibaba.fastjson.JSONObject;
import com.jackrain.pay.pi.model.PiPayEntity;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:lin.jh
 * @Date:2020/9/21 11:44
 */
@Data
public class ProfitSharingFinishEntity extends PiPayEntity {

    private String customerId;

    private String certPath;

    private String certPassword;

    /**
     * 商户分账单单号
     */
    private String outOrderNo;

    private String outTradeNo;

    /**
     * 微信订单号
     */
    private String tradeNo;

    /**
     * 分账完结描述
     */
    private String description;

    private String PayChannel;

    public Map<String,String> toMap(){
        Map<String,String> map = new HashMap<>();
        map.put("customer_id",getCustomerId());
        map.put("pay_channel",getPayChannel());
        map.put("pay_way",getPayWay());
        map.put("trade_no",getTradeNo());
        map.put("out_trade_no",getOutTradeNo());
        map.put("out_order_no",getOutOrderNo());
        map.put("description",getDescription());
        return map;
    }

    public JSONObject toJSONObject(){

        JSONObject paramObject = new JSONObject();
        paramObject.put("customer_id",getCustomerId());
        paramObject.put("pay_channel",getPayChannel());
        paramObject.put("pay_way",getPayWay());
        paramObject.put("trade_no",getTradeNo());
        paramObject.put("out_trade_no",getOutTradeNo());
        paramObject.put("out_order_no",getOutOrderNo());
        paramObject.put("description",getDescription());

        //
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("developer_id",getDeveloperId());
        jsonObject.put("timestamp",getTimestamp());
        jsonObject.put("sign",getSign());
        //
        jsonObject.put("param",paramObject);

        return jsonObject;
    }
}
