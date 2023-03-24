package com.rjsj.pethospital.service;

import com.rjsj.pethospital.entity.Case;
import com.rjsj.pethospital.entity.FullCase;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CaseService {

    List<Case> findAll();

    Map<String,List<String>> findAllByType();

    List<String> findAllByName(String name);

    Optional<Case> findById(Long id);

    Case findByName(String name);

    Case save(Case hospitalCase);

    FullCase save(HttpServletRequest request);

    void deleteById(Long id);

    void deleteByName(String name);
}
