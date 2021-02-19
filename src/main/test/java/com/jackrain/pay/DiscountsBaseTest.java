package com.jackrain.pay;

import com.alibaba.fastjson.JSONObject;
import com.jackrain.pay.api.DiscountsApi;
import com.jackrain.pay.pi.model.discounts.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;

/**
 * @Description :
 * @Reference :
 * @Author : zc
 * @CreateDate : 2019-09-02 15:10
 * @Modify:
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PayApplication.class)
@Slf4j
public class DiscountsBaseTest {

    @Autowired
    DiscountsApi discountsApi;


    @Test
    public void discounts() {
        DiscountsEntity discountsEntity = new DiscountsEntity();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        discountsEntity.setTimestamp(timestamp.toString());

        discountsEntity.setDeveloperKey("1234567890");
        discountsEntity.setTotalAmount(1);
        discountsEntity.setOutTradeNo("8098098234");
        discountsEntity.setStoreCode("test");
        discountsEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
        discountsEntity.setPayChannel("SSPWCANPAY");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("keyword", "123");
        jsonObject.put("keyType", "01");
        jsonObject.put("orgno", "123123");
        discountsEntity.setUserIdentity(jsonObject);

        DiscountsResponseEntity discountsResponseEntity = discountsApi.discounts(discountsEntity);
        System.out.println(discountsResponseEntity);
    }


    @Test
    public void discountsQuery() {
        DiscountsQueryEntity discountsQueryEntity = new DiscountsQueryEntity();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        discountsQueryEntity.setTimestamp(timestamp.toString());

        discountsQueryEntity.setDeveloperKey("1234567890");
        discountsQueryEntity.setOutTradeNo("8098098234");
        discountsQueryEntity.setStoreCode("test");
        discountsQueryEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
        discountsQueryEntity.setPayChannel("SSPWCANPAY");

        DiscountsQueryResponseEntity discountsQueryResponseEntity = discountsApi.discountsQuery(discountsQueryEntity);
        System.out.println(discountsQueryResponseEntity.toJSONString());
    }

    @Test
    public void discountsRefund() {
        DiscountsRefundEntity discountsRefundEntity = new DiscountsRefundEntity();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        discountsRefundEntity.setTimestamp(timestamp.toString());

        discountsRefundEntity.setDeveloperKey("1234567890");
        discountsRefundEntity.setTotalAmount(1);
        discountsRefundEntity.setOutTradeNo("8098098234");
        discountsRefundEntity.setStoreCode("merchantTest2");
        discountsRefundEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
        discountsRefundEntity.setPayChannel("SSPWCANPAY");
//        discountsRefundEntity.setTradeNo("123123");

        DiscountsRefundResponseEntity discountsRefundResponseEntity = discountsApi.discountsRefund(discountsRefundEntity);
        System.out.println(discountsRefundResponseEntity);
    }

    @Test
    public void discountsRefundQuery() {
        DiscountsRefundQueryEntity discountsRefundQueryEntity = new DiscountsRefundQueryEntity();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        discountsRefundQueryEntity.setTimestamp(timestamp.toString());

        discountsRefundQueryEntity.setDeveloperKey("1234567890");
//        discountsRefundQueryEntity.setOutTradeNo("1231232343080");
        discountsRefundQueryEntity.setTradeNo("123123123");
        discountsRefundQueryEntity.setStoreCode("test");
        discountsRefundQueryEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
        discountsRefundQueryEntity.setPayChannel("SSPWCANPAY");

        DiscountsRefundQueryResponseEntity discountsRefundQueryResponseEntity = discountsApi.discountsRefundQuery(discountsRefundQueryEntity);
        System.out.println(discountsRefundQueryResponseEntity);
    }


}
