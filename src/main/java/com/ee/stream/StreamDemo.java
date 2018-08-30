package com.ee.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry.Entry;

public class StreamDemo {

	public static void main(String[] args) {
		Stream<String> stream = Stream.of("I", "love", "you", "too");
//		List<String> list = stream.collect(Collectors.toList());
		
		
//		Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
//		double d = stream.collect(Collectors.averagingInt(i -> i));
//		System.out.println(d);
		
//		List<Student> list = new ArrayList<Student>();
//		list.add(new Student(1, 1, 80));
//		list.add(new Student(2, 1, 90));
//		list.add(new Student(3, 2, 100));
//		list.add(new Student(4, 2, 100));
//		list.add(new Student(5, 3, 60));
		
//		Map<Integer, Double> map = list.stream().collect(Collectors.groupingBy(Student::getClassId, Collectors.averagingInt(Student::getScore)));
//		for (Map.Entry<Integer, Double> entry : map.entrySet()) {
//			System.out.println(entry.getKey() + "===" + entry.getValue());
//		}
		
		List<String> list = stream.collect(() -> {
			return new ArrayList<String>();
		}, (List<String> list0, String str) -> {
			list0.add(str);
		}, (List<String> list1, List<String> list2) -> {
			list1.addAll(list2);
		});
		
	}

	
}

class Student {
	private int id;
	private int classId;
	private int score;
	
	public Student(int id, int classId, int score) {
		super();
		this.id = id;
		this.classId = classId;
		this.score = score;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}