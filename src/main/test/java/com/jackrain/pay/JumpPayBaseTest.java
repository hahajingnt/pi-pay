package com.jackrain.pay;

import com.jackrain.pay.api.PiJumpPayApi;
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


    @Test
    public void jumpPay() {

        JumpPayEntity jumpPayEntity = new JumpPayEntity();
//        mircoPayEntity.setDeveloperId("82");
//        mircoPayEntity.setDeveloperId("001");
        jumpPayEntity.setDeveloperKey("1234567890");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        log.info(timestamp.toString());
        jumpPayEntity.setTimestamp(timestamp.toString());
//        mircoPayEntity.setPayWay("ALIPAY");
        jumpPayEntity.setFeeType("CNY");
//        mircoPayEntity.setStoreCode("CS98");
//        mircoPayEntity.setStoreCode("sqbtest");
        jumpPayEntity.setOutTradeNo(String.valueOf(System.currentTimeMillis()));
        jumpPayEntity.setTotalAmount(1);
        jumpPayEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
//        mircoPayEntity.setChannelStoreId("123123123");
//        mircoPayEntity.setStoreCode("Z0211027");
//        mircoPayEntity.setPayChannel("ICBCPAY");
//        mircoPayEntity.setDeviceInfo("webPos");
//        mircoPayEntity.setVipNo("-1");
//        mircoPayEntity.setPayment("1");
//        mircoPayEntity.setOperatorId("3429");
//        mircoPayEntity.setPayWay("ALIPAY");
//        mircoPayEntity.setProfitSharing("Y");
//        JSONArray goods = new JSONArray();
//        // [{"quantity": "1", "goods_name": "看海", "goods_id": "100020", "price": "36800"}]
//        JSONObject good = new JSONObject();
//        good.put("quantity","1");
//        good.put("goods_name","喜力啤酒500ml瓶装");
//        good.put("goods_id","PJXYA0006");
//        good.put("price","5.7");
//        goods.add(good);
//        JSONObject good2 = new JSONObject();
//        good2.put("quantity","3");
//        good2.put("goods_name","喜力啤酒500ml瓶装");
//        good2.put("goods_id","PJXYA0006");
//        good2.put("price","5.7");
//        goods.add(good2);
//        JSONObject good3 = new JSONObject();
//        good3.put("quantity", "1");
//        good3.put("goods_name", "ttt）");
//        good3.put("goods_id", "QT0000086");
//        good3.put("price", "1");
//        goods.add(good3);
//        mircoPayEntity.setGoodsDetail(goods);
//        mircoPayEntity.setExtendField("测试");
//        //
//        JSONObject extendParams = new JSONObject();
//        extendParams.put("hb_fq_num","3");
//        extendParams.put("hb_fq_seller_percent","0");
//        mircoPayEntity.setExtendParams(extendParams);
//        mircoPayEntity.setPayChannel("lakalapay");
//        mircoPayEntity.setPayChannel("SHANDE_DIRECTPAY");
        jumpPayEntity.setPayChannel("PLEASEQUICKPAY");
//        mircoPayEntity.setChannelStoreId("0001");
        JumpPayResponseEntity piPayResponseEntity = piJumpPayApi.jumpPay(jumpPayEntity);
        System.out.println(piPayResponseEntity.toJSONString());

    }


    @Test
    public void jumpRefund() {

        JumpRefundEntity jumpRefundEntity = new JumpRefundEntity();
//        refundEntity.setDeveloperId("82");
//        refundEntity.setDeveloperId("001");
        jumpRefundEntity.setDeveloperKey("1234567890");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        jumpRefundEntity.setTimestamp(timestamp.toString());
        jumpRefundEntity.setOutTradeNo("1620266049878");
//        refundEntity.setTradeNo("P5FAA3812E358F0000131755F");
        jumpRefundEntity.setOutRefundNo("2340928349083204234");
        jumpRefundEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
//        refundEntity.setStoreCode("001");
        jumpRefundEntity.setRefundAmount(1);
//        refundEntity.setTotalAmount(200);
        jumpRefundEntity.setPayChannel("tonglianpay");
        JumpRefundResponseEntity jumpRefundResponseEntity = piJumpPayApi.jumpRefund(jumpRefundEntity);
        System.out.println(jumpRefundResponseEntity.toJSONString());

    }


}
