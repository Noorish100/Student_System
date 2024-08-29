package com.Student_Application.service;

import java.util.Map;

import com.Student_Application.entity.Student;

public interface StudentServices {
	
	 public Student createStudent(Student student);
	 
	  public Student updateMarks(Long id, Map<String, Integer> marks);
	  


}
