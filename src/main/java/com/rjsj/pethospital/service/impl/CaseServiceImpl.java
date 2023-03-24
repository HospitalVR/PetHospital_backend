package com.rjsj.pethospital.service.impl;

import com.rjsj.pethospital.entity.Case;
import com.rjsj.pethospital.entity.CaseType;
import com.rjsj.pethospital.entity.FullCase;
import com.rjsj.pethospital.repository.CaseRepository;
import com.rjsj.pethospital.repository.CaseTypeRepository;
import com.rjsj.pethospital.service.CaseService;
import com.rjsj.pethospital.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
public class CaseServiceImpl implements CaseService {

    @Autowired
    CaseRepository caseRepository;

    @Autowired
    CaseTypeRepository caseTypeRepository;

    @Override
    public List<Case> findAll() {
        return caseRepository.findAll();
    }

    @Override
    public Map<String, List<String>> findAllByType() {
        List<CaseType> caseTypes = caseTypeRepository.findAll();
        Map map = new HashMap<String, List<String>>();
        for (CaseType caseType : caseTypes) {
            List<Case> cases = caseRepository.findAllByType(caseType.getType());
            List<String> list = new ArrayList<>();
            for (Case hospitalCase : cases)
                list.add(hospitalCase.getName1());
            map.put(caseType.getType(), list);
        }
        return map;
    }

    @Override
    public List<String> findAllByName(String name) {
        List<Case> cases = caseRepository.findAllByName1Contains(name);
        List<String> casesName = new ArrayList<>();
        for (Case hospitalCase : cases)
            casesName.add(hospitalCase.getName1());
        return casesName;
    }

    @Override
    public Optional<Case> findById(Long id) {
        return caseRepository.findById(id);
    }

    @Override
    public Case findByName(String name) {
        return caseRepository.findByName1(name);
    }

    @Override
    public Case save(Case hospitalCase) {
        Case caseExist = caseRepository.findByName1(hospitalCase.getName1());
        if (caseExist != null) {
            hospitalCase.setId(caseExist.getId());
        }
        return caseRepository.save(hospitalCase);
    }

    @Override
    public FullCase save(HttpServletRequest request) {
        Case hospitalCase = new Case();
        hospitalCase.setType(request.getParameter("type"));
        hospitalCase.setName1(request.getParameter("name1"));
        hospitalCase.setTreat1(request.getParameter("treat1"));
        hospitalCase.setCheck1(request.getParameter("check1"));
        hospitalCase.setResult1(request.getParameter("result1"));
        hospitalCase.setPlan1(request.getParameter("plan1"));

        MultipartHttpServletRequest files = (MultipartHttpServletRequest) request;
        hospitalCase.setName2(FileUtil.saveFile("case-" + hospitalCase.getName1() + "-1", files.getFile("name2")));
        hospitalCase.setName3(FileUtil.saveFile("case-" + hospitalCase.getName1() + "-1", files.getFile("name3")));

        hospitalCase.setTreat2(FileUtil.saveFile("case-" + hospitalCase.getName1() + "-2", files.getFile("treat2")));
        hospitalCase.setTreat3(FileUtil.saveFile("case-" + hospitalCase.getName1() + "-2", files.getFile("treat3")));

        hospitalCase.setCheck2(FileUtil.saveFile("case-" + hospitalCase.getName1() + "-3", files.getFile("check2")));
        hospitalCase.setCheck3(FileUtil.saveFile("case-" + hospitalCase.getName1() + "-3", files.getFile("check3")));

        hospitalCase.setResult2(FileUtil.saveFile("case-" + hospitalCase.getName1() + "-4", files.getFile("result2")));
        hospitalCase.setResult3(FileUtil.saveFile("case-" + hospitalCase.getName1() + "-4", files.getFile("result3")));

        hospitalCase.setPlan2(FileUtil.saveFile("case-" + hospitalCase.getName1() + "-5", files.getFile("plan2")));
        hospitalCase.setPlan3(FileUtil.saveFile("case-" + hospitalCase.getName1() + "-5", files.getFile("plan3")));

        Case saveCase = save(hospitalCase);
        return new FullCase(saveCase);
    }

    @Override
    public void deleteById(Long id) {
        caseRepository.deleteById(id);
    }

    @Override
    public void deleteByName(String name) {
        caseRepository.deleteByName1(name);
    }
}
