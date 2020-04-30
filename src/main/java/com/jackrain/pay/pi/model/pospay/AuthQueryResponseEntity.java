package com.jackrain.pay.pi.model.pospay;

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
public class AuthQueryResponseEntity extends PiPayResponseEntity {

    @JSONField(name = "response")
    private ResponseEntity response;


    @Data
    public class ResponseEntity{

        @JSONField(name = "result_code")
        private String resultCode;

        /**
         * 支付渠道
         */
        @JSONField(name = "pay_way")
        private String payWay;

        /**
         * 预授权时的商户订单号
         */
        @JSONField(name = "out_trade_no")
        private String outTradeNo;

        /**
         * 预授权成功时产生的序列号
         */
        @JSONField(name = "platform_no")
        private String platformNo;

        /**
         * 交易状态，参考枚举 TradeState
         */
        @JSONField(name = "trade_state")
        private String tradeState;

        /**
         * 订单总金额 单位分
         */
        @JSONField(name = "total_amount")
        private String totalAmount;

        /**
         * 订单明细
         */
        @JSONField(name = "order_details")
        private JSONArray orderDetails;

        /**
         * 收钱吧生成的订单号
         */
        @JSONField(name = "trade_no")
        private String tradeNo;

        @JSONField(name = "err_code")
        private String errCode;

        @JSONField(name = "err_msg")
        private String errMsg;

        /**
         * 原始报文
         */
        @JSONField(name = "orig_response")
        private String origResponse;

    }

   @Override
   public String toJSONString(){
       return JSON.toJSONString(this);
   }

}
