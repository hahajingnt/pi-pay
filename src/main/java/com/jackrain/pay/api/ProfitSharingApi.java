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
 * @author zc
 * @version V1.0.0
 * @since V1.0.0
 */
public interface ProfitSharingApi {

    /**
     *
     * @param psReceiverAddEntity
     * @return
     */
    PsReceiverAddResponseEntity receiverAdd(PsReceiverAddEntity psReceiverAddEntity);

    /**
     *
     * @param psReceiverRemoveEntity
     * @return
     */
    PsReceiverRemoveResponseEntity receiverRemove(PsReceiverRemoveEntity psReceiverRemoveEntity);

    /**
     *
     * @param profitSharingMultiEntity
     * @return
     */
    ProfitSharingMultiResponseEntity profitSharingMulti(ProfitSharingMultiEntity profitSharingMultiEntity);

    /**
     * 退款查询
     * @param profitSharingQueryEntity
     * @return
     */
    ProfitSharingQueryResponseEntity profitSharingQuery(ProfitSharingQueryEntity profitSharingQueryEntity);

    /**
     * 分账完结
     * @param profitSharingFinishEntity
     * @return
     */
    ProfitSharingFinishResponseEntity profitSharingFinish(ProfitSharingFinishEntity profitSharingFinishEntity);

}
