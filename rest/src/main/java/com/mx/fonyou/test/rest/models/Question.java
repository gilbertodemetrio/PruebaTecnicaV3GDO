package com.mx.fonyou.test.rest.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mx.fonyou.test.rest.models.enums.StatusEnum;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "question")
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_question")
	private int idQuestion;
	@Column(name = "question_text", nullable = false)
	private String questionText;
	@Column(name = "question_key", nullable = false)
	private String questionKey;
	@Column(name = "option_key_correct_answer")
	private String optionKeyCorrectAnswer;
	@Column(name = "status")
	private StatusEnum status;
	@ManyToMany(mappedBy = "questions")
	private List<Exam> exams;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_question", referencedColumnName = "id_question")
	private List<OptionQuestion> options;

}
