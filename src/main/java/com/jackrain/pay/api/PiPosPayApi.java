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
import com.jackrain.pay.pi.model.pospay.*;

/**
 * 圆周率支付接口
 * @author zc
 * @version V1.0.0
 * @since V1.0.0
 */
public interface PiPosPayApi {

    /**
     * 支付下单
     * @param posPreOrderEntity
     * @return
     */
    PosPreOrderResponseEntity preorder(PosPreOrderEntity posPreOrderEntity);

    /**
     * 支付单查询
     * @param posOrderQueryEntity
     * @return
     */
    PosOrderQueryResponseEntity orderquery(PosOrderQueryEntity posOrderQueryEntity);

    /**
     * 退款
     * @param posRefundEntity
     * @return
     */
    PosRefundResponseEntity refund(PosRefundEntity posRefundEntity);

    /**
     * 退款查询
     * @param posRefundQueryEntity
     * @return
     */
    PosRefundQueryResponseEntity refundquery(PosRefundQueryEntity posRefundQueryEntity);

    /**
     * 撤销
     * @param posReverseEntity
     * @return
     */
    PosReverseResponseEntity reverse(PosReverseEntity posReverseEntity);

    /**
     * 下载账单
     */
    JSONObject downloadAlipayBill(JSONObject param);

}
