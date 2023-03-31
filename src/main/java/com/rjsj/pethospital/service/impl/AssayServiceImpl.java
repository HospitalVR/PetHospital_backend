package com.rjsj.pethospital.service.impl;

import com.rjsj.pethospital.entity.Assay;
import com.rjsj.pethospital.repository.AssayRepository;
import com.rjsj.pethospital.service.AssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class AssayServiceImpl implements AssayService {
    @Autowired
    AssayRepository assayRepository;

    @Override
    public List<Assay> findAll() {
        return assayRepository.findAll();
    }

    @Override
    public List<String> findAllByName(String name) {
        List<Assay> assays = assayRepository.findAllByNameContains(name);
        List<String> assayName = new ArrayList<>();
        for(Assay assay: assays){
            assayName.add(assay.getName());
        }
        return assayName;
    }

    @Override
    public Optional<Assay> findById(Long id) {
        return assayRepository.findById(id);
    }

    @Override
    public Assay findByName(String name) {
        return assayRepository.findByName(name);
    }

    @Override
    public Assay save(Assay hospitalAssay) {
        Assay existAssay = assayRepository.findByName(hospitalAssay.getName());
        if(existAssay != null){
            hospitalAssay.setId(existAssay.getId());
        }
        return assayRepository.save(hospitalAssay);
    }

    @Override
    public void deleteById(Long id) {
        assayRepository.deleteById(id);
    }

    @Override
    public void deleteByName(String name) {
        assayRepository.deleteByName(name);
    }
}
