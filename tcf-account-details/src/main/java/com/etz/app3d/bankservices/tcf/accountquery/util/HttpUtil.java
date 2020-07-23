package com.etz.app3d.bankservices.tcf.accountquery.util;

import lombok.extern.slf4j.Slf4j;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

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
            log.info("Output from Server .... \n");
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                buff.append(inputLine);
            }
            in.close();
            conn.disconnect();

            log.info(buff.toString());
            response = buff.toString();
        }
        else {
            log.info("No successful response from GET request. Response is : " + responseCode);
        }
        return response;
    }

    public String callWS(int timeout, String url, String urlParameters)
    {
        StringBuffer response = new StringBuffer();
        String USER_AGENT = "Mozilla/5.0";
        try
        {
            TrustManager[] trustAllCerts = { new X509TrustManager()
            {
                public X509Certificate[] getAcceptedIssuers()
                {
                    return null;
                }

                public void checkClientTrusted(X509Certificate[] certs, String authType) {}

                public void checkServerTrusted(X509Certificate[] certs, String authType) {}
            } };
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());


            HostnameVerifier allHostsValid = new HostnameVerifier()
            {
                public boolean verify(String hostname, SSLSession session)
                {
                    return true;
                }
            };
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);

            URL urlObject = new URL(url);
            try
            {
                HttpURLConnection connection = (HttpURLConnection)urlObject.openConnection();
                connection.setRequestMethod("GET");
                connection.setDoInput(true);
                connection.setDoOutput(true);
                connection.setConnectTimeout(timeout);
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setReadTimeout(timeout);
                connection.setRequestProperty("User-Agent", USER_AGENT);
                connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");


                connection.setDoOutput(true);
                DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
                wr.writeBytes(urlParameters);
                wr.flush();
                wr.close();
                int responseCode = connection.getResponseCode();
                System.out.println("\nSending 'POST' request to URL : " + url);
                System.out.println("XXXXX Post parameters : " + urlParameters);
                System.out.println("Response Code : " + responseCode);


                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                System.out.println(" response.toString()xxx " + response.toString());
                return response.toString();
            }
            catch (Exception sdz)
            {
                sdz.printStackTrace();
                HttpsURLConnection connection = (HttpsURLConnection)urlObject.openConnection();
                connection.setRequestMethod("GET");
                connection.setDoInput(true);
                connection.setDoOutput(true);
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setConnectTimeout(timeout);
                connection.setReadTimeout(timeout);
                connection.setRequestProperty("User-Agent", USER_AGENT);
                connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");


                connection.setDoOutput(true);
                DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
                wr.writeBytes(urlParameters);
                wr.flush();
                wr.close();

                int responseCode = connection.getResponseCode();
                System.out.println("\nSending 'POST' request to URL : " + url);
                System.out.println("Post parameters : " + urlParameters);
                System.out.println("Response Code : " + responseCode);


                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                System.out.println("Response responsezzz : " + response);
                return response.toString();
            }
        }
        catch (Exception sd)
        {
            sd.printStackTrace();
        }
        return null;
    }

}
