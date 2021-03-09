package com.jackrain.pay.pi.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 *
 * 交易支付使用的资金渠道
 *
 * @author: z.c
 * @since: 2021/2/19
 * create at : 2021/2/19 3:35 PM
 *
 */
@Data
public class FundBillListEntity {

    @JSONField(name = "amount")
    private String amount;

    @JSONField(name = "bank_code")
    private String bankCode;

    @JSONField(name = "fund_channel")
    private String fundChannel;

    @JSONField(name = "fund_type")
    private String fundType;

    @JSONField(name = "real_amount")
    private String realAmount;

}
