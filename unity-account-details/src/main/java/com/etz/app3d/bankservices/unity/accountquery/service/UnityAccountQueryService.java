package com.etz.app3d.bankservices.unity.accountquery.service;

import com.etz.app3d.bankservices.unity.accountquery.util.RequestResponseHandler;
import com.etz.app3d.bankservices.unity.accountquery.ws.API;
import com.etz.app3d.bankservices.unity.accountquery.ws.APISoap;
import com.etz.app3d.bankservices.unity.accountquery.ws.AccountDetail;
import com.etz.app3d.bankservices.unity.accountquery.ws.ArrayOfAccountDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import javax.xml.ws.Binding;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;
import java.util.List;
import java.util.Map;


@Slf4j
@org.springframework.stereotype.Service
public class UnityAccountQueryService {
    private static API service = null;
    private static APISoap soapService = null;

    @Value("${app3d.service.accountquery.unity-accountquery.url}")
    private String unityAccountQueryWSUrl;
    @Value("${app3d.service.accountquery.timeout}")
    private int connectionTimeOutInMs;

    public AccountDetail getCustomerInfo(String accountNo) {
        AccountDetail accountDetail = null;
        try {
            ArrayOfAccountDetail arrayOfAccountDetail = soapService.fetchAccountDetail(accountNo);
            accountDetail = arrayOfAccountDetail.getAccountDetail().get(0);
        } catch (Exception e) {
            log.error("Error Fetching Account Details", e);
        }
        return accountDetail;
    }

    @Async
    public void setup() {
        log.info("Setup started");
        service = new API();
        soapService = service.getAPISoap();

        BindingProvider bp = (BindingProvider) soapService;
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, unityAccountQueryWSUrl);
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
