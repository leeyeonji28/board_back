package com.project.boardback.question.service;

import com.project.boardback.question.DataNotFoundException;
import com.project.boardback.question.dao.QuestionRepository;
import com.project.boardback.question.domain.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public List<Question> getList(){
        return this.questionRepository.findAll();
    }

    public Question getQuestion(Integer id){ // id값으로 Question 데이터 조회하는 메소드
        Optional<Question> question = this.questionRepository.findById(id);
        if (question.isPresent()){ // 해당 데이터가 있는지 검사
            return question.get();
        } else {
            throw new DataNotFoundException("question no found");
        }
    }

    public void create(String subject, String content) {
        Question q = new Question();
        q.setSubject(subject);
        q.setContent(content);
        q.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q);
    }
}
