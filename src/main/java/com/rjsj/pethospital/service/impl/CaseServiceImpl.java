package com.rjsj.pethospital.service.impl;

import com.rjsj.pethospital.entity.Case;
import com.rjsj.pethospital.entity.CaseType;
import com.rjsj.pethospital.repository.CaseRepository;
import com.rjsj.pethospital.repository.CaseTypeRepository;
import com.rjsj.pethospital.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            List<Case> cases = caseRepository.findAllByType(caseType.getId());
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
    public void deleteById(Long id) {
        caseRepository.deleteById(id);
    }

    @Override
    public void deleteByName(String name) {
        caseRepository.deleteByName1(name);
    }
}
