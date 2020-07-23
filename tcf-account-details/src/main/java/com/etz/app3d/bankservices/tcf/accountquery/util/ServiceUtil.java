package com.etz.app3d.bankservices.tcf.accountquery.util;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.NumberFormat;
import java.util.Locale;

public class ServiceUtil {
    private String getMiniStatement(String baseurl, int timeout, String accountNo, String bankCode) {
        try {
            String url = baseurl + "/Account/MiniStatement";
            JSONObject request = new JSONObject();
            request.put("AccountNo", accountNo);
            request.put("AuthenticationCode", bankCode);
            String res = new HttpUtil().callWS(timeout, url, request.toString());
            res = "{\"rec\":" + res + "}";
            JSONArray notesJSON = new JSONObject(res).optJSONArray("rec");
            for (int u = 0; u < notesJSON.length(); u++) {
                JSONObject rec = notesJSON.getJSONObject(u);
                System.out.println(rec);
                System.out.println(rec.optString("Narration"));
            }
            return "";
        } catch (Exception xc) {
            xc.printStackTrace();
        }
        return "";
    }

    public String getDebit(String baseurl, int timeout, String debitAccount, String paymentReference, String bankCode, String amount, String fee) {
        try {
            String url = baseurl + "/Transactions/Debit/";
            JSONObject request = new JSONObject();
            try {
                amount = Double.parseDouble(amount) / 100.0D + "";
            } catch (Exception localException1) {
            }
            request.put("NibssCode", bankCode);
            request.put("AccountNumber", debitAccount);
            request.put("PaymentReference", paymentReference);
            request.put("Amount", amount);
            request.put("Fee", fee);
            request.put("Channel", 1);
            request.put("TransactionType", 1);


            String res = new HttpUtil().callWS(timeout, url, request.toString());
            JSONObject response = new JSONObject(res);
            JSONObject returnRes = new JSONObject();

            returnRes.put("phoneno", "");
            returnRes.put("txnFee", fee);
            returnRes.put("retrievalRef", paymentReference);
            returnRes.put("responseCode", response.opt("ResponseCode"));
            returnRes.put("debitAcct", debitAccount);
            returnRes.put("creditAcct", "");

            return returnRes.toString();
        } catch (Exception xc) {
            xc.printStackTrace();
            JSONObject returnRes = new JSONObject();
            returnRes.put("phoneno", "");
            returnRes.put("txnFee", fee);
            returnRes.put("retrievalRef", paymentReference);
            returnRes.put("responseCode", "96");
            returnRes.put("debitAcct", debitAccount);
            returnRes.put("creditAcct", "");
            return returnRes.toString();
        }
    }

    public String getCredit(String baseurl, int timeout, String creditAccount, String paymentReference, String bankCode, String amount, String fee) {
        try {
            String url = baseurl + "/Transactions/Credit/";
            JSONObject request = new JSONObject();
            try {
                amount = Double.parseDouble(amount) / 100.0D + "";
            } catch (Exception localException1) {
            }
            request.put("NibssCode", bankCode);
            request.put("NibssCode", bankCode);
            request.put("AccountNumber", creditAccount);
            request.put("PaymentReference", paymentReference);
            request.put("Amount", amount);
            request.put("Fee", fee);
            request.put("Channel", 1);
            request.put("TransactionType", 1);


            String res = new HttpUtil().callWS(timeout, url, request.toString());
            JSONObject response = new JSONObject(res);
            JSONObject returnRes = new JSONObject();

            returnRes.put("phoneno", "");
            returnRes.put("txnFee", fee);
            returnRes.put("retrievalRef", paymentReference);
            returnRes.put("responseCode", response.opt("ResponseCode"));
            returnRes.put("debitAcct", "");
            returnRes.put("creditAcct", creditAccount);

            return returnRes.toString();
        } catch (Exception xc) {
            xc.printStackTrace();
            JSONObject returnRes = new JSONObject();
            returnRes.put("phoneno", "");
            returnRes.put("txnFee", fee);
            returnRes.put("retrievalRef", paymentReference);
            returnRes.put("responseCode", "96");
            returnRes.put("debitAcct", "");
            returnRes.put("creditAcct", creditAccount);
            return returnRes.toString();
        }
    }

    public String getName(String baseurl, int timeout, String accountNo, String bankCode, String ref) {
        try {
            String url = baseurl + "/Account/AccountEnquiry";
            JSONObject request = new JSONObject();
            request.put("AccountNo", accountNo);
            request.put("AuthenticationCode", bankCode);
            String res = new HttpUtil().callWS(timeout, url, request.toString());
            JSONObject response = new JSONObject(res);
            JSONObject returnRes = new JSONObject();

            returnRes.put("phoneno", response.opt("PhoneNuber"));
            returnRes.put("txnFee", "");
            returnRes.put("retrievalRef", ref);
            returnRes.put("responseCode", response.opt("ResponseCode"));
            returnRes.put("debitAcct", accountNo);
            returnRes.put("creditAcct", "");
            returnRes.put("ledgerBalance", "" + response.opt("LedgerBalance"));
            returnRes.put("availableBalance", "" + response.opt("AvailableBalance"));
            String bal = formatBalance("" + response.opt("LedgerBalance"), "" + response.opt("AvailableBalance"));
            if (!bal.isEmpty()) {
                returnRes.put("balance", bal);
            }
            returnRes.put("name", response.opt("Name"));
            returnRes.put("bvn", response.opt("BVN"));

            return returnRes.toString();
        } catch (Exception xc) {
            xc.printStackTrace();
            JSONObject returnRes = new JSONObject();
            returnRes.put("phoneno", "");
            returnRes.put("txnFee", "");
            returnRes.put("retrievalRef", ref);
            returnRes.put("responseCode", "96");
            returnRes.put("debitAcct", accountNo);
            returnRes.put("creditAcct", "");
            returnRes.put("ledgerBalance", "");
            returnRes.put("availableBalance", "");
            returnRes.put("balance", formatBalance("0", "0"));
            returnRes.put("name", "");
            return returnRes.toString();
        }
    }

