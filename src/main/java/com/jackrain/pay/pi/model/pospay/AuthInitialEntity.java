package com.jackrain.pay.pi.model.pospay;

import com.alibaba.fastjson.JSON;
import com.jackrain.pay.pi.model.PiPayEntity;
import lombok.Data;

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
public class AuthInitialEntity extends PiPayEntity {

    /**
     * 商户订单号
     */
    private String outTradeNo;

    /**
     * 预授权交易金额
     */
    private Integer totalAmount;

    /**
     * 门店号
     */
    private String storeCode;

    /**
     * 预授权订单标题
     */
    private String subject;


    public String toJSONString(){
        return JSON.toJSONString(this);
    }


}
