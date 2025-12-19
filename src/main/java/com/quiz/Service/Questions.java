package com.quiz.Service;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Question")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Questions {
	
	@Id
	@GeneratedValue()
	private int id=1;
	private String question;
	private String[] answers;

}
