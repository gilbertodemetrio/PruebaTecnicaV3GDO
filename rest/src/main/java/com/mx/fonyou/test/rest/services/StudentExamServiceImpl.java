package com.mx.fonyou.test.rest.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.fonyou.test.rest.dto.request.AssignTestDTO;

import com.mx.fonyou.test.rest.dto.response.GenericResponse;
import com.mx.fonyou.test.rest.dto.response.SuccessfulOperation;
import com.mx.fonyou.test.rest.mappers.StudentExamMapper;
import com.mx.fonyou.test.rest.models.StudentExam;
import com.mx.fonyou.test.rest.repositories.ExamRepository;
import com.mx.fonyou.test.rest.repositories.StudentRepository;
import com.mx.fonyou.test.rest.repositories.StudentExamRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentExamServiceImpl {

	@Autowired
	private StudentExamRepository studentExamRepository;
	@Autowired
	private ExamRepository examRepository;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private StudentExamMapper studentExamMapper;
	
	@Transactional
	public GenericResponse<?> saveStudentExam(final AssignTestDTO testDTO){
		log.info("Save studentExam: {}", testDTO);
		StudentExam studentExamEntity = this.studentExamMapper.mapToEntity(testDTO);
		this.complementInformation(studentExamEntity, testDTO);
		this.studentExamRepository.save(studentExamEntity);
		
		GenericResponse<SuccessfulOperation> response = 
				GenericResponse.<SuccessfulOperation>builder()
				.response(
						SuccessfulOperation.builder().message("Asignacion exitosa de test").build()
						)
				.build();
		return response;
	}
	
	private void complementInformation(StudentExam studentExamEntity, final AssignTestDTO testDTO) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			studentExamEntity.setDueDate(format.parse(testDTO.getDueDateTest()));
			var examOpt = this.examRepository.findByExamKey(testDTO.getExamKey());
			var studentOpt = this.studentRepository.findByStudentKey(testDTO.getStudentKey());
			if(!examOpt.isPresent() || !studentOpt.isEmpty()) {
				//throw new InvalidDataException();
			}
			studentExamEntity.setExam(examOpt.get());
			studentExamEntity.setStudent(studentOpt.get());
			//examOpt.get().addStudent(studentExamEntity);
			//studentOpt.get().addExam(studentExamEntity);
		} catch (ParseException e) {
			log.error("error:{}", e);
		}
		
	}
}
