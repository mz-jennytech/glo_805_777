package com.etz.app3d.bankservices.fcmb.accountquery.service;

import com.etz.app3d.bankservices.fcmb.accountquery.util.RequestResponseHandler;
import com.etz.app3d.bankservices.fcmb.accountquery.ws.Service;
import com.etz.app3d.bankservices.fcmb.accountquery.ws.ServiceSoap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;

import javax.annotation.PostConstruct;
import javax.xml.ws.Binding;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;
import java.util.List;
import java.util.Map;


@Slf4j
@org.springframework.stereotype.Service
public class FCMBAccountQueryService {
    private static Service service = null;
    private static ServiceSoap soapService = null;
    @Value("${app3d.service.accountquery.fcmb-accountquery.username}")
    private String serviceUsername;
    @Value("${app3d.service.accountquery.fcmb-accountquery.password}")
    private String servicePassword;

    @Value("${app3d.service.accountquery.fcmb-accountquery.url}")
    private String fcmbAccountQueryWSUrl;
    @Value("${app3d.service.accountquery.timeout}")
    private int connectionTimeOutInMs;

//    @PostConstruct
//    public void init() {
//        log.info("********************** START ME UP *********************");
//    }

    public String getAccountBalance(String accountNo) {
        return soapService.accountbalance(accountNo, serviceUsername, servicePassword);
    }
    public String getCustomerInfo(String accountNo) {
        return soapService.customerinfo(accountNo);
    }

    @Async
    public void setup() {
        log.info("Setup started");
        service = new Service();
        soapService = service.getServiceSoap();

        BindingProvider bp = (BindingProvider) soapService;
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, fcmbAccountQueryWSUrl);
        Binding binding = bp.getBinding();
        List<Handler> handlerChain = binding.getHandlerChain();
        handlerChain.add(new RequestResponseHandler());
        binding.setHandlerChain(handlerChain);

        //int connectionTimeOutInMs = timeout * 1000;
        Map<String, Object> context = bp.getRequestContext();
        //Set timeout params
        context.put("com.sun.xml.internal.ws.connect.timeout", connectionTimeOutInMs);
        context.put("com.sun.xml.internal.ws.request.timeout", connectionTimeOutInMs);
        context.put("com.sun.xml.ws.request.timeout", connectionTimeOutInMs);
        context.put("com.sun.xml.ws.connect.timeout", connectionTimeOutInMs);
        log.info("Setup finished");
    }
}
