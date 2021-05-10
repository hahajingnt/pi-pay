package com.jackrain.pay.pi.model.jumppay;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
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
public class JumpPayEntity extends PiPayEntity {


    private String outTradeNo;

    /**
     * 交易金额
     */
    private Integer totalAmount;

    /**
     * 会员手机号
     */
    private String memberMobile;

    /**
     * [{"goods_id","goods_name","price单位分","quantity"}]
     */
    private JSONArray goodsDetail;

    private String storeCode;

    private String customerId;

    private String payChannel;

    private String feeType;

    public Map<String,String> toMap(){
        Map<String,String> map = new HashMap<>();
        map.put("out_trade_no",getOutTradeNo());
        map.put("total_amount",getTotalAmount() == null ? null:String.valueOf(getTotalAmount()));
//        map.put("total_fee", getTotalFee() == null ? null:String.valueOf(getTotalFee()));
        map.put("customer_id",getCustomerId());
        map.put("store_code",getStoreCode());
        map.put("pay_channel",getPayChannel());
        map.put("pay_way",getPayWay());
        map.put("fee_type",getFeeType());
        if (getGoodsDetail() != null){
            map.put("goods_detail",getGoodsDetail().toJSONString());
        }

        return map;
    }

    public JSONObject toJSONObject(){

        JSONObject paramObject = new JSONObject();
        paramObject.put("out_trade_no",getOutTradeNo());
        paramObject.put("total_amount",getTotalAmount() == null ? null:getTotalAmount());
//        paramObject.put("total_fee", getTotalFee() == null ? null:getTotalFee());
        paramObject.put("customer_id",getCustomerId());
        paramObject.put("store_code",getStoreCode());
        paramObject.put("pay_channel",getPayChannel());
        paramObject.put("fee_type",getFeeType());
        paramObject.put("pay_way",getPayWay());

        if (getGoodsDetail() != null){
            paramObject.put("goods_detail",getGoodsDetail());
        }
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
