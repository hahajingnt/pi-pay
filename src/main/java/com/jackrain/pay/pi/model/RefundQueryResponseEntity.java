package com.jackrain.pay.pi.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 *
 *
 *
 * @author: z.c
 * @since: 2019/11/27
 * create at : 2019/11/27 2:40 PM
 *
 */
@Data
public class RefundQueryResponseEntity extends PiPayResponseEntity {

    @JSONField(name = "response")
    private ResponseEntity response;


    @Data
    public class ResponseEntity{

        @JSONField(name = "result_code")
        private String resultCode;

        @JSONField(name = "pay_way")
        private String payWay;

        @JSONField(name = "out_trade_no")
        private String outTradeNo;

        @JSONField(name = "trade_no")
        private String tradeNo;

        @JSONField(name = "total_amount")
        private String totalAmount;

        @JSONField(name = "refund_amount")
        private String refundAmount;

        @JSONField(name = "out_refund_no")
        private String outRefundNo;

        @JSONField(name = "refund_status")
        private String refundStatus;

        @JSONField(name = "err_code")
        private String errCode;

        @JSONField(name = "err_msg")
        private String errMsg;


    }

   @Override
   public String toJSONString(){
       return JSON.toJSONString(this);
   }

}
