package com.mx.fonyou.test.rest.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.mx.fonyou.test.rest.models.enums.StatusEnum;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CreateStudentDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotBlank(message = "Nombre es requerido")
	private String name;
	@NotBlank
	private String address;
	@NotBlank
	private String studentKey;
	@NotBlank
	private String city;
	private StatusEnum status;
	@NotBlank
	private String timeZone;

}
