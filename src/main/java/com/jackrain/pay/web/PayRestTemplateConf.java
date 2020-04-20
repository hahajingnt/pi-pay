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

        List<HttpMessageConverter<?>> httpMessageConverterList= restTemplate.getMessageConverters();
        //创建FastJson信息转换对象
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        //创建Fastjosn对象并设定序列化规则
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.PrettyFormat,
                SerializerFeature.WriteMapNullValue);
        // 中文乱码解决方案
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);//设定json格式且编码为UTF-8
        mediaTypes.add(MediaType.TEXT_HTML);//设定json格式且编码为UTF-8

        fastJsonHttpMessageConverter.setSupportedMediaTypes(mediaTypes);
        //规则赋予转换对象
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        httpMessageConverterList.add(0,fastJsonHttpMessageConverter);
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

        List<HttpMessageConverter<?>> httpMessageConverterList= payRestTemplate.getMessageConverters();
        //创建FastJson信息转换对象
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        //创建Fastjosn对象并设定序列化规则
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.PrettyFormat,
                SerializerFeature.WriteMapNullValue);
        // 中文乱码解决方案
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);//设定json格式且编码为UTF-8
        mediaTypes.add(MediaType.TEXT_HTML);//设定json格式且编码为UTF-8

        fastJsonHttpMessageConverter.setSupportedMediaTypes(mediaTypes);
        //规则赋予转换对象
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        httpMessageConverterList.add(0,fastJsonHttpMessageConverter);
        return payRestTemplate;

    }

}