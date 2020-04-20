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
public class ReverseResponseEntity extends PiPayResponseEntity {

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




    }

   @Override
   public String toJSONString(){
       return JSON.toJSONString(this);
   }

}
