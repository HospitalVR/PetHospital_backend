package com.rjsj.pethospital.controller;

import com.rjsj.pethospital.entity.Case;
import com.rjsj.pethospital.entity.PositionJob;
import com.rjsj.pethospital.service.PositionJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("position")
public class PositionController {

    @Autowired
    private PositionJobService positionJobService;

    @RequestMapping(value = "/findAllPosition", method = RequestMethod.GET)
    public ResponseEntity<List<String>> findAllPosition() {
        try {
            List<String> allPosition = positionJobService.getAllPosition();
            return ResponseEntity.status(HttpStatus.OK).body(allPosition);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/findAllByPosition", method = RequestMethod.GET)
    public ResponseEntity<List<String>> findAllByPosition(String position) {
        try {
            List<String> allPositionJob = positionJobService.findAllByPosition(position);
            return ResponseEntity.status(HttpStatus.OK).body(allPositionJob);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/findJobDetail", method = RequestMethod.GET)
    public ResponseEntity<List<String>> findJobDetail() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/findByPositionAndAndJob", method = RequestMethod.GET)
    public ResponseEntity<PositionJob> findByPositionAndAndJob(String position, String job) {
        try {
            PositionJob jobDetail = positionJobService.findByPositionAndAndJob(position, job);
            if (jobDetail == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            return ResponseEntity.status(HttpStatus.OK).body(jobDetail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
