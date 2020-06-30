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
public enum PayMethod {

    /**
     *
     */
    METHOD_MICROPAY("micropay"),
    /**
     *
     */
    METHOD_ORDERQUERY("orderquery"),
    /**
     *
     */
    METHOD_REFUND("refund"),
    /**
     *
     */
    METHOD_REFUNDQUERY("refundquery"),
    /**
     *
     */
    METHOD_PRECREATE("precreate"),
    /**
     *
     */
    METHOD_REVERSE("reverse"),

    /**
     *
     */
    METHOD_CLOSE("closePrecreate");

    private String value;

    PayMethod(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }

}
