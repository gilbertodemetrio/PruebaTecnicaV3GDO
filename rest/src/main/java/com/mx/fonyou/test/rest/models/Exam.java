package com.mx.fonyou.test.rest.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mx.fonyou.test.rest.models.enums.StatusEnum;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "exam")
public class Exam {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_exam", nullable = false)
	private int idExam;
	@Column(name = "exam_name", nullable = false)
	private String examName;
	@Column(name = "status")
	private StatusEnum status;
	@Column(name = "user", nullable = false)
	private String user;
	@Column(name = "version", nullable = false)
	private String version;
	@Column(name = "exam_key", nullable = false)
	private String examKey;
	@Column(name = "creation")
	private Date creation;
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
			name = "exam_question",
			joinColumns = @JoinColumn(name = "id_exam", referencedColumnName = "id_exam"),
			inverseJoinColumns = @JoinColumn(name = "id_question", referencedColumnName = "id_question")
	)
	private List<Question> questions;

	@OneToMany(mappedBy = "exam")
	private List<StudentExam> students;
	
	public void addStudent(StudentExam studentExam) {
		if(students == null) {
			students = new ArrayList<>();
		}
		students.add(studentExam);
	}
}
