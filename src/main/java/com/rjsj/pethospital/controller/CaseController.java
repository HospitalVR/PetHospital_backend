package com.rjsj.pethospital.controller;

import com.rjsj.pethospital.entity.Case;
import com.rjsj.pethospital.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("case")
public class CaseController {

    @Autowired
    private CaseService caseService;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<Case> findAll() {
        return caseService.findAll();
    }

    @RequestMapping(value = "/findCasesByType", method = RequestMethod.GET)
    public List<Case> findCasesByType(String type) {
        return caseService.findCasesByType(type);
    }

    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public Case findById(Long id) {
        return caseService.findById(id).orElse(new Case());
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Case save(@RequestBody Case hospitalCase) {
        return caseService.save(hospitalCase);
    }

    @RequestMapping(value = "/deleteById", method = RequestMethod.DELETE)
    public void deleteById(Long id) {
        caseService.deleteById(id);
    }
}
