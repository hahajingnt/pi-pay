package com.jackrain.pay.pi.model;

import com.alibaba.fastjson.JSONArray;
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
public class MircoPayEntity extends PiPayEntity {

    private String authCode;

    private String body;

    private String outTradeNo;

    private Integer totalAmount;

    private String customerId;

    private String storeCode;

    private String goodsTag;

    private String payChannel;

    private String deviceInfo;

    private JSONArray goodsDetail;

    private String vipNo;

    private String payment;

    private String operatorId;

    private JSONObject extendParams;

    private String profitSharing;

    private String attach;

//    private Double totalFee;
//
//    private String payWay;
//
//    private String subject;
//
//    private String storeId;


    public Map<String,String> toMap(){
        Map<String,String> map = new HashMap<>();
        map.put("auth_code",getAuthCode());
        map.put("body",getBody());
        map.put("out_trade_no",getOutTradeNo());
        map.put("total_amount",getTotalAmount() == null ? null:String.valueOf(getTotalAmount()));
//        map.put("total_fee", getTotalFee() == null ? null:String.valueOf(getTotalFee()));
        map.put("customer_id",getCustomerId());
        map.put("store_code",getStoreCode());
        map.put("goods_tag",getGoodsTag());
        map.put("pay_channel",getPayChannel());
        map.put("device_info",getDeviceInfo());
        map.put("vip_no",getVipNo());
        map.put("payment",getPayment());
        map.put("operator_id",getOperatorId());
        map.put("profit_sharing",getProfitSharing());
        map.put("attach",getAttach());
//        map.put("pay_way",getPayWay());
//        map.put("subject",getSubject());
//        map.put("store_id",getStoreId());
        //
        if (getGoodsDetail() != null){
            map.put("goods_detail",getGoodsDetail().toJSONString());
        }
        if (getExtendParams() != null){
            map.put("extend_params",getExtendParams().toJSONString());
        }

        return map;
    }

    public JSONObject toJSONObject(){

        JSONObject paramObject = new JSONObject();
        paramObject.put("auth_code",getAuthCode());
        paramObject.put("body",getBody());
        paramObject.put("out_trade_no",getOutTradeNo());
        paramObject.put("total_amount",getTotalAmount() == null ? null:getTotalAmount());
//        paramObject.put("total_fee", getTotalFee() == null ? null:getTotalFee());
        paramObject.put("customer_id",getCustomerId());
        paramObject.put("store_code",getStoreCode());
        paramObject.put("goods_tag",getGoodsTag());
        paramObject.put("pay_channel",getPayChannel());
        paramObject.put("device_info",getDeviceInfo());
        paramObject.put("vip_no",getVipNo());
        paramObject.put("payment",getPayment());
        paramObject.put("operator_id",getOperatorId());
        paramObject.put("profit_sharing",getProfitSharing());
        paramObject.put("attach",getAttach());
//        paramObject.put("pay_way",getPayWay());
//        paramObject.put("subject",getSubject());
//        paramObject.put("store_id",getStoreId());
        if (getGoodsDetail() != null){
            paramObject.put("goods_detail",getGoodsDetail());
        }
        if (getExtendParams() != null){
            paramObject.put("extend_params",getExtendParams());
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
