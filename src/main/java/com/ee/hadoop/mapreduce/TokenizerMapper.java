package com.ee.hadoop.mapreduce;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TokenizerMapper extends Mapper<Object, Text, Text, IntWritable> {
	
	private static final IntWritable one = new IntWritable(1);
	private Text word = new Text();
	
	@Override
	protected void map(Object key, Text value, Context context)
			throws IOException, InterruptedException {
		// 分词（用空格分隔）
        StringTokenizer itr = new StringTokenizer(value.toString());
        while(itr.hasMoreTokens()) {
        	// 每个单词写入1
        	word.set(itr.nextToken());
        	context.write(word, one);
        }
	}
	
}
