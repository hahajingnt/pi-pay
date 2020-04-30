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
public class AuthReleaseResponseEntity extends PiPayResponseEntity {

    @JSONField(name = "response")
    private ResponseEntity response;


    @Data
    public class ResponseEntity{

        @JSONField(name = "result_code")
        private String resultCode;

        /**
         * 预授权撤销返回的所撤销的商户订单号
         */
        @JSONField(name = "out_trade_no")
        private String outTradeNo;

        /**
         * 收钱吧生成的预授权撤销单号
         */
        @JSONField(name = "trade_no")
        private String tradeNo;

        /**
         * 圆周率平台号
         */
        @JSONField(name = "platform_no")
        private String platformNo;


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
