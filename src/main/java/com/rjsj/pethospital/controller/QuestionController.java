package com.rjsj.pethospital.controller;

import com.rjsj.pethospital.entity.Question;
import com.rjsj.pethospital.service.QuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "试题管理")
@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @ApiOperation(value = "找到所有试题")
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

    @ApiOperation(value = "按类别寻找试题")
    @RequestMapping(value="/findAllByType",method = RequestMethod.GET)
    public ResponseEntity<List<Question>> findAllByType(String type) {
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

    @ApiOperation(value = "按ID寻找试题")
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

    @ApiOperation(value = "按内容精确寻找试题")
    @RequestMapping(value = "/findByContent", method = RequestMethod.GET)
    public ResponseEntity<Question> findByContent(String content) {
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

    @ApiOperation(value = "按内容模糊寻找试题")
    @RequestMapping(value = "/findAllByContent", method = RequestMethod.GET)
    public ResponseEntity<List<Question>> findAllByContent(String content) {
        try {
            List<Question> question = questionService.findAllByContent(content);
            if (question == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

            return ResponseEntity.status(HttpStatus.OK).body(question);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }


    @ApiOperation(value = "增加试题")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Question> save(@RequestBody Question question) {
        questionService.save(question);
        return ResponseEntity.status(HttpStatus.OK).body(question);
    }

    @ApiOperation(value = "删除试题")
    @RequestMapping(value = "/deleteById", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteById(Long id) {
       questionService.deleteById(id);
       return ResponseEntity.status(HttpStatus.OK).build();
    }
}
