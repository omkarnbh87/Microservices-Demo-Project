package com.quiz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.entities.Quiz;
import com.quiz.services.QuizServices;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	QuizServices services;

	@GetMapping("/get-all-quiz")
	List<Quiz> getAllQuiz() {
		return services.getAllQuiz();
	}

	@GetMapping("/get-quiz/{id}")
	Quiz getQuiz(@PathVariable Long id) {
		return services.getQuiz(id);
	}

	@PostMapping("/add-quiz")
	Quiz addQuiz(@RequestBody Quiz quiz) {
		return services.addQuiz(quiz);
	}
}
