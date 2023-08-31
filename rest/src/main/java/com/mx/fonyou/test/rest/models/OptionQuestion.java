package com.mx.fonyou.test.rest.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mx.fonyou.test.rest.models.enums.StatusEnum;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "option_question")
public class OptionQuestion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_option")
	private int idOption;
	@Column(name = "option_text", nullable = false)
	private String optionText;
	@Column(name = "option_key", nullable = false)
	private String optionKey;
	@Column(name = "status")
	private StatusEnum status;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_question")
	private Question question;

}
