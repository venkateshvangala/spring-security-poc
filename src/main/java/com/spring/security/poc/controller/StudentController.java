package com.spring.security.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.spring.security.poc.entity.Student;
import com.spring.security.poc.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/students/{studentId}")
	public Student retrieveStudent(@PathVariable String studentId) {
		return studentService.retrieveStudent(studentId);
	}
}
