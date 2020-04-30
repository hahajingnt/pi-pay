package com.jackrain.pay.pi.model.pospay;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * @Author:lin.jh
 * @Date:2020/4/28 14:13
 */
@Data
public class PosGoodsDetailEntity {

    /**
     * 商户系统中的商品编号
     */
    private String goodId;

    /**
     * 商品描述信息
     */
    private String goodName;

    /**
     * 商品所属大类
     */
    private String goodCategory;

    /**
     * 商品单位
     */
    private String goodUnit;

    /**
     * 商品数量
     */
    private String quantity;

    /**
     * 商品单价,精确到分
     */
    private Integer price;

    /**
     * 商品成交价格,一般为数量*单价，如有折扣再进行扣减，精确到分;
     */
    private Integer salesPrice;

    /**
     * 0--MARKET--销售;1--SALEARETURN--退货
     */
    private String type;

    /**
     * 原商品销售门店号，退货时必填
     */
    private String storeCode;

    /**
     * 原商品销售收银机号，退货时必填
     */
    private String returnWorkstationSn;

    /**
     * 原商品销售订单号，退货时必填
     */
    private String outTradeNo;

    public String toJSONString(){
        return JSON.toJSONString(this);
    }
}
