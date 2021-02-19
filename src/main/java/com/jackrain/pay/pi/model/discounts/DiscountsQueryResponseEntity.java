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
public class DiscountsQueryResponseEntity extends PiPayResponseEntity {


    @JSONField(name = "response")
    private ResponseEntity response;

    @Data
    public class ResponseEntity {
        /**
         * 参考枚举ResultCode
         */
        @JSONField(name = "result_code")
        private String resultCode;

        @JSONField(name = "out_trade_no")
        private String outTradeNo;

        @JSONField(name = "trade_no")
        private String tradeNo;

        /**
         * 优惠抵扣状态
         */
        @JSONField(name = "discounts_status")
        private String discountsStatus;

        /**
         * 买家优惠金额即总优惠 单位元
         */
        @JSONField(name = "discount_amount")
        private String discountAmount;

        /**
         * 支付完成时间 2017-03-30 15:07:57
         */
        @JSONField(name = "gmt_payment")
        private String gmtPayment;

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
