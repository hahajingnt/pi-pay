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
public class PosPreOrderResponseEntity extends PiPayResponseEntity {

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
         * 品牌编号
         */
        @JSONField(name = "brade_code")
        private String brandCode;

        /**
         * 商户门店编号
         */
        @JSONField(name = "store_code")
        private String storeCode;

        /**
         * 门店收银机编号
         */
        @JSONField(name = "cash_register_no")
        private String cashRegisterNo;

        /**
         * 收钱吧为该订单生成的订单序列号
         */
        @JSONField(name = "trade_no")
        private String tradeNo;
        /**
         * 商户订单号
         */
        @JSONField(name = "out_trade_no")
        private String outTradeNo;

        /**
         * 反射参数，可以在订单结果通知中返回
         */
        @JSONField(name = "reflect")
        private String reflect;

        /**
         * 业务错误编码
         */
        @JSONField(name = "err_code")
        private String errCode;

        /**
         * 业务错误信息
         */
        @JSONField(name = "err_msg")
        private String errMsg;
    }

   @Override
   public String toJSONString(){
       return JSON.toJSONString(this);
   }

}
