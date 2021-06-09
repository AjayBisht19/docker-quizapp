package com.Quiz.entities;

import java.util.ArrayList; 
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Id;


@Entity
public class Quiz {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	private int marks;
	private String quizName;
	private String noOfQuestions;	
	
	@OneToMany(cascade=CascadeType.ALL,fetch= FetchType.LAZY ,mappedBy = "quiz")
	@JsonBackReference
	private List<Questions> questions= new ArrayList<>();

	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public String getQuizName() {
		return quizName;
	}


	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}


	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}




	public String getNoOfQuestions() {
		return noOfQuestions;
	}


	public void setNoOfQuestions(String noOfQuestions) {
		this.noOfQuestions = noOfQuestions;
	}


	public List<Questions> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Questions> questions) {
		this.questions = questions;
	}

	
	
	
	
	

}
