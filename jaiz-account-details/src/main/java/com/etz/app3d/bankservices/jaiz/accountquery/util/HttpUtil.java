package com.etz.app3d.bankservices.jaiz.accountquery.util;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Slf4j
public class HttpUtil {
   

    public String doGet(String requestUrl, int timeout)
            throws Exception
    {
        String response = "";
        URL url = new URL(requestUrl);
        System.out.println("The request url is : " + requestUrl);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setDoOutput(true);

        conn.setUseCaches(false);
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("User-Agent", "Mozilla/5.0");
        conn.setConnectTimeout(timeout);
        int responseCode = conn.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        if (responseCode == 200)
        {     
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            StringBuffer buff = new StringBuffer();
          System.out.println("Output from Server .... \n");
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                buff.append(inputLine);
            }
            in.close();
            conn.disconnect();

            System.out.println(buff.toString());
            response = buff.toString();
        }
        else {
           System.out.println("No successful response from GET request. Response is : " + responseCode);
        }
        return response;
    }
}
