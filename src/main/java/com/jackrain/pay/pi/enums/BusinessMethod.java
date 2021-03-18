package com.jackrain.pay.pi.enums;

/**
 * @author: z.c
 * @since: 2019/11/25
 * create at : 2019/11/25 6:49 PM
 */
public enum BusinessMethod {

    /**
     *
     */
    PAGE_QUERY("pagequery"),

    REFUND_PAGE_QUERY("refund/pagequery");

    private String value;

    BusinessMethod(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
