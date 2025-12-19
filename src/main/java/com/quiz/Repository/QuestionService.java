package com.quiz.Repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.quiz.Service.Questions;

@Service
public class QuestionService{


	public Questions question;
	
	List<Questions> list = new ArrayList<Questions>();	
	
	public void addQuestion(Questions question) {
		list.add(question);		
	}
	
	public List<Questions> showQuestions(){
		return list;
	}
}
