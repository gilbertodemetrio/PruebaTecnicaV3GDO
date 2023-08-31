package com.mx.fonyou.test.rest.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.fonyou.test.rest.dto.request.CreateExamDTO;
import com.mx.fonyou.test.rest.services.ExamServiceImpl;

import lombok.extern.slf4j.Slf4j;

/**
 * Controller para gestionar informacino de examenes
 * 
 * @author Gilberto Demetrio
 *
 */
@RestController
@RequestMapping("/v1/exam")
@Slf4j
public class ExamController {
	
	@Autowired
	private ExamServiceImpl examServiceImpl;
	
	@PostMapping("")
	public ResponseEntity<?> createExam(@Valid @RequestBody CreateExamDTO examDTO){
		log.info("{}", examDTO);
		return ResponseEntity.ok(this.examServiceImpl.saveExam(examDTO));
	}

	@GetMapping("/hello")
	public ResponseEntity<?> createExam(){
		return ResponseEntity.ok("Hola");
	}
}
