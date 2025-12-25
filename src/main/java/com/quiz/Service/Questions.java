package com.quiz.Service;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Question")
@NoArgsConstructor
@Data
public class Questions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String question;
	private String[] answers;

	public Questions(String question, String[] answers) {
		this.question=question;
		this.answers=answers;
	}
}