    public String getBalance(String baseurl, int timeout, String accountNo, String bankCode, String ref) {
        try {
            String url = baseurl + "/Account/AccountEnquiry";
            JSONObject request = new JSONObject();
            request.put("AccountNo", accountNo);
            request.put("AuthenticationCode", bankCode);
            String res = new HttpUtil().callWS(timeout, url, request.toString());
            JSONObject response = new JSONObject(res);
            JSONObject returnRes = new JSONObject();

            returnRes.put("phoneno", response.opt("PhoneNuber"));
            returnRes.put("txnFee", "");
            returnRes.put("retrievalRef", ref);
            if ((response.optString("ResponseCode") != null) && (!response.optString("ResponseCode").isEmpty())) {
                returnRes.put("responseCode", response.optString("ResponseCode"));
            } else if (!response.optString("Name").isEmpty()) {
                returnRes.put("responseCode", "00");
            } else {
                returnRes.put("responseCode", "06");
            }
            returnRes.put("debitAcct", accountNo);
            returnRes.put("creditAcct", "");
            returnRes.put("ledgerBalance", "" + formatBalanceL(new StringBuilder().append("").append(response.opt("LedgerBalance")).toString()));
            returnRes.put("availableBalance", formatBalanceL("" + response.opt("AvailableBalance")));
            String bal = "" + formatBalance(new StringBuilder().append("").append(response.opt("LedgerBalance")).toString(), new StringBuilder().append("").append(response.opt("AvailableBalance")).toString());
            if ((!bal.trim().isEmpty()) && (!bal.trim().equalsIgnoreCase("null"))) {
                returnRes.put("balance", bal);
            }
            returnRes.put("name", response.opt("Name"));
            returnRes.put("bvn", response.opt("BVN"));
            System.out.println("returnRes.toString()" + returnRes.toString());
            return returnRes.toString();
        } catch (Exception xc) {
            xc.printStackTrace();
            JSONObject returnRes = new JSONObject();
            returnRes.put("phoneno", "");
            returnRes.put("txnFee", "");
            returnRes.put("retrievalRef", ref);
            returnRes.put("responseCode", "96");
            returnRes.put("debitAcct", accountNo);
            returnRes.put("creditAcct", "");
            returnRes.put("ledgerBalance", "");
            returnRes.put("availableBalance", "");
            returnRes.put("balance", formatBalance("0", "0"));
            returnRes.put("name", "");
            return returnRes.toString();
        }
    }

    public String formatAmount(String amount) {
        try {
            double myAmount = Double.parseDouble(amount);
            NumberFormat formatter = NumberFormat.getIntegerInstance(Locale.ENGLISH);
            formatter.setMinimumFractionDigits(2);
            formatter.setMaximumFractionDigits(2);
            formatter.setGroupingUsed(true);
            return formatter.format(myAmount);
        } catch (Exception dd) {
        }
        return amount;
    }

    public static String pad(int requiredLength, String inputText) {
        if (inputText == null) {
            return null;
        }
        int textSize = inputText.length();
        int sizeDifference = requiredLength - textSize;
        if (textSize < requiredLength) {
            for (int i = 0; i < sizeDifference; i++) {
                inputText = "0" + inputText;
            }
        } else if (textSize > requiredLength) {
            inputText = inputText.substring(0, requiredLength);
        }
        return inputText;
    }

    private String formatBalance(String amountL, String amountA) {
        try {
            amountL = formatAmount(amountL).replace(",", "");
            amountL = (new java.math.BigDecimal(amountL).multiply(new java.math.BigDecimal("1")) + "").replace(".", ":").split(":")[0];
            String amountLSign = "C";
            if (amountL.contains("-")) {
                amountLSign = "D";
            }
            amountL = "0102556" + amountLSign + pad(12, amountL);


            amountA = formatAmount(amountA).replace(",", "");
            amountA = (new java.math.BigDecimal(amountA).multiply(new java.math.BigDecimal("1")) + "").replace(".", ":").split(":")[0];
            String amountASign = "C";
            if (amountA.contains("-")) {
                amountASign = "D";
            }
            amountA = "0102556" + amountASign + pad(12, amountA);


            return amountL + amountA;
        } catch (Exception xc) {
            xc.printStackTrace();
        }
        return "";
    }

    public String formatAmountXX(String amt) {
        try {
            double myAmount = Double.parseDouble(amt);
            NumberFormat formatter = NumberFormat.getIntegerInstance(Locale.ENGLISH);
            formatter.setMinimumFractionDigits(2);
            formatter.setMaximumFractionDigits(2);
            formatter.setGroupingUsed(true);
            return formatter.format(myAmount);
        } catch (Exception dd) {
        }
        return amt;
    }

    private String formatBalanceL(String amount) {
        try {
            amount = formatAmount(amount).replace(",", "");
            amount = (new java.math.BigDecimal(amount).divide(new java.math.BigDecimal("100")) + "").replace(".", ":").split(":")[0];

            return formatAmountXX(amount);
        } catch (Exception xc) {
            xc.printStackTrace();
        }
        return "";
    }

}
