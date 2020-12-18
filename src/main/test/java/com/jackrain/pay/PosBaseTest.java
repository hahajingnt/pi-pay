package com.jackrain.pay;

import com.jackrain.pay.api.PiPosPayApi;
import com.jackrain.pay.pi.model.pospay.*;
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
public class PosBaseTest {


    @Autowired
    PiPosPayApi piPosPayApi;

    @Test
    public void preOrder() {

        PosPreOrderEntity posPreOrderEntity = new PosPreOrderEntity();
//        mircoPayEntity.setDeveloperId("82");
//        posPreOrderEntity.setDeveloperId("001");
        posPreOrderEntity.setDeveloperKey("1234567890");
//        mircoPayEntity.setDeveloperKey("438d66903cf002573c3c0d02f4daa0a9");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        log.info(timestamp.toString());

        posPreOrderEntity.setTimestamp(timestamp.toString());
        posPreOrderEntity.setSubject("JNBY");
        posPreOrderEntity.setOutTradeNo(String.valueOf(System.currentTimeMillis()));
//        posPreOrderEntity.setOutTradeNo("AZ2011171p4s12200002");
        posPreOrderEntity.setTotalAmount(1);
        posPreOrderEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
        posPreOrderEntity.setStoreCode("JNBY");
        posPreOrderEntity.setPayChannel("shouqianba");
//        posPreOrderEntity.setTerminalId("1");
        posPreOrderEntity.setCashRegisterNo("0");
//        posPreOrderEntity.setPayChannel("shouqianba");
//        posPreOrderEntity.setTerminalId("1");
//        posPreOrderEntity.setPayWay("relaedpos");


//        posPreOrderEntity.setPayChannel("shouqianba");
//        posPreOrderEntity.setNotifyUrl("http://pay-apps-web-qa.pay2.piplus.cn/sqb/open/pos/order/callback");

//        mircoPayEntity.setDeviceInfo("webPos");
//        mircoPayEntity.setVipNo("-1");
//        mircoPayEntity.setPayment("1");
//        mircoPayEntity.setOperatorId("3429");
//        mircoPayEntity.setPayWay("ALIPAY");
//
//        List<PosGoodsDetailEntity> goodsDetail = new LinkedList<>();
//        PosGoodsDetailEntity posGoodsDetailEntity = new PosGoodsDetailEntity();
//        posGoodsDetailEntity.setGoodsId("测试id");
//        posGoodsDetailEntity.setGoodsName("测试");
//        posGoodsDetailEntity.setPrice("1");
//        posGoodsDetailEntity.setQuantity("1");
//        goodsDetail.add(posGoodsDetailEntity);
//        posPreOrderEntity.setGoodsDetail(goodsDetail);
//
//        List<PosTendersEntity> posTendersEntityList = new ArrayList<>();
//        PosTendersEntity posTendersEntity = new PosTendersEntity();
//        posTendersEntity.setTenderType("QRCODE");
////        posTendersEntity.setPayWay("UNIONPAY");
////        posTendersEntity.setPayWayDesc("银行卡支付");
//        posTendersEntity.setTotalAmount(1);
//        posTendersEntity.setTransactionSn("11111111");

//        posTendersEntity.setTransactionSn(posPreOrderEntity.getOutTradeNo());
//        posTendersEntity.setPayStatus("WAITOPERATION");
//        posTendersEntity.setOriginalTenderSn("12312");
//        posTendersEntityList.add(posTendersEntity);
//        PosTendersEntity posTendersEntity1 = new PosTendersEntity();
//        posTendersEntity1.setTenderType("QRCODE");
//        posTendersEntity1.setTotalAmount(2);
//        posTendersEntity1.setTransactionSn("222222222");
//        posTendersEntityList.add(posTendersEntity1);
//        posPreOrderEntity.setTenders(posTendersEntityList);
        PosPreOrderResponseEntity piPayResponseEntity = piPosPayApi.preorder(posPreOrderEntity);
        System.out.println(piPayResponseEntity.toJSONString());

    }

