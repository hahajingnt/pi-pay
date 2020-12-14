package com.jackrain.pay.pi.model.business;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.jackrain.pay.pi.model.PiPayResponseEntity;
import lombok.Data;

import java.util.List;

/**
 * @Author:lin.jh
 * @Date:2020/12/11 上午9:40
 */
@Data
public class PageQueryResponseEntity extends PiPayResponseEntity {

    @JSONField(name = "response")
    private ResponseEntity response;


    @Data
    public class ResponseEntity {
        @JSONField(name = "total")
        private String total;

        @JSONField(name = "pages")
        private String pages;

        @JSONField(name = "page_size")
        private String pageSize;

        @JSONField(name = "current_page")
        private String currentPage;

        @JSONField(name = "customer_name")
        private String customerName;

        @JSONField(name = "order_info_array")
        private List<POrderInfoResponseEntity> orderInfoArray;
    }

    @Override
    public String toJSONString() {
        return JSON.toJSONString(this);
    }
}
