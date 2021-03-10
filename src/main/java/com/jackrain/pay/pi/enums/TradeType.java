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
public enum TradeType {

    /**
     * JSAPI
     */
    JSAPI("JSAPI"),

    /**
     * APP
     */
    APP("APP"),

    /**
     * H5页面
     */
    MWEB("MWEB"),

    /**
     * 二维码
     */
    NATIVE("NATIVE");

    private String value;

    TradeType(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }

}
