//package com.ee.kafka;
//
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Properties;
//
//import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.apache.kafka.clients.consumer.ConsumerRecords;
//import org.apache.kafka.clients.consumer.KafkaConsumer;
//import org.apache.kafka.common.TopicPartition;
//
//import kafka.common.OffsetAndMetadata;
//
//public class ConsumerDemo {
//
//	private Map<TopicPartition, OffsetAndMetadata> currentOffsets = new HashMap<TopicPartition, OffsetAndMetadata>();
//
//	public class HandleRebalance implements ConsumerRebalanceListener {
//
//		@Override
//		public void onPartitionsRevoked(Collection<TopicPartition> partitions) {
//			System.out.println("Lost partitions in rebalance. Committing current offsets:" + currentOffsets);
//		}
//
//		@Override
//		public void onPartitionsAssigned(Collection<TopicPartition> partitions) {
//
//		}
//
//	}
//
//	public static void main(String[] args) {
//		Properties props = new Properties();
//		props.put("bootstrap.servers", "broker1:9092,broker2:9092");
//		props.put("group.id", "CountryCounter");
//		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//		props.put("enable.auto.commit", false);
//		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
//
//
//
//		while(true) {
//			ConsumerRecords<String, String> records = consumer.poll(100);
//			for (ConsumerRecord<String, String> record : records) {
//				System.out.printf("topic = %s, partition = %s, offset = %d, customer = %s, country = %s\n",
//						record.topic(), record.partition(), record.offset(), record.key(), record.value());
//			}
//		}
//	}
//}
