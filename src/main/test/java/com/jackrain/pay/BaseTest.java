package com.jackrain.pay;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jackrain.pay.api.PiPayApi;
import com.jackrain.pay.api.ProfitSharingApi;
import com.jackrain.pay.pi.enums.PrecreateType;
import com.jackrain.pay.pi.enums.TradeType;
import com.jackrain.pay.pi.model.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Set;

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
public class BaseTest {

    @Autowired
    PiPayApi piPayApi;

    @Autowired
    ProfitSharingApi profitSharingApi;

    @Test
    public void mircopay() {

        MircoPayEntity mircoPayEntity = new MircoPayEntity();
        mircoPayEntity.setDeveloperId("82");
//        mircoPayEntity.setDeveloperId("001");
//        mircoPayEntity.setDeveloperKey("1234567890");
        mircoPayEntity.setDeveloperKey("5e24d575ce275dd34b549ba80337053e");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        mircoPayEntity.setTimestamp(timestamp.toString());
        mircoPayEntity.setAuthCode("289561586286953803");
//        mircoPayEntity.setAuthCode("134722642940034835");
//        mircoPayEntity.setPayWay("WEIXINPAY");
//        mircoPayEntity.setFeeType("SGD");
        mircoPayEntity.setStoreCode("100001");
        mircoPayEntity.setBody("test");
        mircoPayEntity.setOutTradeNo(String.valueOf(System.currentTimeMillis()));
        mircoPayEntity.setTotalAmount(1);
        mircoPayEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
//        mircoPayEntity.setCustomerId("58DE500F8F17D1577CBBDA7D8D87DE5E");
//        mircoPayEntity.setStoreCode("Z0211027");
//        mircoPayEntity.setPayChannel("SHANDE_HMPAY");
//        mircoPayEntity.setDeviceInfo("webPos");
//        mircoPayEntity.setVipNo("-1");
//        mircoPayEntity.setPayment("1");
//        mircoPayEntity.setOperatorId("3429");
//        mircoPayEntity.setPayWay("ALIPAY");
//        mircoPayEntity.setProfitSharing("Y");
        JSONArray goods = new JSONArray();
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
        JSONObject good3 = new JSONObject();
        good3.put("quantity", "1");
        good3.put("goods_name", "ttt");
        good3.put("goods_id", "QT0000086");
        good3.put("price", "1");
        goods.add(good3);
        mircoPayEntity.setGoodsDetail(goods);
//        //
//        JSONObject extendParams = new JSONObject();
//        extendParams.put("hb_fq_num","3");
//        extendParams.put("hb_fq_seller_percent","0");
//        mircoPayEntity.setExtendParams(extendParams);
//        mircoPayEntity.setPayChannel("lakalapay");
//        mircoPayEntity.setPayChannel("ABCPAY");
//        mircoPayEntity.setPayChannel("fomopay");
        MircoPayResponseEntity piPayResponseEntity = piPayApi.mircopay(mircoPayEntity);
        System.out.println(piPayResponseEntity.toJSONString());

    }

    @Test
    public void orderquery() {


        OrderQueryEntity orderQueryEntity = new OrderQueryEntity();
//        orderQueryEntity.setDeveloperId("82");
//        orderQueryEntity.setDeveloperId("001");
        orderQueryEntity.setDeveloperKey("1234567890");
//        orderQueryEntity.setDeveloperKey("5e24d575ce275dd34b549ba80337053e");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        log.info(timestamp.toString());
        orderQueryEntity.setTimestamp(timestamp.toString());
//        orderQueryEntity.setTradeNo("2019112722001412545718971268");
        orderQueryEntity.setOutTradeNo("1622173276046");
        orderQueryEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
//        orderQueryEntity.setStoreCode("001");
//        orderQueryEntity.setPayChannel("CHINAUMS_YDQRCODEPAY");
//        orderQueryEntity.setPayChannel("ZHONGMAPAY");
        OrderQueryResponseEntity orderQueryResponseEntity = piPayApi.orderquery(orderQueryEntity);
        System.out.println(orderQueryResponseEntity.toJSONString());

    }

