package com.ee.pxene.hadoop.mapreduce;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class WordCount {
	
//	public static void main(String[] args) throws Exception {
//		if(args.length != 2) {
//			System.err.println("Usage:wordcount <in> <out>");
//			System.exit(2);
//		}
//		Configuration conf = new Configuration();
//		Job job = Job.getInstance(conf, "word count");
//		job.setJarByClass(WordCount.class);
//		job.setMapperClass(TokenizerMapper.class);
//		job.setReducerClass(IntSumReducer.class);
//		job.setOutputKeyClass(Text.class);
//		job.setOutputValueClass(IntWritable.class);
//		FileInputFormat.addInputPath(job, new Path(args[0]));
//		FileOutputFormat.setOutputPath(job, new Path(args[1]));
//		System.exit(job.waitForCompletion(true) ? 0 : 1);
//	}
	
	public static void main(String[] args) throws Exception {
//		if(args.length != 2) {
//			System.err.println("Usage:wordcount <in> <out>");
//			System.exit(2);
//		}
		Configuration conf = HBaseConfiguration.create();
		String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
		if(otherArgs.length != 2) {
			System.err.println("Usage:wordcount <in> <out>");
			System.exit(2);
		}
		conf.set("hbase.zookeeper.property.clientPort", "2181");
		conf.set("hbase.zookeeper.quorum", "centos1, centos2, centos3");
		Job job = Job.getInstance(conf, "word count");
		
		job.setJarByClass(WordCount.class);
		
		FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
		job.setMapperClass(TokenizerMapper.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		
		TableMapReduceUtil.initTableReducerJob(otherArgs[1], IntSumReducer.class, job);
		
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}

}
