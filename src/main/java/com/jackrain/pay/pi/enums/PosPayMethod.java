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
public enum PosPayMethod {

    /**
     *
     */
    METHOD_PREORDER("pos/preorder"),
    /**
     *
     */
    METHOD_ORDERQUERY("pos/orderquery"),
    /**
     *
     */
    METHOD_REFUND("pos/refund"),
    /**
     *
     */
    METHOD_REFUNDQUERY("pos/refundquery"),
    /**
     *
     */
    METHOD_REVERSE("pos/reverse");

    private String value;

    PosPayMethod(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }

}