    @Test
    public void refund() {

        RefundEntity refundEntity = new RefundEntity();
//        refundEntity.setDeveloperId("82");
//        refundEntity.setDeveloperId("001");
        refundEntity.setDeveloperKey("1234567890");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        refundEntity.setTimestamp(timestamp.toString());
        refundEntity.setOutTradeNo("F018P12105111444250003");
//        refundEntity.setTradeNo("P5FAA3812E358F0000131755F");
        refundEntity.setOutRefundNo("RF018P12105111444250003");
        refundEntity.setCustomerId("58DE500F8F17D1577CBBDA7D8D87DE5E");
//        refundEntity.setStoreCode("001");
        refundEntity.setRefundAmount(49900);
        refundEntity.setTotalAmount(49900);
//        refundEntity.setPayChannel("fomopay");
        piPayApi.refund(refundEntity);

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
        refundQueryEntity.setOutTradeNo("345464565756756");
        refundQueryEntity.setOutRefundNo("12342245684566433447");
        refundQueryEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
        refundQueryEntity.setStoreCode("001");
        refundQueryEntity.setPayChannel("fomopay");
        piPayApi.refundquery(refundQueryEntity);

    }

    @Test
    public void precreate() {

        PrecreateEntity precreateEntity = new PrecreateEntity();
//        mircoPayEntity.setDeveloperId("82");
//        precreateEntity.setDeveloperId("001");
//        precreateEntity.setDeveloperKey("5e24d575ce275dd34b549ba80337053e");
        precreateEntity.setDeveloperKey("1234567890");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        log.info(timestamp.toString());
        precreateEntity.setTimestamp(timestamp.toString());
        precreateEntity.setPrecreateType(PrecreateType.WEIXINPAY.getValue());
        precreateEntity.setBody("test");
        precreateEntity.setOutTradeNo("23479544226345422");
        precreateEntity.setTotalAmount(1);
        precreateEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
        precreateEntity.setTradeType(TradeType.MWEB.getValue());
//        precreateEntity.setFeeType("SGD");
//        precreateEntity.setTimeoutExpress(5000);
//        precreateEntity.setStoreCode("003");
//        precreateEntity.setNotifyUrl("http://pay-apps-web-qa.pay2.piplus.cn/pipay/callback_success");
//        precreateEntity.setPayChannel("shouqianba");
        PrecreateResponseEntity precreateResponseEntity = piPayApi.precreate(precreateEntity);
        System.out.println(precreateResponseEntity.toJSONString());

    }

    @Test
    public void reverse() {

        ReverseEntity reverseEntity = new ReverseEntity();
//        reverseEntity.setDeveloperId("001");
        reverseEntity.setDeveloperKey("1234567890");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        log.info(timestamp.toString());
        reverseEntity.setTimestamp(timestamp.toString());
        reverseEntity.setOutTradeNo("123234242421254342");
        reverseEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
        reverseEntity.setStoreCode("001");
        reverseEntity.setPayChannel("fomopay");
        piPayApi.reverse(reverseEntity);

    }

    @Test
    public void close() {

        CloseEntity closeEntity = new CloseEntity();
//        closeEntity.setDeveloperId("001");
        closeEntity.setDeveloperKey("1234567890");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        log.info(timestamp.toString());
        closeEntity.setTimestamp(timestamp.toString());
        closeEntity.setOutTradeNo("PA20092500043");
        closeEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
//        closeEntity.setStoreCode("商户数据包001");
//        closeEntity.setPayChannel("CHINAUMS_YDQRCODEPAY");
        piPayApi.closePay(closeEntity);

    }

