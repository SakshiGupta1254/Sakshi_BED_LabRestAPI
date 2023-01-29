package com.greatlearning.studentmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greatlearning.studentmanagementsystem.model.Student;
import com.greatlearning.studentmanagementsystem.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService service;
	
	@RequestMapping("/list")
	public String listStudent(Model model) {
		List<Student> result = service.getAllStudents();
		model.addAttribute("students", result);
		return "list_students";
	}
	@RequestMapping("/showFormForAdd")
	public String addNewStudent(Model model) {
		Student result = new Student();
		model.addAttribute("students", result);
		return "create_students";
	}
	@PostMapping("/save")
	public String saveNewEmployee(@ModelAttribute("student") Student student) {
		service.saveRecord(student);
		return "redirect:/student/list";
	}
	@GetMapping("/edit/{id}")
	public String UpdateEmployee(Model model, @PathVariable("id") int id) {
		Student result = service.getStudentById(id);
		model.addAttribute("student", result);
		return "edit_student";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmployee(Model model, @PathVariable("id") int id) {
		service.deleteStudentById(id);
		return "redirect:/student/list";
	}
	@PostMapping("/{id}")
	public String updateStudent(@ModelAttribute("student") Student student,@PathVariable("id") int id) {
		Student existingStudent = service.getStudentById(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setCourse(student.getCourse());
		existingStudent.setCountry(student.getCountry());
		service.saveRecord(existingStudent);
		return "redirect:/student/list";
	}


}
