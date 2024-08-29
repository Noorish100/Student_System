package com.Student_Application.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Student_Application.entity.Student;
import com.Student_Application.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentServices{
	
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student createStudent(Student student) {
		LocalDate today = LocalDate.now();
        int age = Period.between(student.getDob(), today).getYears();

        if (age < 15 || age > 20) {
            throw new IllegalArgumentException("Age should be greater than 15 and less than or equal to 20 years.");
        }

        return studentRepository.save(student);
	}

	@Override
	public Student updateMarks(Long id, Map<String, Integer> marks) {
		 Student student = studentRepository.findById(id)
	                .orElseThrow(() -> new IllegalArgumentException("Student not found."));

	        if (!marks.containsKey("marks1") || !marks.containsKey("marks2") || !marks.containsKey("marks3")) {
	            throw new IllegalArgumentException("Marks 1, Marks 2, and Marks 3 are mandatory.");
	        }

	        Integer marks1 = marks.get("marks1");
	        Integer marks2 = marks.get("marks2");
	        Integer marks3 = marks.get("marks3");

	        if (marks1 < 0 || marks1 > 100 || marks2 < 0 || marks2 > 100 || marks3 < 0 || marks3 > 100) {
	            throw new IllegalArgumentException("Marks must be between 0 and 100.");
	        }

	        student.setMarks1(marks1);
	        student.setMarks2(marks2);
	        student.setMarks3(marks3);

	        return studentRepository.save(student);
	    }
	
	

}
