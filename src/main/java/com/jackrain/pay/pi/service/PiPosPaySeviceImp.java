package com.jackrain.pay.pi.service;

import com.alibaba.fastjson.JSONObject;
import com.jackrain.pay.api.PiPayApi;

import com.jackrain.pay.api.PiPosPayApi;
import com.jackrain.pay.pi.enums.PayMethod;
import com.jackrain.pay.pi.enums.PosPayMethod;
import com.jackrain.pay.pi.model.*;
import com.jackrain.pay.pi.model.pospay.*;
import com.jackrain.pay.utils.MD5Utils;
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
public class PiPosPaySeviceImp implements PiPosPayApi {

    @Value("${r3.pipay.url}")
    private String url;

    @Value("${r3.pipay.downbill.url}")
    private String downbillUrl;

    @Override
    public PosPreOrderResponseEntity preorder(PosPreOrderEntity posPreOrderEntity) {
        //构建body
        posPreOrderEntity.setSignWithMap(posPreOrderEntity.toMap());
        JSONObject bodyObject = posPreOrderEntity.toJSONObject();
        log.debug("bodyObject:" + bodyObject.toJSONString());

        PosPreOrderResponseEntity ret = post(PosPayMethod.METHOD_PREORDER,bodyObject,PosPreOrderResponseEntity.class);
        log.debug("ret:" + ret.toJSONString());
        return ret;

//        return new PosPreOrderResponseEntity();

    }

    @Override
    public PosOrderQueryResponseEntity orderquery(PosOrderQueryEntity posOrderQueryEntity) {
        //构建body
        posOrderQueryEntity.setSignWithMap(posOrderQueryEntity.toMap());
        JSONObject bodyObject = posOrderQueryEntity.toJSONObject();
        log.debug("bodyObject:" + bodyObject.toJSONString());
        PosOrderQueryResponseEntity ret = post(PosPayMethod.METHOD_ORDERQUERY,bodyObject,PosOrderQueryResponseEntity.class);
        log.debug("ret:" + ret.toJSONString());
        return ret;
    }

    @Override
    public PosRefundResponseEntity refund(PosRefundEntity posRefundEntity) {
        //构建body
        posRefundEntity.setSignWithMap(posRefundEntity.toMap());
        JSONObject bodyObject = posRefundEntity.toJSONObject();
        log.debug("bodyObject:" + bodyObject.toJSONString());
        PosRefundResponseEntity ret = post(PosPayMethod.METHOD_REFUND,bodyObject,PosRefundResponseEntity.class);
        log.debug("ret:" + ret.toJSONString());
        return ret;
    }

    @Override
    public PosRefundQueryResponseEntity refundquery(PosRefundQueryEntity posRefundQueryEntity) {
        //构建body
        posRefundQueryEntity.setSignWithMap(posRefundQueryEntity.toMap());
        JSONObject bodyObject = posRefundQueryEntity.toJSONObject();
        log.debug("bodyObject:" + bodyObject.toJSONString());
        PosRefundQueryResponseEntity ret = post(PosPayMethod.METHOD_REFUNDQUERY,bodyObject,PosRefundQueryResponseEntity.class);
        log.debug("ret:" + ret.toJSONString());
        return ret;
    }

    @Override
    public PosReverseResponseEntity reverse(PosReverseEntity posReverseEntity) {
        //构建body
        posReverseEntity.setSignWithMap(posReverseEntity.toMap());
        JSONObject bodyObject = posReverseEntity.toJSONObject();
        log.debug("bodyObject:" + bodyObject.toJSONString());
        PosReverseResponseEntity ret = post(PosPayMethod.METHOD_REVERSE,bodyObject, PosReverseResponseEntity.class);
        log.debug("ret:" + ret.toJSONString());
        return ret;
    }

    @Override
    public JSONObject downloadAlipayBill(JSONObject param) {

        String paramStr = PiPayEntity.getSignString(param,param.getString("developerKey"));
        String sign = MD5Utils.MD5Encode(paramStr,"utf-8");
        param.put("sign",sign);

        PayRestTemplate payRestTemplate = PayRestTemplateConf.getInstance();
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
//        Map<String,JSONObject> map = new HashMap<>();
        headers.add("PARAMS",param.toJSONString());
        JSONObject res = payRestTemplate.postForRequestParam(downbillUrl,headers,JSONObject.class);

        return res;
    }

    private <T> T post(PosPayMethod payMethod , JSONObject bodyObject,Class<T> tClass){

        PayRestTemplate payRestTemplate = PayRestTemplateConf.getInstance();
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
//        headers.add("Content-Type","application/json;charset=UTF-8");
        try {
            String body = URLEncoder.encode(bodyObject.toJSONString(),"UTF-8");
            HttpEntity<String> request = new HttpEntity(body,headers);
            log.debug(url + " body:" + body);
            T ret = payRestTemplate.postForRequestBody(url + payMethod.getValue(),request,tClass);
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
