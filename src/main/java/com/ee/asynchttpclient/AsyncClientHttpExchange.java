package com.ee.asynchttpclient;

import java.util.concurrent.Future;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;

/**
 * This example demonstrates a basic asynchronous HTTP request / response exchange.
 * Response content is buffered in memory for simplicity.
 */
public class AsyncClientHttpExchange {

    public static void main(final String[] args) throws Exception {
        CloseableHttpAsyncClient httpclient = HttpAsyncClients.createDefault();
        
        String url = "http://111.235.158.136:8080/bdapi/restful/fog/pxene/getInfoByTag/ctyun_bdcsc_pxene/1714fe09b20269cba3489b4c41dd9d13.json";
        
        try {
            httpclient.start();
            HttpGet request = new HttpGet(url);
            request.setHeader("tag", "6");
            request.setHeader("index", "1");
            request.setHeader("timestamp", "1447063200000");
            Future<HttpResponse> future = httpclient.execute(request, null);
            HttpResponse response = future.get();
            System.out.println("Response: " + response.getStatusLine());
            System.out.println("Shutting down");
        } finally {
            httpclient.close();
        }
        System.out.println("Done");
    }

}
