package com.mx.fonyou.test.rest.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.mx.fonyou.test.rest.dto.exam.QuestionDTO;
import com.mx.fonyou.test.rest.models.Question;

@Mapper
public interface QuestionMapper {

	List<Question> mapToEntities(List<QuestionDTO> questionsDto);
	
	List<QuestionDTO> mapToDtos(List<Question> questions);
}