    @Test
    public void staticQrBatchQuery() {
        StaticQrBatchQueryEntity staticQrBatchQueryEntity = new StaticQrBatchQueryEntity();
        staticQrBatchQueryEntity.setDeveloperKey("1234567890");
        staticQrBatchQueryEntity.setDeveloperId("");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        log.info(timestamp.toString());
        staticQrBatchQueryEntity.setTimestamp(timestamp.toString());
        staticQrBatchQueryEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
        staticQrBatchQueryEntity.setPayChannel("fomopay");
        staticQrBatchQueryEntity.setStoreCode("123");
//        staticQrBatchQueryEntity.setCreateAtMin("2020-09-02 14:45:08.175");
        StaticQrBatchQueryResponseEntity staticQrBatchQueryResponseEntity = piPayApi.staticQrBatchQuery(staticQrBatchQueryEntity);
        System.out.println(staticQrBatchQueryResponseEntity);
    }

    @Test
    public void staticQrBindOrder() {
        StaticQrBindOrderEntity staticQrBindOrderEntity = new StaticQrBindOrderEntity();
        staticQrBindOrderEntity.setDeveloperKey("1234567890");
        staticQrBindOrderEntity.setDeveloperId("");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        log.info(timestamp.toString());
        staticQrBindOrderEntity.setTimestamp(timestamp.toString());
        staticQrBindOrderEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
        staticQrBindOrderEntity.setPayChannel("atomepay");
        staticQrBindOrderEntity.setStoreCode("123");
        staticQrBindOrderEntity.setOutTradeNo("54859834905834");
        staticQrBindOrderEntity.setPlatformNo("1607417483764732581");
        piPayApi.staticQrBindOrder(staticQrBindOrderEntity);

    }

    @Test
    public void batchSubmit() {
        BatchSubmitEntity batchSubmitEntity = new BatchSubmitEntity();
        batchSubmitEntity.setDeveloperKey("1234567890");
        batchSubmitEntity.setDeveloperId("");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        log.info(timestamp.toString());
        batchSubmitEntity.setTimestamp(timestamp.toString());
        batchSubmitEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
        batchSubmitEntity.setPayChannel("fomopay");
        batchSubmitEntity.setStoreCode("123");
        piPayApi.batchSubmit(batchSubmitEntity);
    }


    @Test
    public void downloadBill() {
        //
        DownloadBillEntity downloadBillEntity = new DownloadBillEntity();
        downloadBillEntity.setDeveloperId("001");
        downloadBillEntity.setDeveloperKey("1234567890");
        downloadBillEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        downloadBillEntity.setTimestamp(timestamp.toString());

        downloadBillEntity.setBillDate("20200603");
        downloadBillEntity.setBillType("ALL");
        downloadBillEntity.setInterfaceType("pay.bill.merchant");
        downloadBillEntity.setStoreCode("958300000003");
        downloadBillEntity.setPayChannel("HWCTONYIPAY");

        piPayApi.downloadBill(downloadBillEntity);

    }

    @Test
    public void downloadAlipayBill() {

        JSONObject param = new JSONObject();
        param.put("app_auth_token", "201810BB8bdd82c3a87b4aa196dea8a44857cC78");
        param.put("bill_date", "2020-04");//月份
        param.put("bill_type", "trade");
        JSONObject res = piPayApi.downloadAlipayBill(param);
        System.out.println(res.toJSONString());

    }


    @Test
    public void qrcodeUrl() {

        PrecreateEntity precreateEntity = new PrecreateEntity();
//        mircoPayEntity.setDeveloperId("82");
//        precreateEntity.setDeveloperId("001");
        precreateEntity.setDeveloperKey("fda372541404430c8f19db13cd57d155");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        log.info(timestamp.toString());
//        precreateEntity.setTimestamp(timestamp.toString());
        precreateEntity.setBody("MODERN MUSEUM摩登博物馆");
//        precreateEntity.setOutTradeNo("1100050000164");
//        precreateEntity.setTotalAmount(2);
        precreateEntity.setCustomerId("B390002369358F85692AEA6D841C12FE");
//        precreateEntity.setStoreCode("80009940");
        precreateEntity.setStaticQrcode("Y");

        JSONObject ret = piPayApi.qrcodeUrl(precreateEntity);
        System.out.println(ret.toJSONString());

    }

