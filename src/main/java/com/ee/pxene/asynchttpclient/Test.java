package com.ee.pxene.asynchttpclient;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class Test {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		HttpGet get = new HttpGet("http://111.235.158.136:8080/bdapi/restful/fog/pxene/getInfoByTag/ctyun_bdcsc_pxene/310b31a8e2ff7b0373dc92a2f917ca79.json");
		get.setHeader("tag", "6");
		get.setHeader("index", "1");
		get.setHeader("timestamp", "1447063200000");
		
		CloseableHttpClient client = HttpClients.createDefault();
		CloseableHttpResponse resp = client.execute(get);
		
		InputStream in = resp.getEntity().getContent();
		byte[] bytes = new byte[512];
		in.read(bytes);
		System.out.println(new String(bytes, "UTF-8"));
		
	}
}
