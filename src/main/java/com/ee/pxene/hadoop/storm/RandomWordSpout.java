package com.ee.pxene.hadoop.storm;

import java.util.Map;
import java.util.Random;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;
import backtype.storm.utils.Utils;

public class RandomWordSpout extends BaseRichSpout {
	
	private static String[] words = {"apple", "orange", "banana", "watermelon", "strawberry", 
		"peach", "pear", "grape", "hawthorn", "pineapple"};
	private SpoutOutputCollector collector;
	private Random random = new Random();
	
	@Override
	public void nextTuple() {
		Utils.sleep(500);
		String word = words[random.nextInt(words.length)];
		collector.emit(new Values(word));
	}

	@Override
	public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
		this.collector = collector;
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("word"));
	}

}
