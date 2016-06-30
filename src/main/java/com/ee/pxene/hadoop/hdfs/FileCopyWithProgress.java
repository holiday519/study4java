package com.ee.pxene.hadoop.hdfs;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;

public class FileCopyWithProgress {

	public static void main(String[] args) throws Exception {
		// 本地文件路径
		String localSrc = "./sample.txt";
		// hdfs文件路径，centos1为namenode的IP地址，20000为core-site.xml中fs.default.name中配置的端口号
		String dst = "hdfs://centos1:20000/temp/copy.txt";
		InputStream in = new BufferedInputStream(new FileInputStream(localSrc));
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(URI.create(dst), conf);
		OutputStream out = fs.create(new Path(dst), new Progressable() {
			@Override
			public void progress() {
				System.out.println("将本地文件拷贝到hdfs");
			}
		});
		// 参数3：buffer缓冲区大小
		// 参数4：InputStream和OutputStream结束时是否关闭：true关闭，false不关闭
		IOUtils.copyBytes(in, out, 4096, true);
	}

}
