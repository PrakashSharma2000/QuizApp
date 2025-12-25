package com.quiz.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.Service.Questions;

@Service
public class QuestionService{

	@Autowired
	public QuizRepo qr;
		
	public void addQuestion(Questions question) {
		qr.save(question);
	}
	
	public List<Questions> showQuestions(){
		
		return qr.findAll();
	}
}
