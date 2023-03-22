package com.rjsj.pethospital.service.impl;

import com.rjsj.pethospital.entity.Case;
import com.rjsj.pethospital.entity.Question;
import com.rjsj.pethospital.repository.QuestionRepository;
import com.rjsj.pethospital.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionRepository questionRepository;

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public List<Question> findAllByType(String type){
        List<Question> questions = questionRepository.findAll();
        List<Question> list = new ArrayList<>();
        for (Question question : questions) {
            if(question.getType().equals(type))
                list.add(question);
        }
        return list;
    }

    @Override
    public Optional<Question> findById(Long id){
        return questionRepository.findById(id);
    }

    @Override
    public Question findByContent(String content) {
        return questionRepository.findByContent(content);
    }

    @Override
    public Question save(Question question) {
        Question questionExist = questionRepository.findByContent(question.getContent());
        if (questionExist != null) {
            question.setId(questionExist.getId());
        }
        return questionRepository.save(question);
    }

    @Override
    public void deleteById(Long id) {
        questionRepository.deleteById(id);
    }
}
