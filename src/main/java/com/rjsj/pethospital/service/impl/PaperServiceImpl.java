package com.rjsj.pethospital.service.impl;

import com.rjsj.pethospital.entity.Paper;
import com.rjsj.pethospital.entity.Question;
import com.rjsj.pethospital.repository.PaperRepository;
import com.rjsj.pethospital.repository.QuestionRepository;
import com.rjsj.pethospital.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PaperServiceImpl implements PaperService {

    @Autowired
    PaperRepository paperRepository;
    @Autowired
    QuestionRepository questionRepository;

    @Override
    public List<Paper> findAll() {
        return paperRepository.findAll();
    }

    @Override
    public Optional<Paper> findById(Long id) {
        return paperRepository.findById(id);
    }

    @Override
    public Paper addQuestion(Paper paper, List<Long> questions_id) {
        List<Question> list = questionRepository.findAll();
        List<Question> result = paper.getQuestions();

        for(Question question : list)
            if(questions_id.contains(question.getId()) && !result.contains(question))
                result.add(question);
        paper.setQuestions(result);

        return paperRepository.save(paper);
    }

    @Override
    public Paper deleteQuestion(Paper paper, List<Long> questions_id) {
        List<Question> list = questionRepository.findAll();
        List<Question> result =  paper.getQuestions();
        for(Question question : list)
            if(questions_id.contains(question.getId()) && result.contains(question))
                result.remove(question);
        paper.setQuestions(result);
        return paperRepository.save(paper);
    }

    @Override
    public Paper save(Paper paper) {
        List<Question> list = paper.getQuestions();
        int sum= 0;
        for(Question question : list)
            sum += question.getScore();
        paper.setTotal_score(sum);
        return paperRepository.save(paper);
    }

    @Override
    public void deleteById(Long id) {
        paperRepository.deleteById(id);
    }
}
