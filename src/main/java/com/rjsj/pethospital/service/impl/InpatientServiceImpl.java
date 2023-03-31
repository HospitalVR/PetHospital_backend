package com.rjsj.pethospital.service.impl;


import com.rjsj.pethospital.entity.Inpatient;

import com.rjsj.pethospital.repository.InpatientRepository;
import com.rjsj.pethospital.service.InpatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InpatientServiceImpl implements InpatientService {
    @Autowired
    InpatientRepository inpatientRepository;

    @Override
    public List<Inpatient> findAll() {
        return inpatientRepository.findAll();
    }

    @Override
    public List<String> findAllByName(String name) {
        List<Inpatient> inpatients = inpatientRepository.findAllByNameContains(name);
        List<String> inpatientName = new ArrayList<>();
        for(Inpatient inpatient: inpatients){
            inpatientName.add(inpatient.getName());
        }
        return inpatientName;
    }

    @Override
    public Optional<Inpatient> findById(Long id) {
        return inpatientRepository.findById(id);
    }

    @Override
    public Inpatient findByName(String name) {
        return inpatientRepository.findByName(name);
    }

    @Override
    public Inpatient save(Inpatient hospitalInpatient) {
        Inpatient existInpatient = inpatientRepository.findByName(hospitalInpatient.getName());
        if(existInpatient != null){
            hospitalInpatient.setId(existInpatient.getId());
        }
        return inpatientRepository.save(hospitalInpatient);
    }

    @Override
    public void deleteById(Long id) {
        inpatientRepository.deleteById(id);
    }

    @Override
    public void deleteByName(String name) {
        inpatientRepository.deleteByName(name);
    }
}
