package com.jackrain.pay.pi.enums;

/**
 * @author: z.c
 * @since: 2019/11/25
 * create at : 2019/11/25 6:49 PM
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
    METHOD_CLOSE("closePrecreate"),

    /**
     *
     */
    METHOD_DOWNLOAD_BILL("downloadbill"),

    METHOD_STATICQR_BATCHQUERY("staticqr/batchquery"),

    METHOD_STATICQR_QUERY("staticqr/query"),

    METHOD_STATICQR_NOFITICATION("staticqr/nofitication"),

    BATCH_SUBMIT("/batchsubmit");

    private String value;

    PayMethod(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
