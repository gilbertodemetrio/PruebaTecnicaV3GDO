package com.mx.fonyou.test.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.fonyou.test.rest.models.StudentExam;

@Repository
public interface StudentExamRepository extends JpaRepository<StudentExam, Integer>{
	
}
