package com.mx.fonyou.test.rest.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.fonyou.test.rest.dto.request.CreateExamDTO;
import com.mx.fonyou.test.rest.dto.response.GenericResponse;
import com.mx.fonyou.test.rest.dto.response.SuccessfulOperation;
import com.mx.fonyou.test.rest.mappers.ExamMapper;
import com.mx.fonyou.test.rest.models.Exam;
import com.mx.fonyou.test.rest.models.Question;
import com.mx.fonyou.test.rest.models.enums.StatusEnum;
import com.mx.fonyou.test.rest.repositories.ExamRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ExamServiceImpl {

	@Autowired
	private ExamRepository examRepository;
	@Autowired
	private ExamMapper examMapper;
	
	@Transactional
	public GenericResponse<?> saveExam(CreateExamDTO exam){
		Exam examEntity = this.examMapper.mapToEntity(exam);
//		List<List<QuestionDTO>> questionWithIncorrectAnswer = this.validateAnswerQuestion(exam);
//		if(!questionWithIncorrectAnswer.isEmpty()) {
//			log.info("{}",questionWithIncorrectAnswer);
//		}
		this.comlementInformationNew(examEntity);
		this.examRepository.save(examEntity);
		
		GenericResponse<SuccessfulOperation> response = 
				GenericResponse.<SuccessfulOperation>builder()
				.response(
						SuccessfulOperation.builder().message("Alta Exitosa de examen").build()
						)
				.build();
		return response;
	}

	private void comlementInformationNew(Exam examEntity) {
		List<Question> questions = examEntity.getQuestions();
		questions.forEach(item -> {
			item.setStatus(StatusEnum.ACTIVE);
		});
		questions.forEach(item -> item.getOptions().forEach(subItem -> {
			subItem.setStatus(StatusEnum.ACTIVE);
			subItem.setQuestion(item);
		}));
	}
	
//	private List<List<QuestionDTO>> validateAnswerQuestion(CreateExamDTO exam) {
//		exam.getQuestions().stream()
//				.anyMatch(item -> 
//		
//		return null;
//	} 
}
