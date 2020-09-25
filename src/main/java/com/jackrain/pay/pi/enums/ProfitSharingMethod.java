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
public enum ProfitSharingMethod {

    /**
     *
     */
    METHOD_RECEIVER_ADD("ps_receiver_add"),
    /**
     *
     */
    METHOD_RECEIVER_REMOVE("ps_receiver_remove"),
    /**
     *
     */
    METHOD_PROFITSHARING_MULTI("profitsharing_multi"),
    /**
     *
     */
    METHOD_PROFITSHARING_QUERY("profitsharing_query"),


    METHOD_PROFITSHARING_FINISH("profitsharing_finish");

    private String value;

    ProfitSharingMethod(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }

}
