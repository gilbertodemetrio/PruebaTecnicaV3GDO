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
import com.mx.fonyou.test.rest.dto.request.CreateStudentDTO;
import com.mx.fonyou.test.rest.dto.response.GenericResponse;
import com.mx.fonyou.test.rest.services.StudentServiceImpl;

/**
 * Controller para gestionar informacino de estudiantes
 * 
 * @author Gilberto Demetrio
 *
 */

@RestController
@RequestMapping("/v1/student")
public class StudentController {
	
	@Autowired
	private StudentServiceImpl studentService;
	
	@PostMapping("")
	public ResponseEntity<?> createStudent(@Valid @RequestBody CreateStudentDTO examDTO, Errors errors){
		if (errors.hasErrors()) {
	        return new ResponseEntity(GenericResponse.<Errors>builder()
					.response(errors).build(), HttpStatus.BAD_REQUEST);
	    }
		return ResponseEntity.ok(this.studentService.saveStudent(examDTO));
	}

}
