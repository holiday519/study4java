package com.ee.hbase;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.log4j.Logger;

public class TestHBaseFilter {
	
	private static Logger log = Logger.getLogger(TestHBaseFilter.class);

	public static void main(String[] args) throws IOException {
		log.info("begin");
		
		Configuration conf = new Configuration();
		conf.set("hbase.zookeeper.property.clientPort", "2181");
		conf.set("hbase.zookeeper.quorum", "centos1,centos2,centos3");
		log.info("running-3");
		Connection conn = ConnectionFactory.createConnection(conf);
		log.info("running-2");
		Table table = conn.getTable(TableName.valueOf("user"));
		Get get = new Get(Bytes.toBytes("224382618261914241"));
		log.info("running-4");
		get.addColumn(Bytes.toBytes("info"), Bytes.toBytes("name"));
		log.info("running-5");
		Result result = table.get(get);
		log.info("running-6");
		byte[] val = result.getValue(Bytes.toBytes("info"), Bytes.toBytes("name"));
		log.info("Value: " + Bytes.toString(val));
		
//		log.info("running-4");
//		Scan scan1 = new Scan();
//		ResultScanner scanner = table.getScanner(scan1);
//		log.info("running-5");
//		for (Result res : scanner) {
//			log.info("running-1");
//			log.info(res);
//		}
//		log.info("running-6");
//		scanner.close();
		
		conn.close();
		
		log.info("end");
	}

}
