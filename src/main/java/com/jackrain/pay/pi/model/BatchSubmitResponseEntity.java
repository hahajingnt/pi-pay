package com.jackrain.pay.pi.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @Author:lin.jh
 * @Date:2020/11/10 10:05
 */
@Data
public class BatchSubmitResponseEntity extends PiPayResponseEntity{

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

    }

}
