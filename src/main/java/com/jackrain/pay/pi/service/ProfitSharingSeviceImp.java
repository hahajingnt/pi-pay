package com.jackrain.pay.pi.service;

import com.alibaba.fastjson.JSONObject;
import com.jackrain.pay.api.PiPayApi;
import com.jackrain.pay.api.ProfitSharingApi;
import com.jackrain.pay.pi.enums.PayMethod;
import com.jackrain.pay.pi.enums.ProfitSharingMethod;
import com.jackrain.pay.pi.model.*;
import com.jackrain.pay.utils.MD5Utils;
import com.jackrain.pay.web.PayRestTemplate;
import com.jackrain.pay.web.PayRestTemplateConf;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 *
 * 移动支付实现
 *
 * @author: z.c
 * @since: 2019/11/25
 * create at : 2019/11/25 11:21 AM
 *
 */
@Component
@Slf4j
public class ProfitSharingSeviceImp implements ProfitSharingApi {

    @Value("${r3.pipay.url}")
    private String url;

    @Override
    public PsReceiverAddResponseEntity receiverAdd(PsReceiverAddEntity psReceiverAddEntity) {
        //构建body
        psReceiverAddEntity.setSignWithMap(psReceiverAddEntity.toMap());
        JSONObject bodyObject = psReceiverAddEntity.toJSONObject();
        log.debug("bodyObject:" + bodyObject.toJSONString());
        PsReceiverAddResponseEntity ret = post(ProfitSharingMethod.METHOD_RECEIVER_ADD,bodyObject,PsReceiverAddResponseEntity.class);
        log.debug("ret:" + ret.toJSONString());

        return ret;
    }

    @Override
    public PsReceiverRemoveResponseEntity receiverRemove(PsReceiverRemoveEntity psReceiverRemoveEntity) {
        return null;
    }

    @Override
    public ProfitSharingMultiResponseEntity profitSharingMulti(ProfitSharingMultiEntity profitSharingMultiEntity) {
        //构建body
        profitSharingMultiEntity.setSignWithMap(profitSharingMultiEntity.toMap());
        JSONObject bodyObject = profitSharingMultiEntity.toJSONObject();
        log.debug("bodyObject:" + bodyObject.toJSONString());
        ProfitSharingMultiResponseEntity ret = post(ProfitSharingMethod.METHOD_PROFITSHARING_MULTI,bodyObject,ProfitSharingMultiResponseEntity.class);
        log.debug("ret:" + ret.toJSONString());

        return ret;
    }

    @Override
    public ProfitSharingQueryResponseEntity profitSharingQuery(ProfitSharingQueryEntity profitSharingQueryEntity) {
        //构建body
        profitSharingQueryEntity.setSignWithMap(profitSharingQueryEntity.toMap());
        JSONObject bodyObject = profitSharingQueryEntity.toJSONObject();
        log.debug("bodyObject:" + bodyObject.toJSONString());
        ProfitSharingQueryResponseEntity ret = post(ProfitSharingMethod.METHOD_PROFITSHARING_QUERY,bodyObject,ProfitSharingQueryResponseEntity.class);
        log.debug("ret:" + ret.toJSONString());

        return ret;
    }

    private <T> T post(ProfitSharingMethod payMethod , JSONObject bodyObject,Class<T> tClass){

        PayRestTemplate payRestTemplate = PayRestTemplateConf.getInstance();
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
//        headers.add("Content-Type","application/json;charset=UTF-8");
        try {
            String body = URLEncoder.encode(bodyObject.toJSONString(),"UTF-8");
            HttpEntity<String> request = new HttpEntity(body,headers);
            log.debug(url + " body:" + body);
            T ret = payRestTemplate.postForRequestBody(url + "/pay/" + payMethod.getValue(),request,tClass);
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
