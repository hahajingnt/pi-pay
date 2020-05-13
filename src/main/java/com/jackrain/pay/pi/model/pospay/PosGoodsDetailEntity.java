package com.jackrain.pay.pi.model.pospay;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
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
    @JSONField(name = "goods_id")
    private String goodsId;

    /**
     * 商品描述信息
     */
    @JSONField(name = "goods_name")
    private String goodsName;

    /**
     * 商品所属大类
     */
    @JSONField(name = "goods_category")
    private String goodsCategory;

    /**
     * 商品单位
     */
    @JSONField(name = "goods_unit")
    private String goodsUnit;

    /**
     * 商品数量
     */
    @JSONField(name = "quantity")
    private String quantity;

    /**
     * 商品单价,精确到分
     */
    @JSONField(name = "price")
    private String price;

    /**
     * 商品成交价格,一般为数量*单价，如有折扣再进行扣减，精确到分;
     */
    @JSONField(name = "sales_price")
    private String salesPrice;

    /**
     * 0--MARKET--销售;1--SALEARETURN--退货
     */
    @JSONField(name = "type")
    private String type;

    /**
     * 原商品销售门店号，退货时必填
     */
    @JSONField(name = "store_code")
    private String storeCode;

    /**
     * 原商品销售收银机号，退货时必填
     */
    @JSONField(name = "return_workstation_sn")
    private String returnWorkstationSn;

    /**
     * 原商品销售订单号，退货时必填
     */
    @JSONField(name = "out_trade_no")
    private String outTradeNo;

    public String toJSONString(){
        return JSON.toJSONString(this);
    }
}
