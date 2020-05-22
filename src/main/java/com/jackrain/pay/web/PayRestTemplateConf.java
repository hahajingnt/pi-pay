package com.jackrain.pay.web;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zhoucheng
 * @date 17/10/27
 */
@Configuration
public class PayRestTemplateConf {

    private static PayRestTemplate payRestTemplate;


    @Bean("payRestTemplate")
    public PayRestTemplate restTemplate(SimpleClientHttpRequestFactory factory){
        PayRestTemplate restTemplate = new PayRestTemplate(factory);

        return restTemplate;
    }

    @Bean
    public SimpleClientHttpRequestFactory simpleClientHttpRequestFactory(){
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(60000);//ms
        factory.setConnectTimeout(15000);//ms
        return factory;
    }


    public static PayRestTemplate getInstance(){

        if (payRestTemplate != null){
            return payRestTemplate;
        }

        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(60000);//ms
        factory.setConnectTimeout(15000);//ms
        payRestTemplate = new PayRestTemplate(factory);


        return payRestTemplate;

    }

}