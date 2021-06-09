package com.Quiz.entities;

import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Id;



@Entity
public class Questions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	private String Question;
	private String op1;
	private String op2;
	private String op3;
	private String op4;
	private String correctAnswer;
	private String choosenAnswer;
	
	@ManyToOne
	@JsonManagedReference
	private Quiz quiz;

	public Questions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getQuestion() {
		return Question;
	}

	public void setQuestion(String question) {
		Question = question;
	}

	public String getOp1() {
		return op1;
	}

	public void setOp1(String op1) {
		this.op1 = op1;
	}

	public String getOp2() {
		return op2;
	}

	public void setOp2(String op2) {
		this.op2 = op2;
	}

	public String getOp3() {
		return op3;
	}

	public void setOp3(String op3) {
		this.op3 = op3;
	}

	public String getOp4() {
		return op4;
	}

	public void setOp4(String op4) {
		this.op4 = op4;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public String getChoosenAnswer() {
		return choosenAnswer;
	}

	public void setChoosenAnswer(String choosenAnswer) {
		this.choosenAnswer = choosenAnswer;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	@Override
	public String toString() {
		return "Questions [Id=" + Id + ", Question=" + Question + ", op1=" + op1 + ", op2=" + op2 + ", op3=" + op3
				+ ", op4=" + op4 + ", correctAnswer=" + correctAnswer + ", choosenAnswer=" + choosenAnswer + ", quiz="
				+ quiz + "]";
	}
	

	
}
