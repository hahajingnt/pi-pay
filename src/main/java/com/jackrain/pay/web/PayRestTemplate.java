package com.jackrain.pay.web;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author: z.c
 * @since: 2019/3/19
 * create at : 2019/3/19 1:58 PM
 */
public class PayRestTemplate extends RestTemplate{

    public PayRestTemplate(ClientHttpRequestFactory requestFactory) {
       super(requestFactory);
    }
    
    public<T> T getForRequestParam(String url, HashMap<String,String> param, Class<T> tClass){
        HttpHeaders headers = new HttpHeaders();
        List list = new ArrayList();
        list.add(MediaType.APPLICATION_FORM_URLENCODED_VALUE.toString());
        headers.put(HttpHeaders.CONTENT_TYPE, list);
        StringBuffer buffer = new StringBuffer();
        if(param.size() > 0){
            buffer.append("?");
            param.forEach((k,v)->{buffer.append(k).append("=").append("{").append(k).append("}").append("&");});
            url = url + buffer.substring(0,buffer.length()-1);

        }
        T val = this.exchange(url, HttpMethod.GET, new HttpEntity(headers),tClass,param).getBody();
        return val;
    }

    public<T> T getForRequestParam(String url, MultiValueMap<String, String> param, ParameterizedTypeReference<T> responseType){
        HttpHeaders headers = new HttpHeaders();
        List list = new ArrayList();
        list.add(MediaType.APPLICATION_FORM_URLENCODED_VALUE.toString());
        headers.put(HttpHeaders.CONTENT_TYPE, list);
        T val = this.exchange(url, HttpMethod.GET, new HttpEntity(param, headers), responseType).getBody();
        return val;
    }

    public <T> T postForRequestParam(String url, MultiValueMap<String,String> param, Class<T> tClass){
        HttpHeaders headers = new HttpHeaders();
        List list = new ArrayList();
        list.add(MediaType.APPLICATION_FORM_URLENCODED_VALUE.toString());
        headers.put(HttpHeaders.CONTENT_TYPE, list);
        T val = this.postForObject(url,new HttpEntity(param,headers),tClass);
        return val;
    }

    public <T> T postForRequestParam(String url, MultiValueMap<String, String> param, ParameterizedTypeReference<T> responseType) {
        HttpHeaders headers = new HttpHeaders();
        List list = new ArrayList();
        list.add(MediaType.APPLICATION_FORM_URLENCODED_VALUE.toString());
        headers.put(HttpHeaders.CONTENT_TYPE, list);
        T val = this.exchange(url, HttpMethod.POST, new HttpEntity(param, headers), responseType).getBody();
        return val;
    }

    public <T> T postForRequestBody(String url, Object body, Class<T> tClass){
        T val = this.postForObject(url,body,tClass);
        return val;
    }

    public <T> T postForRequestBody(String url, Object body, ParameterizedTypeReference<T> responseType) {
        HttpHeaders headers = new HttpHeaders();
        List list = new ArrayList();
        list.add(MediaType.APPLICATION_JSON_UTF8.toString());
        headers.put(HttpHeaders.CONTENT_TYPE, list);
        T val = this.exchange(url, HttpMethod.POST, new HttpEntity(body, headers), responseType).getBody();
        return val;
    }



}
