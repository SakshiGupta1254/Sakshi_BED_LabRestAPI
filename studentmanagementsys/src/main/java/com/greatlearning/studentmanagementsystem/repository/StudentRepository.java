package com.greatlearning.studentmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.studentmanagementsystem.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
