package com.ee.hadoop.hdfs;

import java.io.IOException;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileUtil;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.PathFilter;

public class ShowFileStatus {

	public static void main(String[] args) throws IOException {
		String rootPath = "hdfs://centos1:20000/";
		String globPath = "/log/200?/*";
		final String filterPath = "^.*/log/2007/01.log$";
		
		FileSystem fs = FileSystem.get(URI.create(rootPath), new Configuration());
		FileStatus[] status = fs.globStatus(new Path(globPath), new PathFilter() {
			@Override
			public boolean accept(Path path) {
				return !path.toString().matches(filterPath);
			}
		});
		Path[] listedPaths = FileUtil.stat2Paths(status);
		for (Path p : listedPaths) {
			System.out.println(p);
		}
	}
}
