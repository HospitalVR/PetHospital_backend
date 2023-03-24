package com.rjsj.pethospital.service.impl;

import com.rjsj.pethospital.entity.Vaccine;
import com.rjsj.pethospital.repository.VaccineRepository;
import com.rjsj.pethospital.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VaccineServiceImpl implements VaccineService {

    @Autowired
    VaccineRepository vaccineRepository;

    @Override
    public List<Vaccine> findAll() {return vaccineRepository.findAll();}


    @Override
    public List<String> findAllByName(String name) {
        List<Vaccine> vaccines = vaccineRepository.findAllByNameContains(name);
        List<String> vaccineName = new ArrayList<>();
        for(Vaccine vaccine : vaccines)
            vaccineName.add(vaccine.getName());
        return vaccineName;
    }

    @Override
    public Optional<Vaccine> findById(Long id) { return vaccineRepository.findById(id); }

    @Override
    public Vaccine findByName(String name) {
        return vaccineRepository.findByName(name);
    }

    @Override
    public Vaccine save(Vaccine hospitalVaccine) {
        Vaccine existVaccine = vaccineRepository.findByName(hospitalVaccine.getName());
        if(existVaccine!=null)
            hospitalVaccine.setId(existVaccine.getId());
        return vaccineRepository.save(hospitalVaccine);
    }

    @Override
    public void deleteById(Long id) {
        vaccineRepository.deleteById(id);
    }

    @Override
    public void deleteByName(String name) {
        vaccineRepository.deleteByName(name);
    }
}
