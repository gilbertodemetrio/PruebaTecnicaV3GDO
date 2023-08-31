package com.mx.fonyou.test.rest.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.mx.fonyou.test.rest.dto.request.CreateExamDTO;
import com.mx.fonyou.test.rest.models.Exam;

@Mapper(componentModel = "spring")
public interface ExamMapper {
	
	@Mapping(target = "user", source = "user", defaultValue = "admin")
	@Mapping(target = "creation", expression = "java(new java.util.Date())")
	@Mapping(target = "status", expression = "java(com.mx.fonyou.test.rest.models.enums.StatusEnum.ACTIVE)")
	Exam mapToEntity(CreateExamDTO examDto);
	CreateExamDTO mapToDto(Exam exam);
	
	
}
