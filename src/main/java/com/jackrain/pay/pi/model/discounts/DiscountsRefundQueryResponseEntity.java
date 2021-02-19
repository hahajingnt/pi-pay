package com.jackrain.pay.pi.model.discounts;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.jackrain.pay.pi.model.PiPayResponseEntity;
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
public class DiscountsRefundQueryResponseEntity extends PiPayResponseEntity {

    @JSONField(name = "response")
    private ResponseEntity response;


    @Data
    public class ResponseEntity{

        @JSONField(name = "result_code")
        private String resultCode;

        /**
         * 原支付商户订单号
         */
        @JSONField(name = "out_trade_no")
        private String outTradeNo;

        /**
         * 原支付单交易号
         */
        @JSONField(name = "trade_no")
        private String tradeNo;

        @JSONField(name = "total_amount")
        private String totalAmount;

        /**
         * 单位为元
         */
        @JSONField(name = "refund_amount")
        private String refundAmount;

        /**
         * 参考枚举RefundState
         */
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
