package com.rjsj.pethospital.controller;

import com.rjsj.pethospital.entity.Case;
import com.rjsj.pethospital.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("case")
public class CaseController {

    @Autowired
    private CaseService caseService;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseEntity<List<Case>> findAll() {
        try {
            List<Case> cases = caseService.findAll();
            if (cases.isEmpty())
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            return ResponseEntity.status(HttpStatus.OK).body(cases);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/findAllByType", method = RequestMethod.GET)
    public ResponseEntity<Map<String, List<String>>> findAllCaseByType() {
        try {
            Map<String, List<String>> map = caseService.findAllByType();
            if (map.isEmpty())
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            return ResponseEntity.status(HttpStatus.OK).body(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/findAllByName", method = RequestMethod.GET)
    public ResponseEntity<List<String>> findAllByName(String name) {
        try {
            List<String> casesName = caseService.findAllByName(name);
            return ResponseEntity.status(HttpStatus.OK).body(casesName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public ResponseEntity<Case> findById(Long id) {
        try {
            Case hospitalCase = caseService.findById(id).orElse(null);
            if (hospitalCase == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

            return ResponseEntity.status(HttpStatus.OK).body(hospitalCase);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/findByName", method = RequestMethod.GET)
    public ResponseEntity<Case> findByName(String name) {
        try {
            Case hospitalCase = caseService.findByName(name);
            if (hospitalCase == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

            return ResponseEntity.status(HttpStatus.OK).body(hospitalCase);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Case> save(@RequestBody Case hospitalCase) {
        return ResponseEntity.status(HttpStatus.OK).body(caseService.save(hospitalCase));
    }

    @RequestMapping(value = "/deleteById", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteById(Long id) {
        caseService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(value = "/deleteByName", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteByName(String name) {
        caseService.deleteByName(name);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
