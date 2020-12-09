package com.jackrain.pay.pi.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

/**
 * @Author:lin.jh
 * @Date:2020/12/4 上午9:43
 */
@Data
public class StaticQrBatchQueryResponseEntity extends PiPayResponseEntity {

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

        @JSONField(name = "order_info_array")
        private List<StaticOrderInfoResponseEntity> orderInfoArray;
    }

    @Override
    public String toJSONString() {
        return JSON.toJSONString(this);
    }

}
