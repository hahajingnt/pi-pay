package com.jackrain.pay.pi.enums;

/**
 *
 *
 *
 * @author: z.c
 * @since: 2019/11/25
 * create at : 2019/11/25 6:49 PM
 *
 */
public enum PrecreateType {

    /**
     *
     */
    ALIPAY("ALIPAY"),
    /**
     *
     */
    WEIXINPAY("WEIXINPAY");

    private String value;

    PrecreateType(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }

}
