package com.jackrain.pay;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jackrain.pay.api.PiJumpPayApi;
import com.jackrain.pay.api.PiPayApi;
import com.jackrain.pay.api.ProfitSharingApi;
import com.jackrain.pay.pi.model.*;
import com.jackrain.pay.pi.model.jumppay.JumpPayEntity;
import com.jackrain.pay.pi.model.jumppay.JumpPayResponseEntity;
import com.jackrain.pay.pi.model.jumppay.JumpRefundEntity;
import com.jackrain.pay.pi.model.jumppay.JumpRefundResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
public class JumpPayBaseTest {

    @Autowired
    PiJumpPayApi piJumpPayApi;

    @Autowired
    PiPayApi piPayApi;


    @Test
    public void jumpPay() {

        JumpPayEntity jumpPayEntity = new JumpPayEntity();
        jumpPayEntity.setDeveloperKey("1234567890");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        log.info(timestamp.toString());
        jumpPayEntity.setTimestamp(timestamp.toString());
        jumpPayEntity.setFeeType("CNY");
        jumpPayEntity.setOutTradeNo(String.valueOf(System.currentTimeMillis()));
        jumpPayEntity.setTotalAmount(1);
        jumpPayEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
        JSONArray goods = new JSONArray();
        JSONObject good = new JSONObject();
        good.put("quantity","1");
        good.put("goods_name","喜力啤酒500ml瓶装");
        good.put("goods_id","PJXYA0006");
        good.put("price","1");
        goods.add(good);
//        jumpPayEntity.setGoodsDetail(goods);
        jumpPayEntity.setPayChannel("PLEASEQUICKPAY");
        JumpPayResponseEntity piPayResponseEntity = piJumpPayApi.jumpPay(jumpPayEntity);
        System.out.println(piPayResponseEntity.toJSONString());

    }


    @Test
    public void jumpRefund() {

        JumpRefundEntity jumpRefundEntity = new JumpRefundEntity();
        jumpRefundEntity.setDeveloperKey("1234567890");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        jumpRefundEntity.setTimestamp(timestamp.toString());
        jumpRefundEntity.setOutTradeNo("1620876202537");
        jumpRefundEntity.setOutRefundNo("23434345345");
        jumpRefundEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
        jumpRefundEntity.setRefundAmount(1);
        jumpRefundEntity.setPayChannel("PLEASEQUICKPAY");
        JSONArray goods = new JSONArray();
        JSONObject good = new JSONObject();
        good.put("quantity","1");
        good.put("goods_name","喜力啤酒500ml瓶装");
        good.put("goods_id","PJXYA0006");
        good.put("price","1");
        goods.add(good);
        jumpRefundEntity.setGoodsDetail(goods);
        JumpRefundResponseEntity jumpRefundResponseEntity = piJumpPayApi.jumpRefund(jumpRefundEntity);
        System.out.println(jumpRefundResponseEntity.toJSONString());

    }

    @Test
    public void orderquery() {
        List<String> list = new ArrayList<>();

        OrderQueryEntity orderQueryEntity = new OrderQueryEntity();
//        orderQueryEntity.setDeveloperId("82");
//        orderQueryEntity.setDeveloperId("001");
        orderQueryEntity.setDeveloperKey("1234567890");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        log.info(timestamp.toString());
        orderQueryEntity.setTimestamp(timestamp.toString());
//        orderQueryEntity.setTradeNo("lt2103200061949704275955713");
        orderQueryEntity.setOutTradeNo("1620876202537");
        orderQueryEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
//        orderQueryEntity.setStoreCode("sqbtest");

//        orderQueryEntity.setStoreCode("001");
//        orderQueryEntity.setPayChannel("CHINAUMS_YDQRCODEPAY");
//        orderQueryEntity.setPayChannel("ZHONGMAPAY");
        orderQueryEntity.setPayChannel("PLEASEQUICKPAY");
        OrderQueryResponseEntity orderQueryResponseEntity = piPayApi.orderquery(orderQueryEntity);
        System.out.println(orderQueryResponseEntity.toJSONString());
    }


    @Test
    public void refundquery() {

        RefundQueryEntity refundQueryEntity = new RefundQueryEntity();
//        refundQueryEntity.setDeveloperId("001");
        refundQueryEntity.setDeveloperKey("1234567890");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        log.info(timestamp.toString());
        refundQueryEntity.setTimestamp(timestamp.toString());
//        refundQueryEntity.setTradeNo("6662008316706034529171714048");
//        refundQueryEntity.setOutTradeNo("1603182903615");
//        refundQueryEntity.setTradeNo("4200000816202010283279997949");
        refundQueryEntity.setOutTradeNo("1620876202537");
        refundQueryEntity.setOutRefundNo("23434345345");
        refundQueryEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
//        refundQueryEntity.setStoreCode("001");
        refundQueryEntity.setPayChannel("PLEASEQUICKPAY");
        piPayApi.refundquery(refundQueryEntity);

    }

}
