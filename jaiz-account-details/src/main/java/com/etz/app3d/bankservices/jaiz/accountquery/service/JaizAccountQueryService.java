package com.etz.app3d.bankservices.jaiz.accountquery.service;

import com.etz.app3d.bankservices.jaiz.accountquery.domain.JaizResponse;
import com.etz.app3d.bankservices.jaiz.accountquery.interceptor.RequestResponseLoggingInterceptor;
import com.etz.app3d.bankservices.jaiz.accountquery.util.HttpUtil;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import static jdk.nashorn.internal.objects.NativeMath.log;
import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;


import sun.rmi.runtime.Log;
import static sun.util.logging.LoggingSupport.log;

@Slf4j
@Service
public class JaizAccountQueryService {

    @Value("${app3d.service.accountquery.jaiz-accountquery.url}")
    private String jaizAccountQueryWSUrl;
    @Value("${app3d.service.accountquery.timeout}")
    private int connectionTimeOutInMs;

    public JaizResponse getCustomerInfo(String accountNo) {
        String requestUrl = jaizAccountQueryWSUrl + accountNo;

        ClientHttpRequestFactory factory = new BufferingClientHttpRequestFactory(getClientHttpRequestFactory(connectionTimeOutInMs));
        RestTemplate restTemplate = new RestTemplate(factory);
        restTemplate.setInterceptors(Collections.singletonList(new RequestResponseLoggingInterceptor()));
        //ResponseEntity<String> response = restTemplate.getForEntity(requestUrl, String.class);
        try {
            return restTemplate.getForObject(requestUrl, JaizResponse.class);
        }catch (HttpClientErrorException e){
            if(e.getStatusCode() == HttpStatus.BAD_REQUEST){
//                Log.info("HttpClientErrorException: {}", e.getResponseBodyAsString());
                return null;
            }
        } catch (RestClientException e){
//            log.info("RestClientException Exception: {}", e);

        }
        return null;
    }

    public String getCustomerInfo2(String accountNo) {
        String requestUrl = jaizAccountQueryWSUrl + accountNo;
        try {
            return new HttpUtil().doGet(requestUrl, connectionTimeOutInMs);
        } catch (Exception e) {
            return "Invalid";
        }
    }

    private ClientHttpRequestFactory getClientHttpRequestFactory(int timeout) {
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(timeout)
                .setConnectionRequestTimeout(timeout)
                .setSocketTimeout(timeout)
                .build();
        CloseableHttpClient client = HttpClientBuilder
                .create()
                .setDefaultRequestConfig(config)
                .build();
        return new HttpComponentsClientHttpRequestFactory(client);
    }

    public static void main(String args[]) throws Exception

    {

        //Calling customer validation url
        JaizAccountQueryService ser =new JaizAccountQueryService();
        ser.getCustomerInfo("246835360401");


        //calling the payment url
       }



}
