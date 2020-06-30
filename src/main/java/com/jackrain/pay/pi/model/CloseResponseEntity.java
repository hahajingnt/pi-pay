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
public class CloseResponseEntity extends PiPayResponseEntity {

    @JSONField(name = "response")
    private ResponseEntity response;


    @Data
    public class ResponseEntity{

        @JSONField(name = "result_code")
        private String resultCode;

        @JSONField(name = "pay_way")
        private String payWay;

        @JSONField(name = "pay_way_des")
        private String payWayDes;

        @JSONField(name = "out_trade_no")
        private String outTradeNo;

        @JSONField(name = "platform_no")
        private String platformNo;

        @JSONField(name = "qr_code")
        private String qrCode;

        @JSONField(name = "err_code")
        private String errCode;

        @JSONField(name = "err_msg")
        private String errMsg;

        @JSONField(name = "retry_flag")
        private String retryFlag;

        @JSONField(name = "action")
        private String action;

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
