package com.rjsj.pethospital.controller;

import com.rjsj.pethospital.entity.Question;
import com.rjsj.pethospital.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("test")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseEntity<List<Question>> findAll() {
        try {
            List<Question> list = questionService.findAll();
            if (list.isEmpty())
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            return ResponseEntity.status(HttpStatus.OK).body(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value="/findAllByType",method = RequestMethod.GET)
    public ResponseEntity<List<Question>> findAllQuestionByType(String type) {
        try {
            List<Question> list = questionService.findAllByType(type);
            if (list.isEmpty())
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            return ResponseEntity.status(HttpStatus.OK).body(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public ResponseEntity<Question> findById(Long id) {
        try {
            Question quesion = questionService.findById(id).orElse(null);
            if (quesion == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

            return ResponseEntity.status(HttpStatus.OK).body(quesion);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/findByContent", method = RequestMethod.GET)
    public ResponseEntity<Question> findByName(String content) {
        try {
            Question question = questionService.findByContent(content);
            if (question == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

            return ResponseEntity.status(HttpStatus.OK).body(question);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Question> save(@RequestBody Question question) {
        questionService.save(question);
        return ResponseEntity.status(HttpStatus.OK).body(question);
    }

    @RequestMapping(value = "/deleteById", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteById(Long id) {
       questionService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
