package com.greatlearning.studentmanagementsystem.serviceImpl;
 import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.studentmanagementsystem.model.Student;
import com.greatlearning.studentmanagementsystem.repository.StudentRepository;
import com.greatlearning.studentmanagementsystem.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepository studentRepository;
	@Override
	public void saveRecord(Student student) {
		studentRepository.save(student);
		
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	@Override
	public void deleteStudentById(int id) {
		studentRepository.deleteById(id);
		
	}
	@Override
	public Student getStudentById(int id) {
		return studentRepository.findById(id).get();
		
	}

	

}
