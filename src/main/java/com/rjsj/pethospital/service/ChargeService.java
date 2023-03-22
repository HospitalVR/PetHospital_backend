package com.rjsj.pethospital.service;

import com.rjsj.pethospital.entity.Charge;


import java.util.List;

public interface ChargeService {

    List<Charge> findAll();

    List<String> findAllByName(String name);

    Charge save(Charge charge);

    void deleteById(Long id);

    void deleteByName(String name);
}
