package com.etz.app3d.bankservices.skye.accountquery.service;

import com.etz.app3d.bankservices.skye.accountquery.util.RequestResponseHandler;
import com.etz.app3d.bankservices.skye.accountquery.ws.SkyeWebService;
import com.etz.app3d.bankservices.skye.accountquery.ws.SkyeWebServiceSoap;
import lombok.extern.slf4j.Slf4j;
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
public class SkyeAccountQueryService {
    private static SkyeWebService service = null;
    private static SkyeWebServiceSoap soapService = null;

    @Value("${app3d.service.accountquery.skye-accountquery.url}")
    private String skyeAccountQueryWSUrl;
    @Value("${app3d.service.accountquery.timeout}")
    private int connectionTimeOutInMs;

//    @PostConstruct
//    public void init() {
//        log.info("********************** START ME UP *********************");
//    }

    public String getCustomerInfo(String accountNo) {
        return soapService.etzAcctRequest(accountNo);
    }

    @Async
    public void setup() {
        log.info("Setup started");
        service = new SkyeWebService();
        soapService = service.getSkyeWebServiceSoap();

        BindingProvider bp = (BindingProvider) soapService;
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, skyeAccountQueryWSUrl);
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
