package com.mx.fonyou.test.rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.fonyou.test.rest.dto.request.CreateStudentDTO;
import com.mx.fonyou.test.rest.dto.response.GenericResponse;
import com.mx.fonyou.test.rest.dto.response.SuccessfulOperation;
import com.mx.fonyou.test.rest.mappers.StudentMapper;
import com.mx.fonyou.test.rest.models.Student;
import com.mx.fonyou.test.rest.repositories.StudentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentServiceImpl {

	@Autowired
	private StudentRepository studenRepository;
	@Autowired
	private StudentMapper studentMapper;
	
	@Transactional
	public GenericResponse<?> saveStudent(CreateStudentDTO studentDto){
		log.info("Save student: {}", studentDto);
		Student studentEntity = this.studentMapper.mapToEntity(studentDto);
		this.studenRepository.save(studentEntity);
		
		GenericResponse<SuccessfulOperation> response = 
				GenericResponse.<SuccessfulOperation>builder()
				.response(
						SuccessfulOperation.builder().message("Alta Exitosa de estudiante").build()
						)
				.build();
		return response;
	}
}
