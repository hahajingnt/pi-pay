package com.jackrain.pay.api;

import com.jackrain.pay.pi.model.discounts.*;

/**
 * 优惠接口
 * @Author:lin.jh
 * @Date:2021/2/18 09:54
 */
public interface DiscountsApi {
    DiscountsResponseEntity discounts(DiscountsEntity discountsEntity);

    DiscountsQueryResponseEntity discountsQuery(DiscountsQueryEntity discountsQueryEntity);

    DiscountsRefundResponseEntity discountsRefund(DiscountsRefundEntity discountsRefundEntity);

    DiscountsRefundQueryResponseEntity discountsRefundQuery(DiscountsRefundQueryEntity discountsRefundQueryEntity);
}
