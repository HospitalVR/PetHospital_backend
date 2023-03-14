package com.rjsj.pethospital.controller;

import com.rjsj.pethospital.entity.Case;
import com.rjsj.pethospital.entity.FullCase;
import com.rjsj.pethospital.service.CaseService;
import com.rjsj.pethospital.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("case")
public class CaseController {

    @Autowired
    private CaseService caseService;

    @Autowired
    private FileService fileService;

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
    public ResponseEntity<FullCase> findByName(String name) {
        try {
            Case hospitalCase = caseService.findByName(name);
            if (hospitalCase == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

            return ResponseEntity.status(HttpStatus.OK).body(new FullCase(hospitalCase));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<FullCase> save(HttpServletRequest request) {
        Case hospitalCase = new Case();
        hospitalCase.setType(request.getParameter("type"));
        hospitalCase.setName1(request.getParameter("name1"));
        hospitalCase.setTreat1(request.getParameter("treat1"));
        hospitalCase.setCheck1(request.getParameter("check1"));
        hospitalCase.setResult1(request.getParameter("result1"));
        hospitalCase.setPlan1(request.getParameter("plan1"));

        MultipartHttpServletRequest files = (MultipartHttpServletRequest) request;
        hospitalCase.setName2(fileService.saveFile("case-" + hospitalCase.getName1() + "-1", files.getFile("name2")));
        hospitalCase.setName3(fileService.saveFile("case-" + hospitalCase.getName1() + "-1", files.getFile("name3")));

        hospitalCase.setTreat2(fileService.saveFile("case-" + hospitalCase.getName1() + "-2", files.getFile("treat2")));
        hospitalCase.setTreat3(fileService.saveFile("case-" + hospitalCase.getName1() + "-2", files.getFile("treat3")));

        hospitalCase.setCheck2(fileService.saveFile("case-" + hospitalCase.getName1() + "-3", files.getFile("check2")));
        hospitalCase.setCheck3(fileService.saveFile("case-" + hospitalCase.getName1() + "-3", files.getFile("check3")));

        hospitalCase.setResult2(fileService.saveFile("case-" + hospitalCase.getName1() + "-4", files.getFile("result2")));
        hospitalCase.setResult3(fileService.saveFile("case-" + hospitalCase.getName1() + "-4", files.getFile("result3")));

        hospitalCase.setPlan2(fileService.saveFile("case-" + hospitalCase.getName1() + "-5", files.getFile("plan2")));
        hospitalCase.setPlan3(fileService.saveFile("case-" + hospitalCase.getName1() + "-5", files.getFile("plan3")));

        Case saveCase = caseService.save(hospitalCase);
        return ResponseEntity.status(HttpStatus.OK).body(new FullCase(saveCase));
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
