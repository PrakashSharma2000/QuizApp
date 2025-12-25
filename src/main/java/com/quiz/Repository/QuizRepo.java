package com.quiz.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.Service.Questions;

@Repository
public interface QuizRepo extends JpaRepository<Questions, Integer> {

}
