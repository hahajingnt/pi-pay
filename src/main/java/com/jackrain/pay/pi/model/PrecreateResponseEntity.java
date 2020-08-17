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
public class PrecreateResponseEntity extends PiPayResponseEntity {

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

        @JSONField(name = "prepay_id")
        private String prepayId;

        /**
         * 公众号id
         */
        @JSONField(name = "app_id")
        private String appId;
        /**
         * 时间戳
         */
        @JSONField(name = "time_stamp")
        private String timeStamp;
        /**
         * 随机字符串
         */
        @JSONField(name = "nonce_str")
        private String nonceStr;
        /**
         * 订单详情扩展字符串
         */
        @JSONField(name = "wx_package")
        private String wxPackage;
        /**
         * 签名方式
         */
        @JSONField(name = "sign_type")
        private String signType;
        /**
         * 签名
         */
        @JSONField(name = "pay_sign")
        private String paySign;


    }

   @Override
   public String toJSONString(){
       return JSON.toJSONString(this);
   }

}
