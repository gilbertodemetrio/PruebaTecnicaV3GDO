package com.mx.fonyou.test.rest.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.fonyou.test.rest.dto.request.AssignTestDTO;
import com.mx.fonyou.test.rest.dto.response.GenericResponse;
import com.mx.fonyou.test.rest.services.StudentExamServiceImpl;

/**
 * Controller para asignar examenes a estudiantes
 * 
 * @author Gilberto Demetrio
 *
 */
@RestController
@RequestMapping("/v1/assign-test")
public class StudentExamController {
	
	@Autowired
	private StudentExamServiceImpl studentExamServiceImpl;
	
	@PostMapping("")
	public ResponseEntity<?> createAssignTest(@Valid @RequestBody AssignTestDTO testDTO, Errors errors){
		if (errors.hasErrors()) {
	        return new ResponseEntity(GenericResponse.<Errors>builder()
					.response(errors).build(), HttpStatus.BAD_REQUEST);
	    }
		return ResponseEntity.ok(this.studentExamServiceImpl.saveStudentExam(testDTO));
	}

}
