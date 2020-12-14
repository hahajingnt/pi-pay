package com.jackrain.pay;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jackrain.pay.api.PiPayApi;
import com.jackrain.pay.api.ProfitSharingApi;
import com.jackrain.pay.pi.enums.PrecreateType;
import com.jackrain.pay.pi.model.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

/**
 * @Description :
 * @Reference :
 * @Author : zc
 * @CreateDate : 2019-09-02 15:10
 * @Modify:
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes=PayApplication.class)
@Slf4j
public class BaseTest {

    @Autowired
    PiPayApi piPayApi;

    @Autowired
    ProfitSharingApi profitSharingApi;

    @Test
    public void mircopay(){

        MircoPayEntity mircoPayEntity = new MircoPayEntity();
//        mircoPayEntity.setDeveloperId("82");
//        mircoPayEntity.setDeveloperId("001");
        mircoPayEntity.setDeveloperKey("5e24d575ce275dd34b549ba80337053e");
//        mircoPayEntity.setDeveloperKey("d3c44e6267274f96b955b4786407402a");
//        mircoPayEntity.setDeveloperKey("1234567890");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        log.info(timestamp.toString());
        mircoPayEntity.setTimestamp(timestamp.toString());
        mircoPayEntity.setAuthCode("283020010745309756");
        mircoPayEntity.setBody("测试店");
        mircoPayEntity.setOutTradeNo("134000000001492");
        mircoPayEntity.setTotalAmount(2);
        mircoPayEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
//        mircoPayEntity.setCustomerId("66DE4DBB86DDD8AA1D6C8A882765B678");
        mircoPayEntity.setStoreCode("001");
//        mircoPayEntity.setPayChannel("HOTLINPAY");
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
        good3.put("quantity","1");
        good3.put("goods_name","测试（250*450+70）");
        good3.put("goods_id","QT0000086");
        good3.put("price","2");
        goods.add(good3);
        mircoPayEntity.setGoodsDetail(goods);
//        //
//        JSONObject extendParams = new JSONObject();
//        extendParams.put("hb_fq_num","3");
//        extendParams.put("hb_fq_seller_percent","0");
//        mircoPayEntity.setExtendParams(extendParams);

        MircoPayResponseEntity piPayResponseEntity = piPayApi.mircopay(mircoPayEntity);
        System.out.println(piPayResponseEntity.toJSONString());

    }

    @Test
    public void orderquery(){

        OrderQueryEntity orderQueryEntity = new OrderQueryEntity();
//        orderQueryEntity.setDeveloperId("82");
//        orderQueryEntity.setDeveloperId("001");
        orderQueryEntity.setDeveloperKey("5e24d575ce275dd34b549ba80337053e");
//        orderQueryEntity.setDeveloperKey("1234567890");
//        orderQueryEntity.setDeveloperKey("7b0fe61020cf41f38251308db8e763e3");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        log.info(timestamp.toString());
        orderQueryEntity.setTimestamp(timestamp.toString());
//        orderQueryEntity.setTradeNo("2020083022001400091446623778");
        orderQueryEntity.setOutTradeNo("13400000000149");
        orderQueryEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
//        orderQueryEntity.setCustomerId("8C5949A2E0B5F0A428E6687C9D413217");
//        orderQueryEntity.setStoreCode("001");
//        orderQueryEntity.setPayChannel("CHINAUMS_YDQRCODEPAY");
//        orderQueryEntity.setPayChannel("ZHONGMAPAY");
//        orderQueryEntity.setPayChannel("ICBCPAY");
        piPayApi.orderquery(orderQueryEntity);

    }

    @Test
    public void refund(){

        RefundEntity refundEntity = new RefundEntity();
//        refundEntity.setDeveloperId("82");
//        refundEntity.setDeveloperId("001");
//        refundEntity.setDeveloperKey("1234567890");
        refundEntity.setDeveloperKey("d3c44e6267274f96b955b4786407402a");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        refundEntity.setTimestamp(timestamp.toString());
        refundEntity.setOutTradeNo("13400000000148");
//        refundEntity.setTradeNo("2020082722001486341455610098");
        refundEntity.setOutRefundNo("13400000000148R");
//        refundEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
        refundEntity.setCustomerId("66DE4DBB86DDD8AA1D6C8A882765B678");
//        refundEntity.setStoreCode("001");
        refundEntity.setRefundAmount(1);
        refundEntity.setTotalAmount(2);
        refundEntity.setPayChannel("HOTLINPAY");
        piPayApi.refund(refundEntity);

    }

    @Test
    public void refundquery(){

        RefundQueryEntity refundQueryEntity = new RefundQueryEntity();
//        refundQueryEntity.setDeveloperId("001");
//        refundQueryEntity.setDeveloperKey("1234567890");
//        refundQueryEntity.setDeveloperId("82");
        refundQueryEntity.setDeveloperKey("d3c44e6267274f96b955b4786407402a");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        log.info(timestamp.toString());
        refundQueryEntity.setTimestamp(timestamp.toString());
//        refundQueryEntity.setTradeNo("2020082722001486341455610098");
        refundQueryEntity.setOutTradeNo("13400000000148");
        refundQueryEntity.setOutRefundNo("13400000000148R");
//        refundQueryEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
        refundQueryEntity.setCustomerId("66DE4DBB86DDD8AA1D6C8A882765B678");
//        refundQueryEntity.setStoreCode("001");
        refundQueryEntity.setPayChannel("HOTLINPAY");
        piPayApi.refundquery(refundQueryEntity);

    }

    @Test
    public void precreate(){

        PrecreateEntity precreateEntity = new PrecreateEntity();
//        mircoPayEntity.setDeveloperId("82");
//        precreateEntity.setDeveloperId("001");
//        precreateEntity.setDeveloperKey("1234567890");
        precreateEntity.setDeveloperKey("5e24d575ce275dd34b549ba80337053e");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        log.info(timestamp.toString());
        precreateEntity.setTimestamp(timestamp.toString());
        precreateEntity.setPrecreateType(PrecreateType.ALIPAY.getValue());
        precreateEntity.setBody("秋涛北路东方布艺睿致店");
        precreateEntity.setOutTradeNo("1000050000103");
        precreateEntity.setTotalAmount(1);
        precreateEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
//        precreateEntity.setCustomerId("8C5949A2E0B5F0A428E6687C9D413217");
        precreateEntity.setStoreCode("80009940");
//        precreateEntity.setNotifyUrl("http://pay-apps-web-qa.pay2.piplus.cn/pipay/callback_success");
//        precreateEntity.setPayChannel("CHINAUMS_YDQRCODEPAY");
        piPayApi.precreate(precreateEntity);

    }

    @Test
    public void reverse(){

        ReverseEntity reverseEntity = new ReverseEntity();
//        reverseEntity.setDeveloperId("001");
        reverseEntity.setDeveloperKey("1234567890");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        log.info(timestamp.toString());
        reverseEntity.setTimestamp(timestamp.toString());
        reverseEntity.setOutTradeNo("1000050000106");
//        reverseEntity.setCustomerId("1905EDBC05E099876D0B044D40A9FD66");
        reverseEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
        reverseEntity.setStoreCode("商户数据包001");
//        reverseEntity.setPayChannel("ICBCPAY");
        piPayApi.reverse(reverseEntity);

    }

    @Test
    public void close(){

        CloseEntity closeEntity = new CloseEntity();
        closeEntity.setDeveloperId("001");
        closeEntity.setDeveloperKey("1234567890");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        log.info(timestamp.toString());
        closeEntity.setTimestamp(timestamp.toString());
        closeEntity.setOutTradeNo("1000050000096");
//        reverseEntity.setCustomerId("1905EDBC05E099876D0B044D40A9FD66");
        closeEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
        closeEntity.setStoreCode("商户数据包001");
        closeEntity.setPayChannel("CHINAUMS_YDQRCODEPAY");
        piPayApi.closePay(closeEntity);

    }

    @Test
    public void downloadBill(){
        //
        DownloadBillEntity downloadBillEntity = new DownloadBillEntity();
        downloadBillEntity.setDeveloperId("001");
        downloadBillEntity.setDeveloperKey("1234567890");
//        reverseEntity.setCustomerId("1905EDBC05E099876D0B044D40A9FD66");
        downloadBillEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        downloadBillEntity.setTimestamp(timestamp.toString());

        downloadBillEntity.setBillDate("20200603");
        downloadBillEntity.setBillType("ALL");
        downloadBillEntity.setInterfaceType("pay.bill.merchant");
        downloadBillEntity.setStoreCode("958300000003");
        downloadBillEntity.setPayChannel("");

        piPayApi.downloadBill(downloadBillEntity);

    }

    @Test
    public void downloadAlipayBill(){

        JSONObject param = new JSONObject();
        param.put("app_auth_token","201907BB235693a188674cf8a2d73b0076105D39");
        param.put("bill_date","2020-06");//月份
        param.put("bill_type","trade");
        JSONObject res = piPayApi.downloadAlipayBill(param);
        System.out.println(res.toJSONString());

    }


    @Test
    public void qrcodeUrl(){

        PrecreateEntity precreateEntity = new PrecreateEntity();
//        mircoPayEntity.setDeveloperId("82");
//        precreateEntity.setDeveloperId("001");
        precreateEntity.setDeveloperKey("1234567890");
//        precreateEntity.setDeveloperKey("7fd28ad27d0a46e7a3ed35f9121482c1");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        log.info(timestamp.toString());
//        precreateEntity.setTimestamp(timestamp.toString());
        precreateEntity.setBody("上海圆周率科技有限公司");
//        precreateEntity.setOutTradeNo("1100050000164");
//        precreateEntity.setTotalAmount(2);
        precreateEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
//        precreateEntity.setStoreCode("80009940");
        precreateEntity.setStaticQrcode("Y");

        JSONObject ret = piPayApi.qrcodeUrl(precreateEntity);
        System.out.println(ret.toJSONString());

    }

    @Test
    public void receiverAdd(){

        PsReceiverAddEntity psReceiverAddEntity = new PsReceiverAddEntity();
        psReceiverAddEntity.setDeveloperKey("1234567890");
        psReceiverAddEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        psReceiverAddEntity.setTimestamp(timestamp.toString());

        psReceiverAddEntity.setPayWay(PrecreateType.WEIXINPAY.getValue());
        JSONObject receiver = new JSONObject();
        receiver.put("type","PERSONAL_OPENID");
        receiver.put("account","oV7yY1XHkhhhV3ZJPJnvjEFhWcrM");
//        receiver.put("name","周城");
        receiver.put("relation_type","STAFF");
        psReceiverAddEntity.setReceiver(receiver);

        profitSharingApi.receiverAdd(psReceiverAddEntity);

    }

    @Test
    public void profitSharingMulti(){

        ProfitSharingMultiEntity profitSharingMultiEntity = new ProfitSharingMultiEntity();
        profitSharingMultiEntity.setDeveloperKey("1234567890");
        profitSharingMultiEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        profitSharingMultiEntity.setTimestamp(timestamp.toString());

        profitSharingMultiEntity.setPayWay(PrecreateType.WEIXINPAY.getValue());
        profitSharingMultiEntity.setOutOrderNo("1000000000005");
        profitSharingMultiEntity.setOutTradeNo("134505675022966632");
        JSONArray receivers = new JSONArray();
        JSONObject receiver = new JSONObject();
        receiver.put("type","PERSONAL_OPENID");
        receiver.put("account","oV7yY1XHkhhhV3ZJPJnvjEFhWcrM");
        receiver.put("amount",1);
        receiver.put("description","测试分账");
        receivers.add(receiver);
        profitSharingMultiEntity.setReceivers(receivers);

        profitSharingApi.profitSharingMulti(profitSharingMultiEntity);

    }


    @Test
    public void profitSharingQuery(){

        ProfitSharingQueryEntity profitSharingQueryEntity = new ProfitSharingQueryEntity();
        profitSharingQueryEntity.setDeveloperKey("1234567890");
        profitSharingQueryEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        profitSharingQueryEntity.setTimestamp(timestamp.toString());

        profitSharingQueryEntity.setPayWay(PrecreateType.WEIXINPAY.getValue());
        profitSharingQueryEntity.setOutOrderNo("1000000000005");

        profitSharingApi.profitSharingQuery(profitSharingQueryEntity);

    }



    public class MyThread implements Runnable {

        Set<Long> set;

        public MyThread(Set<Long> set){
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

    @Test
    public void test(){

        set = new LinkedHashSet<>();

        for (int i = 0; i < 20; i++) {
            MyThread t = new MyThread(set);
            t.run();
        }

    }

    private static long getRandom(long n) {
        long min = 1, max = 9;
        for (int i = 1; i < n; i++) {
            min *= 10;
            max *= 10;
        }
        long rangeLong = (((long) (new Random().nextDouble() * (max - min)))) + min;
        return rangeLong;
    }

}
