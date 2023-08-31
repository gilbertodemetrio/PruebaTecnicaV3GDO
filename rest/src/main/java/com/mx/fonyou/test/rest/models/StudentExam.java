package com.mx.fonyou.test.rest.models;

import java.util.Date;

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
@Table(name = "student_exam")
public class StudentExam {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_student_exam", nullable = false)
	private int idStudentExam;
	@Column(name = "due_date", nullable = false)
	private Date dueDate;
	@Column(name = "status", nullable = false)
	private StatusEnum status;
	@Column(name = "time_zone", nullable = false)
	private String timeZone;
	@Column(name = "exam_grade")
	private Double examGrade;
	@Column(name = "creation", nullable = false)
	private Date creation;
	@Column(name = "application_date")
	private Date applicationDate;
	
	@ManyToOne
	@JoinColumn(name = "id_student")
	private Student student; 
	
	@ManyToOne
	@JoinColumn(name = "id_exam")
	private Exam exam; 
}
