package com.jackrain.pay.pi.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jackrain.pay.api.PiPayApi;
import com.jackrain.pay.pi.enums.PayMethod;
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
import java.util.HashMap;
import java.util.Map;

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
public class PiPaySeviceImp implements PiPayApi {

    @Value("${r3.pipay.url}")
    private String url;

    @Value("${r3.pipay.downbill.url}")
    private String downbillUrl;

    @Override
    public MircoPayResponseEntity mircopay(MircoPayEntity mircoPayEntity) {

        //构建body
        mircoPayEntity.setSignWithMap(mircoPayEntity.toMap());
        JSONObject bodyObject = mircoPayEntity.toJSONObject();
        log.debug("bodyObject:" + bodyObject.toJSONString());
        MircoPayResponseEntity ret = postJson(PayMethod.METHOD_MICROPAY,bodyObject,MircoPayResponseEntity.class);
        log.debug("ret:" + ret.toJSONString());
        return ret;
//        return null;
    }

    @Override
    public OrderQueryResponseEntity orderquery(OrderQueryEntity orderQueryEntity) {

        //构建body
        orderQueryEntity.setSignWithMap(orderQueryEntity.toMap());
        JSONObject bodyObject = orderQueryEntity.toJSONObject();
        log.debug("bodyObject:" + bodyObject.toJSONString());
        OrderQueryResponseEntity ret = post(PayMethod.METHOD_ORDERQUERY,bodyObject,OrderQueryResponseEntity.class);
        log.debug("ret:" + ret.toJSONString());
        return ret;
    }

    @Override
    public RefundResponseEntity refund(RefundEntity refundEntity) {

        //构建body
        refundEntity.setSignWithMap(refundEntity.toMap());
        JSONObject bodyObject = refundEntity.toJSONObject();
        log.debug("bodyObject:" + bodyObject.toJSONString());
        RefundResponseEntity ret = post(PayMethod.METHOD_REFUND,bodyObject,RefundResponseEntity.class);
        log.debug("ret:" + ret.toJSONString());
        return ret;
    }

    @Override
    public RefundQueryResponseEntity refundquery(RefundQueryEntity refundQueryEntity) {

        //构建body
        refundQueryEntity.setSignWithMap(refundQueryEntity.toMap());
        JSONObject bodyObject = refundQueryEntity.toJSONObject();
        log.debug("bodyObject:" + bodyObject.toJSONString());
        RefundQueryResponseEntity ret = post(PayMethod.METHOD_REFUNDQUERY,bodyObject,RefundQueryResponseEntity.class);
        log.debug("ret:" + ret.toJSONString());
        return ret;
    }

    @Override
    public PrecreateResponseEntity precreate(PrecreateEntity precreateEntity) {

        //构建body
        precreateEntity.setSignWithMap(precreateEntity.toMap());
        JSONObject bodyObject = precreateEntity.toJSONObject();
        log.debug("bodyObject:" + bodyObject.toJSONString());
        PrecreateResponseEntity ret = post(PayMethod.METHOD_PRECREATE,bodyObject,PrecreateResponseEntity.class);
        log.debug("ret:" + ret.toJSONString());
        return ret;
    }

    @Override
    public ReverseResponseEntity reverse(ReverseEntity reverseEntity) {

        //构建body
        reverseEntity.setSignWithMap(reverseEntity.toMap());
        JSONObject bodyObject = reverseEntity.toJSONObject();
        log.debug("bodyObject:" + bodyObject.toJSONString());
        ReverseResponseEntity ret = post(PayMethod.METHOD_REVERSE,bodyObject, ReverseResponseEntity.class);
        log.debug("ret:" + ret.toJSONString());
        return ret;
    }

    @Override
    public CloseResponseEntity closePay(CloseEntity closeEntity) {
        //构建body
        closeEntity.setSignWithMap(closeEntity.toMap());
        JSONObject bodyObject = closeEntity.toJSONObject();
        log.debug("bodyObject:" + bodyObject.toJSONString());
        CloseResponseEntity ret = post(PayMethod.METHOD_CLOSE,bodyObject, CloseResponseEntity.class);
        log.debug("ret:" + ret.toJSONString());
        return ret;
    }

    @Override
    public DownloadBillResponseEntity downloadBill(DownloadBillEntity downloadBillEntity) {
        //构建body
        downloadBillEntity.setSignWithMap(downloadBillEntity.toMap());
        JSONObject bodyObject = downloadBillEntity.toJSONObject();
        log.debug("bodyObject:" + bodyObject.toJSONString());
        DownloadBillResponseEntity ret = post(PayMethod.METHOD_DOWNLOAD_BILL,bodyObject, DownloadBillResponseEntity.class);
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

    @Override
    public JSONObject qrcodeUrl(PrecreateEntity precreateEntity) {

        //构建body
        precreateEntity.setSignWithMap(precreateEntity.toMap());
        JSONObject paramObject = precreateEntity.toJSONObject();
        log.debug("paramObject:" + paramObject.toJSONString());

        PayRestTemplate payRestTemplate = PayRestTemplateConf.getInstance();
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");

        String body = "";
        try {
            JSONObject bodyObject = new JSONObject();
            bodyObject.put("json", paramObject.toJSONString());
            body = URLEncoder.encode(bodyObject.toJSONString(),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        HttpEntity<String> request = new HttpEntity(body,headers);
        JSONObject res = payRestTemplate.postForRequestBody(url + "/webpay/qrcode/url",request,JSONObject.class);

        return res;
    }

    private <T> T post(PayMethod payMethod , JSONObject bodyObject,Class<T> tClass){

        PayRestTemplate payRestTemplate = PayRestTemplateConf.getInstance();
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
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

    private <T> T postJson(PayMethod payMethod , JSONObject bodyObject,Class<T> tClass){

        PayRestTemplate payRestTemplate = PayRestTemplateConf.getInstance();
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Content-Type","application/json;charset=UTF-8");
        try {
            HttpEntity<String> request = new HttpEntity(bodyObject,headers);
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
