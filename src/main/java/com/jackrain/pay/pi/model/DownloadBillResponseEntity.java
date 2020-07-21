package com.jackrain.pay.pi.model;

import com.alibaba.fastjson.JSON;
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
public class DownloadBillResponseEntity extends PiPayResponseEntity {

    @JSONField(name = "response")
    private ResponseEntity response;


    @Data
    public class ResponseEntity{

        @JSONField(name = "result_code")
        private String resultCode;

        @JSONField(name = "err_code")
        private String errCode;

        @JSONField(name = "err_msg")
        private String errMsg;

        @JSONField(name = "download_url")
        private String downloadUrl;

        /**
         * 交易数据
         */
        @JSONField(name = "data")
        private String data;

        /**
         * 原始报文
         */
        @JSONField(name = "orig_response")
        private String origResponse;

    }

   @Override
   public String toJSONString(){
       return JSON.toJSONString(this);
   }

}
