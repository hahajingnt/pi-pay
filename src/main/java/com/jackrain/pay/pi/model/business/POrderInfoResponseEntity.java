package com.jackrain.pay.pi.model.business;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * @Author:lin.jh
 * @Date:2020/12/11 上午10:48
 */
@Data
public class POrderInfoResponseEntity {

    @JSONField(name = "out_trade_no")
    private String outTradeNo;

    @JSONField(name = "trade_no")
    private String tradeNo;

    @JSONField(name = "platform_no")
    private String platformNo;

    @JSONField(name = "store_code")
    private String storeCode;

    @JSONField(name = "pay_channel")
    private String payChannel;

    @JSONField(name = "scene")
    private String scene;

    @JSONField(name = "pay_way")
    private String payWay;

    @JSONField(name = "total_amount")
    private String totalAmount;

    @JSONField(name = "pay_state")
    private String payState;

    @JSONField(name = "refund_amount")
    private String refundAmount;

    @JSONField(name = "bill_date")
    private Date billDate;

    @JSONField(name = "error_desc")
    private String errorDesc;

    public String toJSONString() {
        return JSON.toJSONString(this);
    }
}
