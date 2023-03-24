package com.rjsj.pethospital.service;


import com.rjsj.pethospital.entity.Vaccine;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface VaccineService {
    List<Vaccine> findAll();

    List<String> findAllByName(String name);

    Optional<Vaccine> findById(Long id);

    Vaccine findByName(String name);

    Vaccine save(Vaccine hospitalVaccine);

    void deleteById(Long id);

    void deleteByName(String name);
}
