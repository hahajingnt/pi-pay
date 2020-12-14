package com.jackrain.pay.pi.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @Author:lin.jh
 * @Date:2020/12/2 下午5:14
 */
@Data
public class StaticOrderInfoResponseEntity {
    @JSONField(name = "trade_no")
    private String tradeNo;

    /**
     * 币种
     */
    @JSONField(name = "fee_type")
    private String feeType;

    @JSONField(name = "total_amount")
    private String totalAmount;

    @JSONField(name = "refund_able_amount")
    private String refundAbleAmount;

    @JSONField(name = "trade_state")
    private String tradeState;

    @JSONField(name = "create_time")
    private String createTime;

    @JSONField(name = "update_time")
    private String updateTime;

    public String toJSONString() {
        return JSON.toJSONString(this);
    }
}
