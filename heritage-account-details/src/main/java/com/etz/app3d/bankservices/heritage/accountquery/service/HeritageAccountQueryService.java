package com.etz.app3d.bankservices.heritage.accountquery.service;

import com.etz.app3d.bankservices.heritage.accountquery.domain.HeritageResponse;
import com.etz.app3d.bankservices.heritage.accountquery.util.RequestResponseHandler;
import com.etz.app3d.bankservices.heritage.accountquery.ws.ETranzAuthMethd;
import com.etz.app3d.bankservices.heritage.accountquery.ws.ETranzAuthMethdSoap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import javax.xml.ws.Binding;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;
import java.util.List;
import java.util.Map;


@Slf4j
@Service
public class HeritageAccountQueryService {
    private static ETranzAuthMethd service = null;
    private static ETranzAuthMethdSoap soapService = null;

    @Value("${app3d.service.accountquery.heritage-accountquery.url}")
    private String accountQueryWSUrl;
    @Value("${app3d.service.accountquery.timeout}")
    private int connectionTimeOutInMs;

    public String getCustomerInfo(String accountNo) {
        return soapService.fetchAccountDetail(accountNo);
    }

    @Async
    public void setup() {
        log.info("Setup started");
        service = new ETranzAuthMethd();
        soapService = service.getETranzAuthMethdSoap();

        BindingProvider bp = (BindingProvider) soapService;
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, accountQueryWSUrl);
        Binding binding = bp.getBinding();
        List<Handler> handlerChain = binding.getHandlerChain();
        handlerChain.add(new RequestResponseHandler());
        binding.setHandlerChain(handlerChain);

        Map<String, Object> context = bp.getRequestContext();
        //Set timeout params
        context.put("com.sun.xml.internal.ws.connect.timeout", connectionTimeOutInMs);
        context.put("com.sun.xml.internal.ws.request.timeout", connectionTimeOutInMs);
        context.put("com.sun.xml.ws.request.timeout", connectionTimeOutInMs);
        context.put("com.sun.xml.ws.connect.timeout", connectionTimeOutInMs);
        log.info("Setup finished");
    }
}
