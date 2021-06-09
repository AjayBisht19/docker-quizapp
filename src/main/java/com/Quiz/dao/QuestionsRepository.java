package com.Quiz.dao;

import java.util.List; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Quiz.entities.Questions;

public interface QuestionsRepository extends JpaRepository<Questions, Integer>{
	
	@Query("select q from Questions q where q.quiz.Id =:qId")
	public List<Questions> findAllByQuizId(@Param("qId") Integer qId);

}
