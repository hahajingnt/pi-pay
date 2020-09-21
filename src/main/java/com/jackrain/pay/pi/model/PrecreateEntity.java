package com.jackrain.pay.pi.model;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
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
public class PrecreateEntity extends PiPayEntity {

    private String  precreateType;

    private String body;

    private String outTradeNo;

    private Integer totalAmount;

    private String customerId;

    private String storeCode;

    private String goodsTag;

    private String payChannel;

    private JSONArray goodsDetail;

    private JSONObject extendParams;

    private String tradeType;

    /**
     * Y/N 是否静态二维码
     */
    private String staticQrcode;

    /**
     * 分账标识
     */
    private String profitSharing;

    private String openId;

    private String subOpenId;

    private String attach;

    /**
     * 该笔订单超时时间，逾期将关闭交易。单位为分钟，5代表5分钟
     */
    private Integer timeoutExpress;

    public Map<String,String> toMap(){
        Map<String,String> map = new HashMap<>();
        map.put("precreatetype",getPrecreateType());
        map.put("body",getBody());
        map.put("out_trade_no",getOutTradeNo());
        map.put("total_amount",getTotalAmount() == null?null:getTotalAmount().toString());
        map.put("customer_id",getCustomerId());
        map.put("store_code",getStoreCode());
        map.put("goods_tag",getGoodsTag());
        map.put("pay_channel",getPayChannel());
        map.put("static_qrcode",getStaticQrcode());
        map.put("trade_type",getTradeType());
        map.put("profit_sharing",getProfitSharing());
        map.put("open_id",getOpenId());
        map.put("attach",getAttach());
        map.put("sub_open_id",getSubOpenId());
        map.put("timeout_express",getTimeoutExpress() == null?null:getTimeoutExpress().toString());
        if (getGoodsDetail() != null){
            map.put("goods_detail",getGoodsDetail().toJSONString());
        }
        if (getExtendParams() != null){
            map.put("extend_params",extendParams.toJSONString());
        }

        return map;
    }

    public JSONObject toJSONObject(){

        JSONObject paramObject = new JSONObject();
        paramObject.put("precreatetype",getPrecreateType());
        paramObject.put("body",getBody());
        paramObject.put("out_trade_no",getOutTradeNo());
        paramObject.put("total_amount",getTotalAmount());
        paramObject.put("customer_id",getCustomerId());
        paramObject.put("store_code",getStoreCode());
        paramObject.put("goods_tag",getGoodsTag());
        paramObject.put("pay_channel",getPayChannel());
        paramObject.put("static_qrcode",getStaticQrcode());
        paramObject.put("trade_type",getTradeType());
        paramObject.put("profit_sharing",getProfitSharing());
        paramObject.put("open_id",getOpenId());
        paramObject.put("attach",getAttach());
        paramObject.put("sub_open_id",getSubOpenId());
        paramObject.put("timeout_express",getTimeoutExpress() == null?null:getTimeoutExpress().toString());
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
