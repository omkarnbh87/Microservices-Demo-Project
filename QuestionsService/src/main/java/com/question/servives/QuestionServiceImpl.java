package com.question.servives;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.question.entities.Question;
import com.question.repositories.QuestionRepo;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepo repo;

	@Override
	public Question createQuestion(Question question) {
		// TODO Auto-generated method stub
		return repo.save(question);
	}

	@Override
	public List<Question> getAllQuestion() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Question getQuestion(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow(() -> new RuntimeException("QuestionNotFound"));
	}

	@Override
	public List<Question> getQuestinOfQuiz(Long quizId) {
		// TODO Auto-generated method stub
		return repo.findByQuizId(quizId);
	}

}