    @Test
    public void orderquery() {

        PosOrderQueryEntity orderQueryEntity = new PosOrderQueryEntity();
//        orderQueryEntity.setDeveloperId("82");
//        orderQueryEntity.setDeveloperId("001");
        orderQueryEntity.setDeveloperKey("1234567890");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        log.info(timestamp.toString());
        orderQueryEntity.setTimestamp(timestamp.toString());
//        orderQueryEntity.setTradeNo("7903247730611100");
        orderQueryEntity.setOutTradeNo("12323424242125434");
        orderQueryEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
        orderQueryEntity.setStoreCode("JNBY");
        orderQueryEntity.setPayChannel("fomopay");
        orderQueryEntity.setCashRegisterNo("0");
//        orderQueryEntity.setCashRegisterNo("1");
//        orderQueryEntity.setNotifyUrl("");


        piPosPayApi.orderquery(orderQueryEntity);

    }

    @Test
    public void refund() {

        PosRefundEntity refundEntity = new PosRefundEntity();
//        refundEntity.setDeveloperId("82");
        refundEntity.setDeveloperId("001");
        refundEntity.setDeveloperKey("1234567890");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        refundEntity.setTimestamp(timestamp.toString());
        refundEntity.setOutTradeNo("1607923271157");
//        refundEntity.setTradeNo("7903247730611100");
        refundEntity.setOutRefundNo("46575756772342234673");
//        refundEntity.setStoreCode("JNBY");
        refundEntity.setSubject("退款测试");
        refundEntity.setRefundAmount(1);
        refundEntity.setPayChannel("shouqianba");
//        refundEntity.setTradeNo("20200403144757000031022321");
        refundEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
        refundEntity.setStoreCode("JNBY");
        refundEntity.setCashRegisterNo("0");

        piPosPayApi.refund(refundEntity);

    }

    @Test
    public void refundquery() {

        PosRefundQueryEntity refundQueryEntity = new PosRefundQueryEntity();
//        refundQueryEntity.setDeveloperId("001");
        refundQueryEntity.setDeveloperKey("dbdbe0a06b724687abddb0cbaf452b45");
//        refundQueryEntity.setDeveloperId("82");
//        refundQueryEntity.setDeveloperKey("5e24d575ce275dd34b549ba80337053e");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        log.info(timestamp.toString());
        refundQueryEntity.setTimestamp(timestamp.toString());
//        refundQueryEntity.setTradeNo("");
//        refundQueryEntity.setOutTradeNo("1000040000094");
        refundQueryEntity.setOutRefundNo("RE2012010038606");
        refundQueryEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
//        refundQueryEntity.setStoreCode("001");
        refundQueryEntity.setStoreCode("CS000001");
        refundQueryEntity.setPayChannel("shouqianba");
        piPosPayApi.refundquery(refundQueryEntity);

    }


    @Test
    public void reverse() {

        PosReverseEntity reverseEntity = new PosReverseEntity();
        reverseEntity.setDeveloperId("001");
        reverseEntity.setDeveloperKey("1234567890");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        log.info(timestamp.toString());
        reverseEntity.setTimestamp(timestamp.toString());

        reverseEntity.setOutTradeNo("1607495043796");
//        reverseEntity.setTradeNo("200514999888000017");
        reverseEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
        reverseEntity.setStoreCode("JNBY");
        reverseEntity.setPayChannel("shouqianba");

//        reverseEntity.setOutTradeNo("A420102411n74165490001");
        reverseEntity.setOutReverseNo("2342253453431122");
//        reverseEntity.setTradeNo("200514999888000017");
//        reverseEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");

        piPosPayApi.reverse(reverseEntity);

    }

    @Test
    public void refundReverse(){
        PosRefundReverseEntity posRefundReverseEntity = new PosRefundReverseEntity();
        posRefundReverseEntity.setDeveloperId("001");
        posRefundReverseEntity.setDeveloperKey("1234567890");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        log.info(timestamp.toString());
        posRefundReverseEntity.setTimestamp(timestamp.toString());

//        posRefundReverseEntity.setRefundTradeNo("7903247730961502");
        posRefundReverseEntity.setOutRefundNo("46575756772342234673");
//        reverseEntity.setTradeNo("200514999888000017");
        posRefundReverseEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
        posRefundReverseEntity.setStoreCode("JNBY");
        posRefundReverseEntity.setPayChannel("shouqianba");

//        reverseEntity.setOutTradeNo("A420102411n74165490001");
//        posRefundReverseEntity.setOutReverseNo("2342253453431122");
//        reverseEntity.setTradeNo("200514999888000017");

        PosRefundReverseResponseEntity posRefundReverseResponseEntity = piPosPayApi.refundReverse(posRefundReverseEntity);
        System.out.println(posRefundReverseResponseEntity);
    }

}
