package com.rjsj.pethospital.service;

import com.rjsj.pethospital.entity.Case;

import java.util.List;
import java.util.Optional;

public interface CaseService {

    List<Case> findAll();

    List<Case> findCasesByType(String type);

    Optional<Case> findById(Long id);

    Case save(Case hospitalCase);

    void deleteById(Long id);
}
