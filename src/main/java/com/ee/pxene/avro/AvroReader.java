package com.ee.pxene.avro;

import java.io.File;
import java.io.IOException;

import org.apache.avro.Schema;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;
import org.apache.avro.specific.SpecificDatumReader;

public class AvroReader {

	public static void main(String[] args) throws IOException {
//		DatumReader<Person> datumReader = new SpecificDatumReader<Person>(Person.class);
//		DataFileReader<Person> dataFileReader = new DataFileReader<Person>(new File("persons1.avro"), datumReader);
//		while(dataFileReader.hasNext()) {
//			System.out.println(dataFileReader.next());
//		}
		
		// 加载模式
		Schema schema = new Schema.Parser().parse(new File("person.avsc"));
		DatumReader<GenericRecord> datumReader = new SpecificDatumReader<GenericRecord>(schema);
		DataFileReader<GenericRecord> dataFileReader = new DataFileReader<GenericRecord>(new File("persons2.avro"), datumReader);
		while(dataFileReader.hasNext()) {
			System.out.println(dataFileReader.next());
		}
	}

}
