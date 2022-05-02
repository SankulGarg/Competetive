package com.github.sankulgarg.hackerrank;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

class JavaPriorityQueue {

	PriorityQueue<Student> queue = null;
	Comparator<Student> studentComparator = Comparator.comparing(Student::getCgpa, (s1, s2) -> s2.compareTo(s1))
			.thenComparing(Student::getName).thenComparing(Student::getId);

	JavaPriorityQueue() {
		queue = new PriorityQueue<>(studentComparator);
	}

	List<Student> getStudents(List<String> events) {

		for (String event : events) {
			String[] detail = event.split(" ");
			if ("ENTER".equals(detail[0])) {
				Student newStudent = new Student(Integer.valueOf(detail[3]), detail[1], Double.valueOf(detail[2]));
				queue.add(newStudent);
			} else
				queue.poll();

		}
		List<Student> studentYetToBeServed= new ArrayList<>();
		IntStream.range(0, queue.size()).boxed().forEach(i-> studentYetToBeServed.add(queue.poll()));
		
		return studentYetToBeServed;

	}

}

class Student {
	private int id;
	private String name;
	private double cgpa;

	Student(int id, String name, double cgpa) {
		this.id = id;
		this.name = name;
		this.cgpa = cgpa;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getCgpa() {
		return cgpa;
	}
}
