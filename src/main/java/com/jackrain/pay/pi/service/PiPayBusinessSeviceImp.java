package com.jackrain.pay.pi.service;

import com.alibaba.fastjson.JSONObject;
import com.jackrain.pay.api.PiPayBusinessApi;
import com.jackrain.pay.pi.enums.BusinessMethod;
import com.jackrain.pay.pi.enums.PayMethod;
import com.jackrain.pay.pi.model.PiPayResponseEntity;
import com.jackrain.pay.pi.model.business.PageQueryEntity;
import com.jackrain.pay.pi.model.business.PageQueryResponseEntity;
import com.jackrain.pay.web.PayRestTemplate;
import com.jackrain.pay.web.PayRestTemplateConf;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.net.URLEncoder;

/**
 * 移动支付实现
 *
 * @author: z.c
 * @since: 2019/11/25
 * create at : 2019/11/25 11:21 AM
 */
@Component
@Slf4j
public class PiPayBusinessSeviceImp implements PiPayBusinessApi {

    @Value("${r3.pipay.url}")
    private String url;

    @Override
    public PageQueryResponseEntity pageQuery(PageQueryEntity pageQueryEntity) {
        //构建body
        pageQueryEntity.setSignWithMap(pageQueryEntity.toMap());
        JSONObject bodyObject = pageQueryEntity.toJSONObject();
        log.debug("bodyObject:" + bodyObject.toJSONString());
        PageQueryResponseEntity ret = post(BusinessMethod.PAGE_QUERY, bodyObject, PageQueryResponseEntity.class);
        log.debug("ret:" + ret.toJSONString());
        return ret;
    }

    private <T> T post(BusinessMethod payMethod, JSONObject bodyObject, Class<T> tClass) {

        PayRestTemplate payRestTemplate = PayRestTemplateConf.getInstance();
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
        try {
            String body = URLEncoder.encode(bodyObject.toJSONString(), "UTF-8");
            HttpEntity<String> request = new HttpEntity(body, headers);
            log.debug(url + " body:" + body);
            T ret = payRestTemplate.postForRequestBody(url + "/pay/" + payMethod.getValue(), request, tClass);
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
            try {
                PiPayResponseEntity piPayResponseEntity = (PiPayResponseEntity) tClass.newInstance();
                piPayResponseEntity.setStatusCode("FAIL");
                piPayResponseEntity.setErrMsg("请求失败");
                return (T) piPayResponseEntity;
            } catch (InstantiationException e1) {
                e1.printStackTrace();
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            }
        }

        return null;
    }

    private <T> T postJson(PayMethod payMethod, JSONObject bodyObject, Class<T> tClass) {

        PayRestTemplate payRestTemplate = PayRestTemplateConf.getInstance();
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Content-Type", "application/json;charset=UTF-8");
        try {
            HttpEntity<String> request = new HttpEntity(bodyObject, headers);
            T ret = payRestTemplate.postForRequestBody(url + "/pay/" + payMethod.getValue(), request, tClass);
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
            try {
                PiPayResponseEntity piPayResponseEntity = (PiPayResponseEntity) tClass.newInstance();
                piPayResponseEntity.setStatusCode("FAIL");
                piPayResponseEntity.setErrMsg("请求失败");
                return (T) piPayResponseEntity;
            } catch (InstantiationException e1) {
                e1.printStackTrace();
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            }
        }

        return null;
    }
}
