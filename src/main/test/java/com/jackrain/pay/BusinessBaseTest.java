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
        pageQueryEntity.setCurrentPage(500L);
        pageQueryEntity.setPageSize(20L);
        pageQueryEntity.setCustomerId("C791722B9724DCF8E614B2B10B9A2913");
        PageQueryResponseEntity jsonObject = piPayBusinessApi.pageQuery(pageQueryEntity);
        System.out.println(jsonObject);
    }


}
