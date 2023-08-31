package com.mx.fonyou.test.rest.dto.request;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.mx.fonyou.test.rest.dto.exam.QuestionDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateExamDTO {
	@NotBlank
	private String examName;
	@NotBlank
	private String examKey;
	@NotBlank
	private String version;
	private String user;
	@NotEmpty
	private List<QuestionDTO> questions;
}
