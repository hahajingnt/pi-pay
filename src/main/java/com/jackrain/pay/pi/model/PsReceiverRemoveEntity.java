package com.jackrain.pay.pi.model;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 *
 *
 *
 * @author: z.c
 * @since: 2019/11/25
 * create at : 2019/11/25 11:12 AM
 *
 */
@Data
public class PsReceiverRemoveEntity extends PiPayEntity {

    /**
     * 分账接收方对象，json格式
     */
    private JSONObject receiver;
}
