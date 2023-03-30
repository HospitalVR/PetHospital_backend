package com.rjsj.pethospital.service.impl;

import com.rjsj.pethospital.entity.Question;
import com.rjsj.pethospital.repository.QuestionRepository;
import com.rjsj.pethospital.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        return questionRepository.findAllByType(type);
    }

    @Override
    public Optional<Question> findById(Long id){
        return questionRepository.findById(id);
    }

    @Override
    public Question findByContent(String content) {
        return questionRepository.findByContent(content);
    }

    public List<Question> findAllByContent(String content) {
       List<Question> questions = questionRepository.findAll();
       List<Question> result = new ArrayList<>();
       for (Question question : questions){
           if(question.getContent().contains(content))
               result.add(question);
       }
       return result;
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
