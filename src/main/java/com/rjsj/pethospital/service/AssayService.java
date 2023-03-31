package com.rjsj.pethospital.service;

import com.rjsj.pethospital.entity.Assay;

import java.util.List;
import java.util.Optional;

public interface AssayService {
    List<Assay> findAll();

    List<String> findAllByName(String name);

    Optional<Assay> findById(Long id);

    Assay findByName(String name);

    Assay save(Assay hospitalAssay);

    void deleteById(Long id);

    void deleteByName(String name);
}