    @Test
    public void receiverAdd() {

        PsReceiverAddEntity psReceiverAddEntity = new PsReceiverAddEntity();
        psReceiverAddEntity.setDeveloperKey("1234567890");
        psReceiverAddEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        psReceiverAddEntity.setTimestamp(timestamp.toString());

        psReceiverAddEntity.setPayWay(PrecreateType.WEIXINPAY.getValue());
        JSONObject receiver = new JSONObject();
        receiver.put("type", "PERSONAL_OPENID");
        receiver.put("account", "oV7yY1XHkhhhV3ZJPJnvjEFhWcrM");
//        receiver.put("name","周城");
        receiver.put("relation_type", "STAFF");
        psReceiverAddEntity.setReceiver(receiver);

        profitSharingApi.receiverAdd(psReceiverAddEntity);

    }

    @Test
    public void profitSharingMulti() {

        ProfitSharingMultiEntity profitSharingMultiEntity = new ProfitSharingMultiEntity();
        profitSharingMultiEntity.setDeveloperKey("1234567890");
        profitSharingMultiEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        profitSharingMultiEntity.setTimestamp(timestamp.toString());

        profitSharingMultiEntity.setPayWay(PrecreateType.WEIXINPAY.getValue());
        profitSharingMultiEntity.setOutOrderNo("100000000000356665");
        profitSharingMultiEntity.setOutTradeNo("1600937367482");
        JSONArray receivers = new JSONArray();
        JSONObject receiver = new JSONObject();
        receiver.put("type", "PERSONAL_OPENID");
        receiver.put("account", "oV7yY1XHkhhhV3ZJPJnvjEFhWcrM");
        receiver.put("amount", 1);
        receiver.put("description", "测试分账");
        receivers.add(receiver);
        profitSharingMultiEntity.setReceivers(receivers);

        profitSharingApi.profitSharingMulti(profitSharingMultiEntity);

    }


    @Test
    public void profitSharingQuery() {

        ProfitSharingQueryEntity profitSharingQueryEntity = new ProfitSharingQueryEntity();
        profitSharingQueryEntity.setDeveloperKey("1234567890");
        profitSharingQueryEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        profitSharingQueryEntity.setTimestamp(timestamp.toString());

        profitSharingQueryEntity.setPayWay(PrecreateType.WEIXINPAY.getValue());
        profitSharingQueryEntity.setOutOrderNo("1000000000005");

        profitSharingApi.profitSharingQuery(profitSharingQueryEntity);

    }

    @Test
    public void profitSharingFinish() {

        ProfitSharingFinishEntity profitSharingFinishEntity = new ProfitSharingFinishEntity();
        profitSharingFinishEntity.setDeveloperKey("1234567890");
        profitSharingFinishEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        profitSharingFinishEntity.setTimestamp(timestamp.toString());
//        profitSharingFinishEntity.setPayChannel("WEIXINPAY");
        profitSharingFinishEntity.setPayWay(PrecreateType.WEIXINPAY.getValue());
        profitSharingFinishEntity.setOutOrderNo("4200000754202009176851729718");
        profitSharingFinishEntity.setOutTradeNo("PA20091700112");
        profitSharingFinishEntity.setDescription("完结测试");

        profitSharingApi.profitSharingFinish(profitSharingFinishEntity);

    }

    public class MyThread implements Runnable {

        Set<Long> set;

        public MyThread(Set<Long> set) {
            this.set = set;
        }

        public void run() {
//            for (int i = 0; i < 2; i++) {
//                set.add(System.currentTimeMillis() + getRandom(8));
//            }
//            System.out.println(set.size());

            orderquery();
        }
    }

    private Set<Long> set;

}
