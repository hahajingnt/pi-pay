package com.jackrain.pay.pi.model;

import com.alibaba.fastjson.JSON;
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
public class DownloadBillEntity extends PiPayEntity {

    /**
     * 201903到月或者20200601到天
     */
    private String billDate;

    /**
     * trade 账单类型
     */
    private String billType;

    /**
     * 接口类型
     */
    private String interfaceType;

    /**
     *商户号/连锁商户号/机构号
     */
    private String storeCode;

    private String customerId;

    private String payChannel;


    public Map<String,String> toMap(){
        Map<String,String> map = new HashMap<>();
        map.put("bill_date",getBillDate());
        map.put("bill_type",getBillType());
        map.put("interface_type",getInterfaceType());
        map.put("store_code",getStoreCode());
        map.put("customer_id",getCustomerId());
        map.put("pay_channel",getPayChannel());


        return map;
    }

    public JSONObject toJSONObject(){

        JSONObject paramObject = new JSONObject();
        paramObject.put("bill_date",getBillDate());
        paramObject.put("bill_type",getBillType());
        paramObject.put("interface_type",getInterfaceType());
        paramObject.put("store_code",getStoreCode());
        paramObject.put("customer_id",getCustomerId());
        paramObject.put("store_code",getStoreCode());
        paramObject.put("pay_channel",getPayChannel());

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
