package com.mx.fonyou.test.rest.dto.exam;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class OptionQuestionDTO {
	@NotBlank
	private String optionKey;
	@NotBlank
	private String optionText;
	private boolean isSelected;
}
