package com.mx.fonyou.test.rest.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.fonyou.test.rest.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	public Optional<Student> findByStudentKey(String studentKey);
}
