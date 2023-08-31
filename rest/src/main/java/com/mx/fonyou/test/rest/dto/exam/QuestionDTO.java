package com.mx.fonyou.test.rest.dto.exam;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class QuestionDTO {
	@NotBlank
	private String questionKey;
	@NotBlank
	private String questionText;
	@NotEmpty
	private List<OptionQuestionDTO> options;
	private String optionKeyCorrectAnswer;
}
