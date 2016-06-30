package com.ee.asynchttpclient;

import java.io.IOException;
import java.io.InputStream;
import java.nio.CharBuffer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.nio.IOControl;
import org.apache.http.nio.client.methods.AsyncCharConsumer;
import org.apache.http.nio.client.methods.HttpAsyncMethods;
import org.apache.http.nio.protocol.HttpAsyncRequestProducer;
import org.apache.http.protocol.HttpContext;

public class Demo {

	public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
		String url = "http://111.235.158.136:8080/bdapi/restful/fog/pxene/getInfoByTag/ctyun_bdcsc_pxene/310b31a8e2ff7b0373dc92a2f917ca79.json";
		CloseableHttpAsyncClient httpclient = HttpAsyncClients.createDefault();
		try {
		    // Start the client
		    httpclient.start();
		    
		    /*// Execute request
		    HttpGet get = new HttpGet(url);
		    get.setHeader("tag", "6");
			get.setHeader("index", "1");
			get.setHeader("timestamp", "1447063200000");
		    Future<HttpResponse> future = httpclient.execute(get, null);
		    // and wait until a response is received
		    HttpResponse resp = future.get();
		    System.out.println(get.getRequestLine() + "->" + resp.getStatusLine());*/

		    // One most likely would want to use a callback for operation result
		    final CountDownLatch latch = new CountDownLatch(1);
		    final HttpGet get = new HttpGet(url);
		    get.setHeader("tag", "6");
			get.setHeader("index", "1");
			get.setHeader("timestamp", "1447063200000");
		    httpclient.execute(get, new FutureCallback<HttpResponse>() {

		        public void completed(final HttpResponse resp) {
		            latch.countDown();
		            System.out.println(get.getRequestLine() + "->" + resp.getStatusLine());
		        }

		        public void failed(final Exception ex) {
		        	latch.countDown();
		            System.out.println(get.getRequestLine() + "->" + ex);
		        }

		        public void cancelled() {
		        	latch.countDown();
		            System.out.println(get.getRequestLine() + " cancelled");
		        }

		    });
		    latch.await();
		    System.out.println("this sysout executing first");

		    // In real world one most likely would also want to stream
		    // request and response body content
		    /*final CountDownLatch latch = new CountDownLatch(1);
		    final HttpGet get = new HttpGet(url);
		    get.setHeader("tag", "6");
			get.setHeader("index", "1");
			get.setHeader("timestamp", "1447063200000");
		    HttpAsyncRequestProducer producer = HttpAsyncMethods.create(get);
		    AsyncCharConsumer<HttpResponse> consumer = new AsyncCharConsumer<HttpResponse>() {

		        HttpResponse response;

		        @Override
		        protected void onResponseReceived(final HttpResponse response) {
		            this.response = response;
		            System.out.println("onResponseReceived");
		        }

		        @Override
		        protected void onCharReceived(final CharBuffer buf, final IOControl ioctrl) throws IOException {
		            // Do something useful
		        	System.out.println("onCharReceived");
		        	char[] chars = new char[buf.length()];
		        	buf.get(chars);
		        	System.out.println(String.valueOf(chars));
		        }

		        @Override
		        protected void releaseResources() {
		        	System.out.println("releaseResources");
		        }

		        @Override
		        protected HttpResponse buildResult(final HttpContext context) {
		            return this.response;
		        }

		    };
		    httpclient.execute(producer, consumer, new FutureCallback<HttpResponse>() {

		        public void completed(final HttpResponse resp) {
		            latch.countDown();
		            System.out.println(get.getRequestLine() + "->" + resp.getStatusLine());
		        }

		        public void failed(final Exception ex) {
		            latch.countDown();
		            System.out.println(get.getRequestLine() + "->" + ex);
		        }

		        public void cancelled() {
		            latch.countDown();
		            System.out.println(get.getRequestLine() + " cancelled");
		        }

		    });
		    latch.await();*/

		} finally {
		    httpclient.close();
		}
	}
}
