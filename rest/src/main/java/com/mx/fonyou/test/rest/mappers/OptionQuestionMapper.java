package com.mx.fonyou.test.rest.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.mx.fonyou.test.rest.dto.exam.OptionQuestionDTO;
import com.mx.fonyou.test.rest.models.OptionQuestion;

@Mapper
public interface OptionQuestionMapper {
	List<OptionQuestion> mapToEntities(List<OptionQuestionDTO> optionsQuestionDto);
	
	List<OptionQuestionDTO> mapToDtos(List<OptionQuestion> optionsQuestionEntity);
}
