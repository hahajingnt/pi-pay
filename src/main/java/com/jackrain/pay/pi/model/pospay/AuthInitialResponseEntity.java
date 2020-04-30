package com.jackrain.pay.pi.model.pospay;

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
public class AuthInitialResponseEntity extends PiPayResponseEntity {


    @JSONField(name = "response")
    private ResponseEntity response;

    @Data
    public class ResponseEntity {
        /**
         * 参考枚举ResultCode
         */
        @JSONField(name = "result_code")
        private String resultCode;

        /**
         * 支付渠道
         */
        @JSONField(name = "pay_way")
        private String payWay;

        /**
         * 预授权商户订单号
         */
        @JSONField(name = "out_trade_no")
        private String outTradeNo;

        /**
         * 收钱吧生成的预授权订单序列号,可用于预授权撤销
         */
        @JSONField(name = "trade_no")
        private String tradeNo;

        /**
         * 圆周率平台号
         */
        @JSONField(name = "platform_no")
        private String platformNo;

        /**
         * 预授权支付金额
         */
        @JSONField(name = "total_amount")
        private String totalAmount;

        /**
         * 错误码
         */
        @JSONField(name = "err_code")
        private String errCode;

        /**
         * 错误信息
         */
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
