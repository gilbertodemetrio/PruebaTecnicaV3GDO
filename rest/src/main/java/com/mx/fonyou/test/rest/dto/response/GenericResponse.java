package com.mx.fonyou.test.rest.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class GenericResponse <T> {
	private T response;
}
