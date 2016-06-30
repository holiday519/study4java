package com.ee.hadoop.mapreduce;

import java.io.IOException;

import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.mapreduce.TableReducer;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

//public class IntSumReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
//	
//	private IntWritable result = new IntWritable();
//
//	@Override
//	public void reduce(Text key, Iterable<IntWritable> values, Context context)
//			throws IOException, InterruptedException {
//		int sum = 0;
//		for(IntWritable value : values) {
//			// 将每个单词的1累加起来，就是该单词出现的次数
//			sum += value.get();
//		}
//		result.set(sum);
//		context.write(key, result);
//	}
//	
//}

public class IntSumReducer extends TableReducer<Text, IntWritable, Text> {
	
	@Override
	public void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {
		int sum = 0;
		for(IntWritable value : values) {
			// 将每个单词的1累加起来，就是该单词出现的次数
			sum += value.get();
		}
		Put put = new Put(key.getBytes());
		put.add("count".getBytes(), "".getBytes(), Bytes.toBytes(sum));
		context.write(key, put);
	}
	
	public static void main(String[] args) {
		String str = "2CAAA0FD69395C600E5E6DDD5D906998|92E24BDE038C3909B10879301333BE2E|22E7ECEF749EA04A9208F127461FE8FC|ctnet@mycdma.cn|117.25.155.240|80|27.148.61.119|49644|115.168.13.246|172.28.113.157||0||6800A8C0006A800000AC1C719431000000|59|1|349|20150509040353|20150509040353|140|2070|1071|4|5|20150509040353|1|Mozilla/5.0 (Linux; U; Android 4.3; zh-cn; MI 3C Build/JLS36C)|http://g.ald.alicdn.com/bao/uploaded/T1hICfFEXeXXb1upjX.jpg_q60.jpg|g.ald.alicdn.com|g.ald.alicdn.com|1299|image/jpeg|1|http://www.tmall.com/?locate=icon-1&spm=a2141.1.1.icon-1&actparam=1_46784_h38679_%E5%85%A5%E5%8F%A3-%E5%A4%A9%E7%8C%AB&force=m&from=tbc&imei=099000549299746&imsi=460030906389502&ttid=600000@taobao_android_5.2.6|6|200|1|0";
		String[] arr = str.split("\\|");
		for(int i=0; i<arr.length; i++) {
			System.out.println(i+1 + ":" + arr[i]);
		}
	}
	
}
