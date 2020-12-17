/*
 * Copyright [2018] [Alex/libo(liboware@gmail.com)]
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jackrain.pay.api;

import com.alibaba.fastjson.JSONObject;
import com.jackrain.pay.pi.model.*;

/**
 * 圆周率支付接口
 *
 * @author zc
 * @version V1.0.0
 * @since V1.0.0
 */
public interface PiPayApi {

    /**
     * 支付下单
     *
     * @param mircoPayEntity
     * @return
     */
    MircoPayResponseEntity mircopay(MircoPayEntity mircoPayEntity);

    /**
     * 支付单查询
     *
     * @param orderQueryEntity
     * @return
     */
    OrderQueryResponseEntity orderquery(OrderQueryEntity orderQueryEntity);

    /**
     * 退款
     *
     * @param refundEntity
     * @return
     */
    RefundResponseEntity refund(RefundEntity refundEntity);

    /**
     * 退款查询
     *
     * @param refundQueryEntity
     * @return
     */
    RefundQueryResponseEntity refundquery(RefundQueryEntity refundQueryEntity);

    /**
     * 二维码支付
     *
     * @param precreateEntity
     * @return
     */
    PrecreateResponseEntity precreate(PrecreateEntity precreateEntity);

    /**
     * 撤销
     *
     * @param reverseEntity
     * @return
     */
    ReverseResponseEntity reverse(ReverseEntity reverseEntity);

    /**
     * @param closeEntity
     * @return
     */
    CloseResponseEntity closePay(CloseEntity closeEntity);

    /**
     * 下载账单
     */
    DownloadBillResponseEntity downloadBill(DownloadBillEntity downloadBillEntity);

    /**
     * 下载账单
     */
    JSONObject downloadAlipayBill(JSONObject param);

    /**
     * 获取二维码地址
     *
     * @param precreateEntity
     * @return
     */
    JSONObject qrcodeUrl(PrecreateEntity precreateEntity);

    /**
     * 静态二维码批量查询
     *
     * @param staticQrBatchQueryEntity
     * @return
     */
    StaticQrBatchQueryResponseEntity staticQrBatchQuery(StaticQrBatchQueryEntity staticQrBatchQueryEntity);

    /**
     * 批量提交
     *
     * @param batchSubmitEntity
     * @return
     */
    BatchSubmitResponseEntity batchSubmit(BatchSubmitEntity batchSubmitEntity);

    /**
     * 绑定订单
     * @param staticQrBindOrderEntity
     * @return
     */
    StaticQrBindOrderResponseEntity staticQrBindOrder(StaticQrBindOrderEntity staticQrBindOrderEntity);


}
