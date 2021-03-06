package com.jackrain.pay.api;

import com.jackrain.pay.pi.model.business.PageQueryEntity;
import com.jackrain.pay.pi.model.business.PageQueryResponseEntity;
import com.jackrain.pay.pi.model.business.RefundPageQueryEntity;
import com.jackrain.pay.pi.model.business.RefundPageQueryResponseEntity;

/**
 * @Author:lin.jh
 * @Date:2020/12/11 下午1:36
 */
public interface PiPayBusinessApi {
    /**
     * 分页查询
     * @param pageQueryEntity
     * @return
     */
    PageQueryResponseEntity pageQuery(PageQueryEntity pageQueryEntity);

    /**
     * 退款分页查询
     * @param refundPageQueryEntity
     * @return
     */
    RefundPageQueryResponseEntity refundPageQuery(RefundPageQueryEntity refundPageQueryEntity);
}
