package com.mx.fonyou.test.rest.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mx.fonyou.test.rest.models.enums.StatusEnum;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_student", nullable = false)
	private int idStudent;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "student_key", nullable = false)
	private String studentKey;
	@Column(name = "address", nullable = false)
	private String address;
	@Column(name = "city", nullable = false)
	private String city;
	@Column(name = "status", nullable = false)
	private StatusEnum status;
	@Column(name = "time_zone", nullable = false)
	private String timeZone;
	@Column(name = "creation", nullable = false)
	private Date creation;
	
	@OneToMany(mappedBy = "student")
	private List<StudentExam> exams;
	
	public void addExam(StudentExam studentExam) {
		if(exams == null) {
			exams = new ArrayList<>();
		}
		exams.add(studentExam);
	}
}
