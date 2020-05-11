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
public class AuthReleaseEntity extends PiPayEntity {

    /**
     * 预授权撤销的商户订单号
     */
    private String outTradeNo;

    /**
     * 门店号
     */
    private String storeCode;

    /**
     * 预授权撤销金额
     */
    private Integer reverseAmount;

    /**
     * 预授权成功时返回的订单序号
     */
    private String tradeNo;

    /**
     * 订单标题
     */
    private String subject;

}
