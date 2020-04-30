package com.jackrain.pay.pi.model.pospay;


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
public class AuthQueryEntity extends PiPayEntity {

    /**
     * 预授权查询所需要的预授权时的商户订单号
     */
    private String outTradeNo;

    /**
     * 预授权查询门店号
     */
    private String storeCode;

    /**
     * 预授权成功后收钱吧生成的订单号
     */
    private String tradeNo;

}
