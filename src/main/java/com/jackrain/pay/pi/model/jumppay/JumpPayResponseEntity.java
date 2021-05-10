package com.jackrain.pay.pi.model.jumppay;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.jackrain.pay.pi.model.PiPayResponseEntity;
import lombok.Data;

/**
 * @author: z.c
 * @since: 2019/11/27
 * create at : 2019/11/27 2:40 PM
 */
@Data
public class JumpPayResponseEntity extends PiPayResponseEntity {


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
         * 订单号
         */
        @JSONField(name = "out_trade_no")
        private String outTradeNo;

        @JSONField(name = "trade_no")
        private String tradeNo;

        /**
         * 订单总金额 单位元
         */
        @JSONField(name = "total_amount")
        private String totalAmount;

        @JSONField(name = "err_code")
        private String errCode;

        @JSONField(name = "err_msg")
        private String errMsg;

        @JSONField(name = "jump_url")
        private String jumpUrl;


    }

    @Override
    public String toJSONString() {
        return JSON.toJSONString(this);
    }

}
