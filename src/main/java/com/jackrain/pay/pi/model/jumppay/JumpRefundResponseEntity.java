package com.jackrain.pay.pi.model.jumppay;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.jackrain.pay.pi.model.PiPayResponseEntity;
import lombok.Data;

/**
 * @author: z.c
 * @since: 2019/11/27
 * create at : 2019/11/27 2:40 PM
 */
@Data
public class JumpRefundResponseEntity extends PiPayResponseEntity {

    @JSONField(name = "response")
    private ResponseEntity response;


    @Data
    public class ResponseEntity {

        @JSONField(name = "result_code")
        private String resultCode;

        /**
         * 原支付商户订单号
         */
        @JSONField(name = "out_trade_no")
        private String outTradeNo;

        @JSONField(name = "out_refund_no")
        private String outRefundNo;

        /**
         * 原支付单交易号
         */
        @JSONField(name = "trade_no")
        private String tradeNo;

        /**
         * 退款总金额,单位为元,可以做部分退款
         */
        @JSONField(name = "refund_amount")
        private String refundAmount;

        @JSONField(name = "err_code")
        private String errCode;

        @JSONField(name = "err_msg")
        private String errMsg;

        @JSONField(name = "jump_url")
        private String jumpUrl;

    }

    @Override
    public String toJSONString() {
        return JSON.toJSONString(this);
    }

}
