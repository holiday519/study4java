package com.ee.hadoop.hbase;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

public class HBaseUtils {
	
	private static Configuration conf = HBaseConfiguration.create();
	static {
		conf.set("hbase.zookeeper.property.clientPort", "2181");
		conf.set("hbase.zookeeper.quorum", "centos1, centos2, centos3");
	}

	/**
	 * 创建表（要指定标的列簇名称）
	 */
	public static void createTable(String tableName, String[] families) throws IOException {
		HBaseAdmin admin = new HBaseAdmin(conf);
		if(admin.tableExists(tableName)) {
			System.out.println(tableName + " is existed");
		}else {
			HTableDescriptor hTableDescriptor = new HTableDescriptor(TableName.valueOf(tableName));
			for(String family : families) {
				hTableDescriptor.addFamily(new HColumnDescriptor(family));
			}
			admin.createTable(hTableDescriptor);
			System.out.println("success");
		}
		admin.close();
	}
	
	/**
	 * 删除表
	 */
	public static void deleteTable(String tableName) throws IOException {
		HBaseAdmin admin = new HBaseAdmin(conf);
		if(!admin.tableExists(tableName)) {
			System.out.println(tableName + " is not existed");
		}else {
			admin.disableTableAsync(tableName);
			admin.deleteTable(tableName);
			System.out.println("success");
		}
		admin.close();
	}
	
	/**
	 * 添加一行数据
	 */
	public static void addRowData(String tableName, String rowKey, Map<String, Map<String, byte[]>> families) throws IOException {
		HTable table = new HTable(conf, TableName.valueOf(tableName));
		Put put = new Put(rowKey.getBytes());
		Iterator<String> familiesIter = families.keySet().iterator();
		while(familiesIter.hasNext()) {
			String familyName = familiesIter.next();
			Map<String, byte[]> columns = families.get(familyName);
			Iterator<String> columnsIter = columns.keySet().iterator();
			while(columnsIter.hasNext()) {
				String columnName = columnsIter.next();
				put.add(familyName.getBytes(), columnName.getBytes(), columns.get(columnName));
			}
		}
		table.put(put);
		table.close();
		System.out.println("success");
	}
	
	/**
	 * 获取一行数据
	 */
	public static Map<String, Map<String, byte[]>> getRowData(String tableName, String rowKey) throws IOException {
		HTable table = new HTable(conf, TableName.valueOf(tableName));
		Get get = new Get(rowKey.getBytes());
		Result result = table.get(get);
		Map<String, Map<String, byte[]>> families = new HashMap<String, Map<String, byte[]>>();
		for(Cell cell : result.listCells()) {
			String family = Bytes.toString(cell.getFamilyArray(), cell.getFamilyOffset(), cell.getFamilyLength());
			String column = Bytes.toString(cell.getQualifierArray(), cell.getQualifierOffset(), cell.getQualifierLength());
			byte[] value = Arrays.copyOfRange(cell.getValueArray(), cell.getValueOffset(), cell.getValueOffset() + cell.getValueLength());
			if(families.containsKey(family)) {
				Map<String, byte[]> columns = families.get(family);
				columns.put(column, value);
			}else {
				Map<String, byte[]> columns = new HashMap<String, byte[]>();
				columns.put(column, value);
				families.put(family, columns);
			}
		}
		table.close();
		return families;
	}
	
	/**
	 * 删除一行数据
	 */
	public static void delRowData(String tableName, String rowKey) throws IOException {
		HTable table = new HTable(conf, TableName.valueOf(tableName));
		Delete delete = new Delete(rowKey.getBytes());
		table.delete(delete);
		table.close();
		System.out.println("success");
	}
	
	/**
	 * 获取一列簇数据
	 */
	public static void delFamilyData(String tableName, String rowKey, String family) throws IOException {
		HTable table = new HTable(conf, TableName.valueOf(tableName));
		Delete delete = new Delete(rowKey.getBytes());
		delete.deleteFamily(family.getBytes());
		table.delete(delete);
		table.close();
		System.out.println("success");
	}
	
	/**
	 * 获取一列数据
	 */
	public static void delColumnData(String tableName, String rowKey, String family, String column) throws IOException {
		HTable table = new HTable(conf, TableName.valueOf(tableName));
		Delete delete = new Delete(rowKey.getBytes());
		delete.deleteFamily(family.getBytes());
		delete.deleteColumn(family.getBytes(), column.getBytes());
		table.close();
		System.out.println("success");
	}
	
	public static void main(String[] args) throws IOException {
//		String[] families = {"name", "grade", "course"};
//		HBaseUtils.createTable("t_scores", families);
//		
//		HBaseUtils.deleteTable("t_scores");
//		
//		Map<String, Map<String, byte[]>> families = new HashMap<String, Map<String, byte[]>>();
//		Map<String, byte[]> grade = new HashMap<String, byte[]>();
//		grade.put("", "03".getBytes());
//		families.put("grade", grade);
//		Map<String, byte[]> course = new HashMap<String, byte[]>();
//		course.put("china", Bytes.toBytes(20));
//		course.put("math", Bytes.toBytes(30));
//		course.put("english", Bytes.toBytes(100));
//		families.put("course", course);
//		HBaseUtils.addRowData("t_scores", "zhanglu", families);
//		
//		Map<String, Map<String, byte[]>> families = HBaseUtils.getRowData("t_scores", "zhanglu");
//		System.out.println("zhanglu grade is " + Bytes.toString(families.get("grade").get("")));
//		System.out.println("zhanglu math score is " + Bytes.toInt(families.get("course").get("math")));
//		
//		HBaseUtils.delRowData("t_scores", "zhanglu");
//		
//		HBaseUtils.delRowData("t_scores", "zhanglu");
		
	}
}
