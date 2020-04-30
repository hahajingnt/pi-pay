package com.jackrain.pay.pi.model.pospay;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jackrain.pay.pi.model.PiPayEntity;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
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
public class PosRefundEntity extends PiPayEntity {

    private String customerId;

    private String payChannel;

    /**
     * 请求编号，每次请求必须唯一
     */
    private String requestId;

    /**
     * 门店名称
     */
    private String storeName;

    /**
     * 门店收银机编号，如果没有请传入“0”
     */
    private String cashRegisterNo;

    /**
     * 订单创建时间, 2015-12-05T15:28:36+08:00
     */
    private String createTime;

    /**
     * 币种，ISO numeric currency code 如:”156”for CNY
     */
    private String currency;

    /**
     * 订单描述
     */
    private String description;

    /**
     * 客户信息
     */
    private String customer;

    /**
     * 拓展字段 1，可以用于做自定义标识，如座号，房间号
     */
    private String extension1;

    /**
     * 拓展字段 2，可以用于做自定义标识，如座号，房间号
     */
    private String extension2;

    /**
     * 行业代码, 0=零售;1:酒店; 2:餐饮; 3:文娱; 4:教育;
     */
    private String industryCode;

    /**
     * 通知接收地址
     */
    private String notifyUrl;

    /**
     * 拓展对象
     */
    private String extended;

    /**
     * 订单货物清单
     */
    private List<PosGoodsDetailEntity> goodsDetail;

    /**
     * 指定订单的各支付方式
     */
    private List<PosTendersEntity> tenders;

    /**
     * 商户退款订单号
     */
    private String outRefundNo;

    private String tradeNo;

    private String outTradeNo;

    /**
     * 退款金额
     */
    private Integer refundAmount;

    /**
     * 门店号
     */
    private String storeCode;


    /**
     * 订单标题
     */
    private String subject;


    public Map<String,String> toMap(){
        Map<String,String> map = new HashMap<>();
        map.put("customer_id",getCustomerId());
        map.put("pay_channel",getPayChannel());
        map.put("request_id",getRequestId());
        map.put("store_name",getStoreName());
        map.put("cash_register_no",getCashRegisterNo());
        map.put("create_time",getCreateTime());
        map.put("currency",getCurrency());
        map.put("description",getDescription());
        map.put("customer",getCustomer());
        map.put("extension1",getExtension1());
        map.put("extension2",getExtension2());
        map.put("industry_code",getIndustryCode());
        map.put("extended",getExtended());
        map.put("out_trade_no",getOutTradeNo());
        map.put("refund_amount",getRefundAmount().toString());
        map.put("store_code",getStoreCode());
        map.put("subject",getSubject());
        map.put("trade_no",getTradeNo());
        map.put("out_refund_no",getOutRefundNo());

        if (!CollectionUtils.isEmpty(getGoodsDetail())){
            map.put("goods_detail",JSON.toJSONString(getGoodsDetail()));
        }
        if (!CollectionUtils.isEmpty(getTenders())){
            map.put("tenders",JSON.toJSONString(getTenders()));
        }

        return map;
    }

    public JSONObject toJSONObject(){

        JSONObject paramObject = new JSONObject();
        paramObject.put("customer_id",getCustomerId());
        paramObject.put("pay_channel",getPayChannel());
        paramObject.put("request_id",getRequestId());
        paramObject.put("store_name",getStoreName());
        paramObject.put("cash_register_no",getCashRegisterNo());
        paramObject.put("create_time",getCreateTime());
        paramObject.put("currency",getCurrency());
        paramObject.put("description",getDescription());
        paramObject.put("customer",getCustomer());
        paramObject.put("extension1",getExtension1());
        paramObject.put("extension2",getExtension2());
        paramObject.put("industry_code",getIndustryCode());
        paramObject.put("extended",getExtended());
        paramObject.put("out_trade_no",getOutTradeNo());
        paramObject.put("refund_amount",getRefundAmount().toString());
        paramObject.put("store_code",getStoreCode());
        paramObject.put("subject",getSubject());
        paramObject.put("trade_no",getTradeNo());
        paramObject.put("out_refund_no",getOutRefundNo());

        if (!CollectionUtils.isEmpty(getGoodsDetail())){
            paramObject.put("goods_detail",JSON.toJSONString(getGoodsDetail()));
        }
        if (!CollectionUtils.isEmpty(getTenders())){
            paramObject.put("tenders",JSON.toJSONString(getTenders()));
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
