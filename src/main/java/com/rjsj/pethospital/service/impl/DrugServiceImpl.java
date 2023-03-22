package com.rjsj.pethospital.service.impl;

import com.rjsj.pethospital.entity.Drug;
import com.rjsj.pethospital.repository.DrugRepository;
import com.rjsj.pethospital.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DrugServiceImpl implements DrugService {

    @Autowired
    DrugRepository drugRepository;

    @Override
    public List<Drug> findAll() {
        return drugRepository.findAll();
    }

    @Override
    public List<String> findAllByName(String name) {
        List<Drug> drugs = drugRepository.findAllByNameContains(name);
        List<String> drugName = new ArrayList<>();
        for(Drug drug: drugs){
            drugName.add(drug.getName());
        }
        return drugName;
    }

    @Override
    public Optional<Drug> findById(Long id) {
        return drugRepository.findById(id);
    }

    @Override
    public Drug findByName(String name) {
        return drugRepository.findByName(name);
    }

    @Override
    public Drug save(Drug hospitalDrug) {
        Drug existDrug = drugRepository.findByName(hospitalDrug.getName());
        if(existDrug != null){
            hospitalDrug.setId(existDrug.getId());
        }
        return drugRepository.save(hospitalDrug);
    }

    @Override
    public void deleteById(Long id) {
        drugRepository.deleteById(id);
    }

    @Override
    public void deleteByName(String name) {
        drugRepository.deleteByName(name);
    }
}
