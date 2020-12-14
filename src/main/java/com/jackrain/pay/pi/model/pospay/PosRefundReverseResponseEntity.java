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
public class PosRefundReverseResponseEntity extends PiPayResponseEntity {

    @JSONField(name = "response")
    private ResponseEntity response;


    @Data
    public class ResponseEntity{

        /**
         * 结果编码
         */
        @JSONField(name = "result_code")
        private String resultCode;

        /**
         * 收钱吧为该订单生成的订单序列号
         */
        @JSONField(name = "refund_trade_no")
        private String refundTradeNo;

        /**
         * 商户退款订单号
         */
        @JSONField(name = "out_refund_no")
        private String outRefundNo;

        /**
         * 撤销订单号
         */
        @JSONField(name = "out_reverse_no")
        private String outReverseNo;

        /**
         * 业务错误编码 参考枚举err_code
         */
        @JSONField(name = "err_code")
        private String errCode;

        /**
         * 业务错误信息
         */
        @JSONField(name = "err_msg")
        private String errMsg;

        /**
         * 撤销信息，返回给对接方，有些机具需要订单信息，各个支付渠道字符会有差别。
         */
        @JSONField(name = "reverse_info")
        private String reverseInfo;

    }

   @Override
   public String toJSONString(){
       return JSON.toJSONString(this);
   }

}
