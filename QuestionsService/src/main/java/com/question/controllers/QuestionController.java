package com.question.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.entities.Question;
import com.question.servives.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService service;

	@GetMapping("get-all")
	List<Question> getAllQues() {
		return service.getAllQuestion();
	}

	@GetMapping("get/{id}")
	Question getAllQues(@PathVariable Long id) {
		return service.getQuestion(id);
	}

	@PostMapping("create")
	Question createQues(@RequestBody Question question) {
		return service.createQuestion(question);
	}

	@GetMapping("/quiz/{quizId}")
	public List<Question> getQuestionsOfQuiz(@PathVariable Long quizId) {
		return service.getQuestinOfQuiz(quizId);
	}
}
