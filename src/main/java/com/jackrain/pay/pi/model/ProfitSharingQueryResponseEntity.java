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
public class ProfitSharingQueryResponseEntity extends PiPayResponseEntity {

    @JSONField(name = "response")
    private ResponseEntity response;


    @Data
    public class ResponseEntity{

        @JSONField(name = "result_code")
        private String resultCode;

        @JSONField(name = "err_code")
        private String errCode;

        @JSONField(name = "err_msg")
        private String errMsg;

        @JSONField(name = "trade_no")
        private String tradeNo;

        @JSONField(name = "out_order_no")
        private String outOrderNo;

        @JSONField(name = "order_id")
        private String orderId;

        /**
         * 分账单状态：
         * ACCEPTED—受理成功
         * PROCESSING—处理中
         * FINISHED—处理完成
         * CLOSED—处理失败，已关单
         * 参考枚举:ProfitSharingState
         */
        @JSONField(name = "status")
        private String status;

        @JSONField(name = "close_reason")
        private String closerReason;

        /**
         * json对象
         */
        @JSONField(name = "receivers")
        private String receivers;

        /**
         * 分账金额 单位元
         */
        @JSONField(name = "amount")
        private String amount;

        /**
         * 分账描述
         */
        @JSONField(name = "description")
        private String description;


    }

   @Override
   public String toJSONString(){
       return JSON.toJSONString(this);
   }

}
