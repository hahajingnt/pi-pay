package com.jackrain.pay.pi.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

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
public class OrderQueryResponseEntity extends PiPayResponseEntity {

    @JSONField(name = "response")
    private ResponseEntity response;


    @Data
    public class ResponseEntity{

        @JSONField(name = "sign")
        private String sign;

        @JSONField(name = "result_code")
        private String resultCode;

        @JSONField(name = "pay_way")
        private String payWay;

        @JSONField(name = "pay_way_des")
        private String payWayDes;

        @JSONField(name = "out_trade_no")
        private String outTradeNo;

        @JSONField(name = "trade_no")
        private String tradeNo;

        @JSONField(name = "platform_no")
        private String platformNo;

        @JSONField(name = "trade_state")
        private String tradeState;

        @JSONField(name = "total_amount")
        private String totalAmount;

        @JSONField(name = "receipt_amount")
        private String receiptAmount;

        @JSONField(name = "buyer_pay_amount")
        private String buyerPayAmount;

        @JSONField(name = "transaction_no")
        private String transactionNo;

        @JSONField(name = "discount_amount")
        private String discountAmount;

        @JSONField(name = "gmt_payment")
        private String gmtPayment;

        @JSONField(name = "is_refund_part")
        private String isRefundPart;

        @JSONField(name = "refund_part_amount")
        private String refundPartAmount;

        @JSONField(name = "err_code")
        private String errCode;

        @JSONField(name = "err_msg")
        private String errMsg;

        @JSONField(name = "fund_bill_list")
        private List<FundBillListEntity> fundBillListEntityList;

    }

   @Override
   public String toJSONString(){
       return JSON.toJSONString(this);
   }

}
