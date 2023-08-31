package com.mx.fonyou.test.rest.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.fonyou.test.rest.models.Exam;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Integer>{
	public Optional<Exam> findByExamKey(String examKey);
}
