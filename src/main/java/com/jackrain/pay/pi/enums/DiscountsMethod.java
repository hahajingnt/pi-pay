package com.jackrain.pay.pi.enums;

/**
 * @author: z.c
 * @since: 2019/11/25
 * create at : 2019/11/25 6:49 PM
 */
public enum DiscountsMethod {

    /**
     *
     */
    DISCOUNTS("discounts"),

    DISCOUNTS_QUERY("discounts/query"),

    DISCOUNTS_REFUND("discounts/refund"),

    DISCOUNTS_REFUNDQUERY("discounts/refundquery");

    private String value;

    DiscountsMethod(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
