package com.jackrain.pay.pi.model.business;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.jackrain.pay.pi.model.PiPayEntity;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:lin.jh
 * @Date:2020/12/10 下午5:35
 */
@Data
public class PageQueryEntity extends PiPayEntity {
    @JSONField(name = "page_size")
    private Long pageSize;

    @JSONField(name = "current_page")
    private Long currentPage;

    @JSONField(name = "customer_id")
    private String CustomerId;

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        map.put("customer_id",getCustomerId());
        map.put("current_page",String.valueOf(getCurrentPage()));
        map.put("page_size",String.valueOf(getPageSize()));

        return map;
    }

    public JSONObject toJSONObject() {

        JSONObject paramObject = new JSONObject();
        paramObject.put("customer_id",getCustomerId());
        paramObject.put("current_page",String.valueOf(getCurrentPage()));
        paramObject.put("page_size",String.valueOf(getPageSize()));

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("developer_id", getDeveloperId());
        jsonObject.put("timestamp", getTimestamp());
        jsonObject.put("sign", getSign());
        jsonObject.put("notify_url", getNotifyUrl());
        jsonObject.put("redirect_url", getRedirectUrl());
        jsonObject.put("param", paramObject);

        return jsonObject;
    }

}
