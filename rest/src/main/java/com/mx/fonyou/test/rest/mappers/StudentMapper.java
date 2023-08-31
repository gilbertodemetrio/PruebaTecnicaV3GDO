package com.mx.fonyou.test.rest.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.mx.fonyou.test.rest.dto.request.CreateStudentDTO;
import com.mx.fonyou.test.rest.models.Student;

/**
 * Mapper to convert  DTO to entity and entity to DTO
 * 
 * @author Gilberto Demetrio
 *
 */
@Mapper(componentModel = "spring")
public interface StudentMapper {

	@Mapping(target = "creation", expression = "java(new java.util.Date())")
	@Mapping(target = "status", expression = "java(com.mx.fonyou.test.rest.models.enums.StatusEnum.ACTIVE)")
	Student mapToEntity(CreateStudentDTO studentDto);

	CreateStudentDTO mapToDto(Student exam);
	
	
}
