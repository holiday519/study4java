package com.ee.hadoop.storm;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.topology.TopologyBuilder;

public class MainTopo {

	public static void main(String[] args) {
		TopologyBuilder builder = new TopologyBuilder();
		builder.setSpout("RandomWordSpout", new RandomWordSpout());
		builder.setBolt("TransferBolt", new TransferBolt()).shuffleGrouping("RandomWordSpout");
		builder.setBolt("WriterBolt", new WriterBolt()).shuffleGrouping("TransferBolt");
		
		Config conf = new Config();
		LocalCluster cluster = new LocalCluster();
		cluster.submitTopology("Demo", conf, builder.createTopology());
	}

}
