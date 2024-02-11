package com.quiz.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.entities.Quiz;
import com.quiz.repositories.QuizRepository;

@Service
public class QuizServiceImpl implements QuizServices {

	@Autowired
	private QuizRepository quizRepository;

	@Autowired
	private QuestionClient client;

	@Override
	public Quiz addQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return quizRepository.save(quiz);
	}

	@Override
	public List<Quiz> getAllQuiz() {
		// TODO Auto-generated method stub
		List<Quiz> quizes = quizRepository.findAll();
		List<Quiz> newQuizList = quizes.stream().map(quiz -> {
			quiz.setQuestions(client.getQuestions(quiz.getId()));
			return quiz;
		}).collect(Collectors.toList());
		return newQuizList;
	}

	@Override
	public Quiz getQuiz(Long id) {
		// TODO Auto-generated method stub
		Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new RuntimeException("QuizNotFound"));
		quiz.setQuestions(client.getQuestions(quiz.getId()));
		return quiz;
	}

}
