package com.rjsj.pethospital.controller;

import com.rjsj.pethospital.entity.Paper;
import com.rjsj.pethospital.entity.Test;
import com.rjsj.pethospital.service.PaperService;
import com.rjsj.pethospital.service.TestService;
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
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "考试管理")
@RestController
@CrossOrigin
@RequestMapping("test")
public class TestController {
    @Autowired
    private TestService testService;

    @Autowired
    private PaperService paperService;

    @ApiOperation(value = "找到所有考试")
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseEntity<List<Test>> findAll() {
        try {
            List<Test> list = testService.findAll();
            if (list.isEmpty())
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            return ResponseEntity.status(HttpStatus.OK).body(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @ApiOperation(value = "按ID寻找考试")
    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public ResponseEntity<Test> findById(Long id) {
        try {
            Test test = testService.findById(id).orElse(null);
            if (test == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            return ResponseEntity.status(HttpStatus.OK).body(test);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @ApiOperation(value = "增加考试")
    @RequestMapping(value = "/addTest", method = RequestMethod.POST)
    public ResponseEntity<Test> addTest(HttpServletRequest request) {
        Test test = new Test();
        Long paper_id = Long.valueOf(request.getParameter("paper_id"));
        String ids = request.getParameter("user_id");
        List<Long> users_id = Arrays.stream(ids.split(",")).map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());

        try {
            Paper paper = paperService.findById(paper_id).orElse(null);
            if (paper == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            test = testService.addTest(test,paper,users_id);
            test = testService.save(test);
            return ResponseEntity.status(HttpStatus.OK).body(test);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }


    @ApiOperation(value = "删除考试")
    @RequestMapping(value = "/deleteById", method = RequestMethod.GET)
    public ResponseEntity<Test> deleteTestById(Long id) {
        testService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}



