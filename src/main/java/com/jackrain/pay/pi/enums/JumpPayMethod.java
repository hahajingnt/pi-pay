package com.jackrain.pay.pi.enums;

/**
 * @author: z.c
 * @since: 2019/11/25
 * create at : 2019/11/25 6:49 PM
 */
public enum JumpPayMethod {

    /**
     *
     */
    METHOD_JUMPPAY("jumpPay"),

    METHOD_JUMPREFUND("jumpRefund");

    private String value;

    JumpPayMethod(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
