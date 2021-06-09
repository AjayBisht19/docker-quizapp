package com.Quiz.controller;
import com.Quiz.dao.*;   
import com.Quiz.entities.Questions;
import com.Quiz.entities.Quiz;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mysql.cj.conf.ConnectionUrlParser.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private QuizRepository quizService;
	
	@Autowired
	private QuestionsRepository questionsService;
	
	@GetMapping("/dashboard")
	private List<Quiz> get(){
		return quizService.findAll();
	}
	
	@GetMapping("/dashboard/{qId}")
	private List<Questions> getQues(@PathVariable("qId") Integer qId){
		System.out.println(qId);
		
		return questionsService.findAllByQuizId(qId);
	}
	
	@PostMapping("/addQuiz")
	private Quiz postQuiz(@RequestBody HashMap<String, String> quiz){
		Quiz q = new Quiz();
		q.setQuizName(quiz.get("quizName"));
		q.setNoOfQuestions(quiz.get("noOfQuestions"));
		
		return this.quizService.save(q);
	}
	
		
	
	@PostMapping("/addQuestion/{qId}")
	private Questions postQuestion(@RequestBody HashMap<String, String> question,@PathVariable("qId") Integer qId){
		Optional<Quiz> qu =quizService.findById(qId);
		Quiz quiz= qu.get();
		
		Questions q=new Questions(); 
		q.setQuestion(question.get("question"));
		q.setOp1(question.get("op1"));
		q.setOp2(question.get("op2"));
		q.setOp3(question.get("op3"));
		q.setOp4(question.get("op4"));
		q.setCorrectAnswer(question.get("correct"));
		q.setQuiz(quiz);
		
		
		System.out.println(q);
		
		return this.questionsService.save(q);
	}
	
	@DeleteMapping("/delete/{quizid}")
	private void deleteQuiz(@PathVariable("quizid") Integer quizid) {
		System.out.println(quizid);
		System.out.println("deleted");
		quizService.deleteById(quizid);
		
	}
}
