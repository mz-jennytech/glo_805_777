package com.etz.app3d.bankservices.jaiz.accountquery.domain;

import lombok.Data;

@Data
public class JaizResponse {
    private String Phone1;
    private String Phone2;
    private String accountNumber;
    private String name;
    private double balance;
    private String branch;
    private String currency;
    private String customerId;
    private String ownership;
    private String title;
    private int status;
    private String schemeCode;
    private String schemeType;
}
