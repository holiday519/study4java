package com.ee.pxene.avro;

import org.apache.avro.Protocol;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;

public class AvroRPC {
	
	private Protocol protocol;
	
	public void sendMessage() {
		GenericRecord requestData = new GenericData.Record(protocol.getType("Person"));
		
	}

	public static void main(String[] args) {
		
	}

}
