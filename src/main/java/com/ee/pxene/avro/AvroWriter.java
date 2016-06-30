package com.ee.pxene.avro;

import java.io.File;
import java.io.IOException;

import org.apache.avro.Schema;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;

public class AvroWriter {

	public static void main(String[] args) throws IOException {
//		// 第一种创建方式
//		Person p1 = new Person("zhanglu", 30);
//		// 第二种创建方式
//		Person p2 = new Person();
//		p2.setName("ningyu");
//		p2.setAge(28);
//		// 第三种创建方式
//		Person p3 = Person.newBuilder()
//				.setName("zhengyi")
//				.setAge(27)
//				.build();
//		// 序列化
//		DatumWriter<Person> datumWriter = new SpecificDatumWriter<Person>(Person.class);
//		DataFileWriter<Person> dataFileWriter = new DataFileWriter<Person>(datumWriter); 
//		dataFileWriter.create(p1.getSchema(), new File("persons1.avro"));
//		dataFileWriter.append(p1);
//		dataFileWriter.append(p2);
//		dataFileWriter.append(p3);
//		dataFileWriter.close();
		
		// 加载模式
		Schema schema = new Schema.Parser().parse(new File("person.avsc"));
		// 创建数据
		GenericRecord p1 = new GenericData.Record(schema);
		p1.put("name", "xiaodou");
		p1.put("age", 25);
		GenericRecord p2 = new GenericData.Record(schema);
		p2.put("name", "huyang");
		p2.put("age", 30);
		GenericRecord p3 = new GenericData.Record(schema);
		p3.put("name", "zhuge");
		p3.put("age", 32);
		// 序列化
		DatumWriter<GenericRecord> datumWriter = new SpecificDatumWriter<GenericRecord>(schema);
		DataFileWriter<GenericRecord> dataFileWriter = new DataFileWriter<GenericRecord>(datumWriter);
		dataFileWriter.create(schema, new File("persons2.avro"));
		dataFileWriter.append(p1);
		dataFileWriter.append(p2);
		dataFileWriter.append(p3);
		dataFileWriter.close();
	}
}
