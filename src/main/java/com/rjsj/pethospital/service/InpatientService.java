package com.rjsj.pethospital.service;

import com.rjsj.pethospital.entity.Inpatient;

import java.util.List;
import java.util.Optional;

public interface InpatientService {
    List<Inpatient> findAll();

    List<String> findAllByName(String name);

    Optional<Inpatient> findById(Long id);

    Inpatient findByName(String name);

    Inpatient save(Inpatient hospitalInpatient);

    void deleteById(Long id);

    void deleteByName(String name);
}
