package com.jackrain.pay.pi.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @Author:lin.jh
 * @Date:2020/9/21 11:45
 */
@Data
public class ProfitSharingFinishResponseEntity extends PiPayResponseEntity {
    @JSONField(name = "response")
    private ResponseEntity response;

    @Data
    public class ResponseEntity {

        @JSONField(name = "result_code")
        private String resultCode;

        @JSONField(name = "err_code")
        private String errCode;

        @JSONField(name = "err_msg")
        private String errMsg;

        @JSONField(name = "trade_no")
        private String tradeNo;

        @JSONField(name = "out_order_no")
        private String outOrderNo;

        @JSONField(name = "order_id")
        private String orderId;

    }
}
