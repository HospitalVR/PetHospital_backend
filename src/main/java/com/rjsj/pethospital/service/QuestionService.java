package com.rjsj.pethospital.service;

import com.rjsj.pethospital.entity.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionService {

    List<Question> findAll();
    List<Question> findAllByType(String type);
    Optional<Question> findById(Long id);

    Question findByContent(String name);

    List<Question> findAllByContent(String name);

    Question save(Question question);



    void deleteById(Long id);
}
