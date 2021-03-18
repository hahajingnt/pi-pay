package com.jackrain.pay.pi.model.business;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @Author:lin.jh
 * @Date:2020/12/11 上午10:48
 */
@Data
public class PRefundInfoResponseEntity {

    @JSONField(name = "out_trade_no")
    private String outTradeNo;

    @JSONField(name = "trade_no")
    private String tradeNo;

    @JSONField(name = "refund_platform_no")
    private String refundPlatformNo;

    @JSONField(name = "store_code")
    private String storeCode;

    @JSONField(name = "pay_channel")
    private String payChannel;

    @JSONField(name = "trade_refund_way")
    private String tradeRefundWay;

    @JSONField(name = "refund_state")
    private String refundState;

    @JSONField(name = "refund_amount")
    private String refundAmount;

    @JSONField(name = "error_desc")
    private String errorDesc;

    public String toJSONString() {
        return JSON.toJSONString(this);
    }
}
