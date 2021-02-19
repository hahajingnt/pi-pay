package com.jackrain.pay.pi.model.discounts;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
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
public class DiscountsResponseEntity extends PiPayResponseEntity {


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
         * 订单总金额 单位元
         */
        @JSONField(name = "total_amount")
        private String totalAmount;

        /**
         * 买家优惠金额 即总优惠金额 单位元
         */
        @JSONField(name = "discount_amount")
        private String discountAmount;

        @JSONField(name = "discount_status")
        private String discountStatus;

        @JSONField(name = "deduct_detail")
        private JSONArray deductDetail;

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
