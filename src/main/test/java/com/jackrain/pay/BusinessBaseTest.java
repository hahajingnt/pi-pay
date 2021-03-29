package com.jackrain.pay;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jackrain.pay.api.PiPayApi;
import com.jackrain.pay.api.PiPayBusinessApi;
import com.jackrain.pay.api.ProfitSharingApi;
import com.jackrain.pay.pi.enums.PrecreateType;
import com.jackrain.pay.pi.model.*;
import com.jackrain.pay.pi.model.business.PageQueryEntity;
import com.jackrain.pay.pi.model.business.PageQueryResponseEntity;
import com.jackrain.pay.pi.model.business.RefundPageQueryEntity;
import com.jackrain.pay.pi.model.business.RefundPageQueryResponseEntity;
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
@SpringBootTest(classes = PayApplication.class)
@Slf4j
public class BusinessBaseTest {

    @Autowired
    PiPayBusinessApi piPayBusinessApi;


    @Test
    public void pageQuery() {
        PageQueryEntity pageQueryEntity = new PageQueryEntity();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        pageQueryEntity.setTimestamp(timestamp.toString());

        pageQueryEntity.setDeveloperKey("1234567890");
        pageQueryEntity.setCurrentPage(1L);
        pageQueryEntity.setPageSize(50L);
        pageQueryEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
        pageQueryEntity.setCreateDateMin("2021-03-08 15:56:43");
        pageQueryEntity.setCreateDateMax("2021-03-08 15:59:00");
        PageQueryResponseEntity jsonObject = piPayBusinessApi.pageQuery(pageQueryEntity);
        System.out.println(jsonObject);
    }

    @Test
    public void refundPageQuery() {
        RefundPageQueryEntity refundPageQueryEntity = new RefundPageQueryEntity();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        refundPageQueryEntity.setTimestamp(timestamp.toString());

        refundPageQueryEntity.setDeveloperKey("1234567890");
        refundPageQueryEntity.setCurrentPage(1L);
        refundPageQueryEntity.setPageSize(50L);
        refundPageQueryEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
        refundPageQueryEntity.setCreateDateMin("2021-03-08 15:56:43");
//        refundPageQueryEntity.setCreateDateMax("2021-03-08 15:59:00");
        RefundPageQueryResponseEntity jsonObject = piPayBusinessApi.refundPageQuery(refundPageQueryEntity);
        System.out.println(jsonObject);
    }


}
