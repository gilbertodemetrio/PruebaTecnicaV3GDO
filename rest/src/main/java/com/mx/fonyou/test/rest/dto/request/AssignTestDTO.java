package com.mx.fonyou.test.rest.dto.request;


import com.mx.fonyou.test.rest.models.enums.StatusEnum;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AssignTestDTO {

	private String dueDateTest;
	private StatusEnum status;
	private String timeZone;
	private String examKey;
	private String studentKey; 
}
