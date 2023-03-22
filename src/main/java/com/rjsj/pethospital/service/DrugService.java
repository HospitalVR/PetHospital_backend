package com.rjsj.pethospital.service;

import com.rjsj.pethospital.entity.Drug;

import java.util.List;
import java.util.Optional;

public interface DrugService {
    List<Drug> findAll();

    List<String> findAllByName(String name);

    Optional<Drug> findById(Long id);

    Drug findByName(String name);

    Drug save(Drug hospitalDrug);

    void deleteById(Long id);

    void deleteByName(String name);
}
