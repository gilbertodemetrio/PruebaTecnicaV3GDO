package com.mx.fonyou.test.rest.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.mx.fonyou.test.rest.dto.request.AssignTestDTO;
import com.mx.fonyou.test.rest.models.StudentExam;

@Mapper(componentModel = "spring")
public interface StudentExamMapper {
	
	@Mapping(target = "creation", expression = "java(new java.util.Date())")
	@Mapping(target = "status", expression = "java(com.mx.fonyou.test.rest.models.enums.StatusEnum.ACTIVE)")
	StudentExam mapToEntity(AssignTestDTO test);
	AssignTestDTO mapToDto(StudentExam test);

}
