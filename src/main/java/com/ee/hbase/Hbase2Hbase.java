package com.ee.hbase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

import com.ee.hbase.common.HBaseTools;

public class Hbase2Hbase {

	public static void main(String[] args) {
		Table table = HBaseTools.openTable("t_prod_weixin_art");
	    Table tableTmp = HBaseTools.openTable("t_prod_weixin_art_temp");
	    
	    List<String> datas = HBaseTools.scanValueDatas(table, "info", "article_content", 1000);
	    Map<String, byte[]> columns = new HashMap<String, byte[]>();
	    
	    for (int i=0; i<datas.size(); i++) {
	    	System.out.println("<=ee-debug=>index===============" + i);
	    	columns.put("article_content", Bytes.toBytes(datas.get(i)));
	    	HBaseTools.putColumnDatas(tableTmp, "ee_" + UUID.randomUUID().toString(), "info", columns);
	    }
	    
	    HBaseTools.closeTable(table);
	    HBaseTools.closeTable(tableTmp);
	    HBaseTools.closeConn();
	}
}
