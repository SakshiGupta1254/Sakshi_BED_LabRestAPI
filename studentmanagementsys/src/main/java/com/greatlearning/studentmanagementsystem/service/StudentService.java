package com.greatlearning.studentmanagementsystem.service;
import java.util.List;

import com.greatlearning.studentmanagementsystem.model.Student;



public interface StudentService {
	public void saveRecord(Student student);
	public List<Student> getAllStudents();
	public void deleteStudentById(int Id);
	public Student getStudentById(int Id);
	
}
