package com.etz.app3d.bankservices.tcf.accountquery.service;

import com.etz.app3d.bankservices.tcf.accountquery.util.ServiceUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.Random;

@Slf4j
@Service
public class TCFAccountQueryService {

    @Value("${app3d.service.accountquery.tcf-accountquery.url}")
    private String accountQueryWSUrl;
    @Value("${app3d.service.accountquery.timeout}")
    private int connectionTimeOutInMs;
    @Value("${app3d.service.accountquery.tcf-accountquery.bankcode}")
    private String bankCode;

    public String getCustomerInfo(String accountNo) {
        return new ServiceUtil().getBalance(accountQueryWSUrl, connectionTimeOutInMs, accountNo, bankCode,
                generateRandomNumber(25));
    }

//    public boolean checkPhoneAndAccountMatch(String accountNo, String phoneNumber) {
//        return new ServiceUtil().getBalance(accountQueryWSUrl, connectionTimeOutInMs, accountNo, bankCode,
//                generateRandomNumber(25));
//
//
////                else
////                {
////                    if (!phoneNumber.startsWith("234")) {
////                        phoneNumber = "234" + phoneNumber.substring(1);
////                    }
////                    System.out.println("phoneNumberxx " + phoneNumber);
////                    System.out.println("phoneNumber2 " + request.optString("phoneno"));
////                    String resPhone = request.optString("phoneno");
////                    if (!resPhone.startsWith("234")) {
////                        resPhone = "234" + resPhone.substring(1);
////                    }
////                    if (phoneNumber.equals(resPhone))
////                    {
////                        response.setAccountNumber(accountNumber);
////                        response.setResponseCode("0");
////                        response.setOtherInfo(request.optString("name"));
////                    }
////                    else
////                    {
////                        response.setAccountNumber(accountNumber);
////                        response.setResponseCode("1");
////                        response.setOtherInfo("NOT_MATCHED:");
////                    }
////                }
////                break;
////            default:
////                response.setAccountNumber(accountNumber);
////                response.setResponseCode("-1");
////                response.setOtherInfo("INVALID:");
////        }
////        return response;
////        return null;
//    }


    public String generateRandomNumber(int size) {
        String value = "";
        for (int t = 0; t < size; t++) {
            value = value + new Random().nextInt(9);
        }
        return value;
    }
}
