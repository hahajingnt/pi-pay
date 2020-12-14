package com.jackrain.pay.pi.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @author: z.c
 * @since: 2019/11/27
 * create at : 2019/11/27 2:40 PM
 */
@Data
public class StaticQrQueryResponseEntity extends PiPayResponseEntity {

    @JSONField(name = "response")
    private ResponseEntity response;


    @Data
    public class ResponseEntity {

        @JSONField(name = "result_code")
        private String resultCode;

        @JSONField(name = "trade_no")
        private String tradeNo;

        /**
         * 参考枚举 TradeState
         */
        @JSONField(name = "trade_state")
        private String tradeState;

        /**
         * 订单总金额 单位元
         */
        @JSONField(name = "total_amount")
        private String totalAmount;

        @JSONField(name = "err_code")
        private String errCode;

        @JSONField(name = "err_msg")
        private String errMsg;

        /**
         * fomo stan跟踪编号
         */
        @JSONField(name = "stan")
        private String stan;

        @JSONField(name = "out_trade_no")
        private String outTradeNo;

        @JSONField(name = "platform_no")
        private String platformNo;
    }

    @Override
    public String toJSONString() {
        return JSON.toJSONString(this);
    }

}
