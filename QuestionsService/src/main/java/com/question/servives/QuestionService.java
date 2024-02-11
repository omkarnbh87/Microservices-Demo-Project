package com.question.servives;

import java.util.List;

import com.question.entities.Question;

public interface QuestionService {

	Question createQuestion(Question question);

	List<Question> getAllQuestion();

	Question getQuestion(Long id);

	List<Question> getQuestinOfQuiz(Long quizId);
}
