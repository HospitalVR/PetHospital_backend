package com.rjsj.pethospital.controller;

import com.rjsj.pethospital.entity.Paper;
import com.rjsj.pethospital.service.PaperService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Api(tags = "试卷管理")
@RestController
@CrossOrigin
@RequestMapping("paper")
public class PaperController {

    @Autowired
    private PaperService paperService;

    @ApiOperation(value = "找到所有试卷")
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseEntity<List<Paper>> findAll() {
        try {
            List<Paper> list = paperService.findAll();
            if (list.isEmpty())
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            return ResponseEntity.status(HttpStatus.OK).body(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @ApiOperation(value = "按ID寻找试卷")
    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public ResponseEntity<Paper> findById(Long id) {
        try {
            Paper paper = paperService.findById(id).orElse(null);
            if (paper == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            return ResponseEntity.status(HttpStatus.OK).body(paper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @ApiOperation(value = "增加试卷中的试题")
    @RequestMapping(value = "/addQuestions", method = RequestMethod.POST)
    public ResponseEntity<Paper> addQuestions(HttpServletRequest request) {

        Long paper_id = Long.valueOf(request.getParameter("paper_id"));
        String ids = request.getParameter("question_id");

        List<Long> questions_id = Arrays.stream(ids.split(",")).map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
        try {
            Paper paper = paperService.findById(paper_id).orElse(null);
            if (paper == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            paper = paperService.addQuestion(paper, questions_id);
            return ResponseEntity.status(HttpStatus.OK).body(paper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @ApiOperation(value = "删除试卷中的试题")
    @RequestMapping(value = "/deleteQuestions", method = RequestMethod.GET)
    public ResponseEntity<Paper> deleteQuestions(HttpServletRequest request) {

        Long paper_id = Long.valueOf(request.getParameter("paper_id"));
        String ids = request.getParameter("question_id");

        List<Long> questions_id = Arrays.stream(ids.split(",")).map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
        try {
            Paper paper = paperService.findById(paper_id).orElse(null);
            if (paper == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            paper = paperService.deleteQuestion(paper, questions_id);
            return ResponseEntity.status(HttpStatus.OK).body(paper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @ApiOperation(value = "增加试卷")
    @RequestMapping(value = "/addPaper", method = RequestMethod.POST)
    public ResponseEntity<Paper> addPaper(HttpServletRequest request) {
        Paper paper = new Paper();
        int period = Integer.parseInt(request.getParameter("period"));
        paper.setPeriod(period);

        String ids = request.getParameter("question_id");
        List<Long> questions_id  = Arrays.stream(ids.split(",")).map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
        if(questions_id==null)
            questions_id=new ArrayList<>();
        paper = paperService.addQuestion(paper, questions_id);

        paper = paperService.save(paper);
        return ResponseEntity.status(HttpStatus.OK).body(paper);
    }

    @ApiOperation(value = "删除试卷")
    @RequestMapping(value = "/deletePaperById", method = RequestMethod.GET)
    public ResponseEntity<Paper> deletePaperById(Long id) {
        paperService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

