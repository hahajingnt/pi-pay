package com.jackrain.pay;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jackrain.pay.api.PiPayApi;
import com.jackrain.pay.api.PiPosPayApi;
import com.jackrain.pay.pi.enums.PrecreateType;
import com.jackrain.pay.pi.model.*;
import com.jackrain.pay.pi.model.pospay.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.Timestamp;
import java.util.*;

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

        PosPreOrderEntity mircoPayEntity = new PosPreOrderEntity();
//        mircoPayEntity.setDeveloperId("82");
//        mircoPayEntity.setDeveloperId("001");
//        mircoPayEntity.setDeveloperKey("5e24d575ce275dd34b549ba80337053e");
        mircoPayEntity.setDeveloperKey("1234567890");
//        mircoPayEntity.setDeveloperKey("438d66903cf002573c3c0d02f4daa0a9");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        log.info(timestamp.toString());
        mircoPayEntity.setTimestamp(timestamp.toString());
        mircoPayEntity.setSubject("测试店");
        mircoPayEntity.setOutTradeNo(String.valueOf(System.currentTimeMillis()));
        mircoPayEntity.setTotalAmount(1);
        mircoPayEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
        mircoPayEntity.setStoreCode("JNBY");
        mircoPayEntity.setPayChannel("shouqianba");
//        mircoPayEntity.setDeviceInfo("webPos");
//        mircoPayEntity.setVipNo("-1");
//        mircoPayEntity.setPayment("1");
//        mircoPayEntity.setOperatorId("3429");
//        mircoPayEntity.setPayWay("ALIPAY");
//        JSONArray goods = new JSONArray();
//        // [{"quantity": "1", "goods_name": "看海", "goods_id": "100020", "price": "36800"}]
//        JSONObject good = new JSONObject();
//        good.put("quantity","1");
//        good.put("goods_name","塑料袋（250*450+70）");
//        good.put("goods_id","PJXYA0006");
//        good.put("price","5");
//        goods.add(good);
//        JSONObject good2 = new JSONObject();
//        good2.put("quantity","3");
//        good2.put("goods_name","喜力啤酒500ml瓶装");
//        good2.put("goods_id","PJXYA0006");
//        good2.put("price","5.7");
//        goods.add(good2);
//        JSONObject good3 = new JSONObject();
//        good3.put("quantity","1");
//        good3.put("goods_name","塑料袋（250*450+70）");
//        good3.put("goods_id","QT0000086");
//        good3.put("price","0.2");
//        goods.add(good3);

//        List<PosGoodsDetailEntity> goodsDetail = new LinkedList<>();
//        PosGoodsDetailEntity posGoodsDetailEntity = new PosGoodsDetailEntity();
//        posGoodsDetailEntity.setGoodsId("PJXYA0006");
//        posGoodsDetailEntity.setGoodsName("塑料袋（250*450+70）");
//        posGoodsDetailEntity.setPrice("5");
//        posGoodsDetailEntity.setQuantity("1");
//        goodsDetail.add(posGoodsDetailEntity);
//        mircoPayEntity.setGoodsDetail(goodsDetail);

        PosPreOrderResponseEntity piPayResponseEntity = piPosPayApi.preorder(mircoPayEntity);
        System.out.println(piPayResponseEntity.toJSONString());

    }

    @Test
    public void orderquery() {

        PosOrderQueryEntity orderQueryEntity = new PosOrderQueryEntity();
//        orderQueryEntity.setDeveloperId("82");
//        orderQueryEntity.setDeveloperId("001");
//        orderQueryEntity.setDeveloperKey("5e24d575ce275dd34b549ba80337053e");
        orderQueryEntity.setDeveloperKey("1234567890");
//        orderQueryEntity.setDeveloperKey("438d66903cf002573c3c0d02f4daa0a9");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        log.info(timestamp.toString());
        orderQueryEntity.setTimestamp(timestamp.toString());
//        orderQueryEntity.setTradeNo("2019112722001412545718971268");
        orderQueryEntity.setOutTradeNo("1600680927905");
        orderQueryEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
        orderQueryEntity.setStoreCode("JNBY");
        orderQueryEntity.setPayChannel("shouqianba");
//        orderQueryEntity.setPayChannel("CHINAUMS_ydPAY");
        piPosPayApi.orderquery(orderQueryEntity);

    }

    @Test
    public void refund() {

        PosRefundEntity refundEntity = new PosRefundEntity();
//        refundEntity.setDeveloperId("82");
//        refundEntity.setDeveloperId("001");
        refundEntity.setDeveloperKey("1234567890");
//        refundEntity.setDeveloperKey("438d66903cf002573c3c0d02f4daa0a9");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        refundEntity.setTimestamp(timestamp.toString());
        refundEntity.setOutTradeNo("1597805739512");
//        refundEntity.setTradeNo("20200403144757000031022321");
        refundEntity.setOutRefundNo("24573985743553455345");
        refundEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
        refundEntity.setStoreCode("JNBY");
        refundEntity.setRefundAmount(29);
        refundEntity.setPayChannel("shande_hmpay");
//        refundEntity.setPayChannel("CHINAUMS_ydPAY");
        piPosPayApi.refund(refundEntity);

    }

    @Test
    public void refundquery() {

        PosRefundQueryEntity refundQueryEntity = new PosRefundQueryEntity();
//        refundQueryEntity.setDeveloperId("001");
        refundQueryEntity.setDeveloperKey("1234567890");
//        refundQueryEntity.setDeveloperId("82");
//        refundQueryEntity.setDeveloperKey("5e24d575ce275dd34b549ba80337053e");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        log.info(timestamp.toString());
        refundQueryEntity.setTimestamp(timestamp.toString());
//        refundQueryEntity.setTradeNo("");
//        refundQueryEntity.setOutTradeNo("1000040000094");
        refundQueryEntity.setOutRefundNo("1000300200063");
//        refundQueryEntity.setCustomerId("48B040170305CDD10CDA6A02B701415A");
        refundQueryEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
//        refundQueryEntity.setStoreCode("001");
        refundQueryEntity.setStoreCode("JNBY");
        refundQueryEntity.setPayChannel("shouQianba");
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
        reverseEntity.setOutTradeNo("1597805722531");
        reverseEntity.setOutReverseNo("234234534534534");
//        reverseEntity.setTradeNo("200514999888000017");
//        reverseEntity.setCustomerId("1905EDBC05E099876D0B044D40A9FD66");
        reverseEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
        reverseEntity.setStoreCode("JNBY");
        reverseEntity.setPayChannel("shande_hmpay");
        piPosPayApi.reverse(reverseEntity);

    }


    public static String getImgeHexStringByLocalUrl(String imageUrl) {
        String res = null;

        try {
            File imageFile = new File(imageUrl);
            System.out.println(imageFile);
            InputStream inStream = new FileInputStream(imageFile);
            BufferedInputStream bis = new BufferedInputStream(inStream);
            BufferedImage bm = ImageIO.read(bis);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            String type = imageUrl.substring(imageUrl.length() - 3);
            ImageIO.write(bm, type, bos);
            bos.flush();
            byte[] data = bos.toByteArray();
            System.out.println(data);
            res = byte2hex(data);
            bos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public static String byte2hex(byte[] b) {
        char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] out = new char[b.length * 2];
        for (int i = 0; i < b.length; i++) {
            byte c = b[i];
            out[i * 2] = Digit[(c >>> 4) & 0X0F];
            out[i * 2 + 1] = Digit[c & 0X0F];
        }

        return new String(out);
    }



}
