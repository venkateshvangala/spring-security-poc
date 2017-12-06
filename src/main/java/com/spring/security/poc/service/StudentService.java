package com.spring.security.poc.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.spring.security.poc.entity.Student;

@Component
public class StudentService {
	
	private static List<Student> students = new ArrayList<>();

	static {
		Student ranga = new Student();
		ranga.setId("1");
		ranga.setName("Ranga Karanam");
		ranga.setDescription("Hiker, Programmer and Architect");
		students.add(ranga);
	}

	public Student retrieveStudent(String studentId) {
		for (Student student : students) {
			if (student.getId().equals(studentId)) {
				return student;
			}
		}
		return null;
	}

}
