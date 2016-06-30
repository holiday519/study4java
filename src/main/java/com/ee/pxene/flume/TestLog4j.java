package com.ee.pxene.flume;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TestLog4j {

	private static Log logger = LogFactory.getLog(TestLog4j.class);
	
	public static void main(String[] args) throws InterruptedException {
		int count = 0;
		while(true) {
			logger.info(new Date().getTime());
			System.out.println(count++);
			Thread.sleep(10);
		}
	}
}
