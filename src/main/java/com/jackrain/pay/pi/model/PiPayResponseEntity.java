package com.jackrain.pay.pi.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 *
 *
 *
 * @author: z.c
 * @since: 2019/11/27
 * create at : 2019/11/27 2:40 PM
 *
 */
@Data
public class PiPayResponseEntity {

    @JSONField(name = "status_code")
    private String statusCode;

    @JSONField(name = "err_msg")
    private String errMsg;

    public String toJSONString(){
       return JSON.toJSONString(this);
   }

}
