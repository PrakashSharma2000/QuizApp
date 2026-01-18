package com.quiz.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.Repository.QuestionService;
import com.quiz.Service.Questions;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class QuestionCon {

	@Autowired
	QuestionService qs;
	
//	@GetMapping("csrf-token")
//	public CsrfToken getCsrfToken(HttpServletRequest request) {
//		return (CsrfToken) request.getAttribute("_csrf");
//		
//	}
	
	@GetMapping("show")
	public List<Questions> display() {
		
		qs.showQuestions().stream().forEach(x -> System.out.print(x));
		System.out.println("called");
		return qs.showQuestions();
	}
	
	@PostMapping("addQues")
	public void addQues(@RequestBody Questions question){
		
		 qs.addQuestion(question);
		 System.out.println(question.toString());
	}
}
