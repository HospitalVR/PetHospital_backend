package com.rjsj.pethospital.service.impl;

import com.rjsj.pethospital.entity.Case;
import com.rjsj.pethospital.repository.CaseRepository;
import com.rjsj.pethospital.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaseServiceImpl implements CaseService {

    @Autowired
    CaseRepository caseRepository;

    @Override
    public List<Case> findAll() {
        return caseRepository.findAll();
    }

    @Override
    public List<Case> findCasesByType(String type) {
        return caseRepository.findCasesByType(type);
    }

    @Override
    public Optional<Case> findById(Long id) {
        return caseRepository.findById(id);
    }

    @Override
    public Case save(Case hospitalCase) {
        return caseRepository.save(hospitalCase);
    }

    @Override
    public void deleteById(Long id) {
        caseRepository.deleteById(id);
    }
}
