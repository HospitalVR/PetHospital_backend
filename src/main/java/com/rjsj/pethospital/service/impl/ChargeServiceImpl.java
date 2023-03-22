package com.rjsj.pethospital.service.impl;

import com.rjsj.pethospital.entity.Charge;
import com.rjsj.pethospital.repository.ChargeRepository;
import com.rjsj.pethospital.service.ChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChargeServiceImpl implements ChargeService {

    @Autowired
    ChargeRepository chargeRepository;

    @Override
    public List<Charge> findAll() {return chargeRepository.findAll();}

    @Override
    public List<String> findAllByName(String name) {
        List<Charge> charges = chargeRepository.findAllByNameContains(name);
        List<String> chargeName = new ArrayList<>();
        for(Charge charge:charges)
            chargeName.add(charge.getName());
        return chargeName;
    }

    @Override
    public Charge save(Charge charge) {
        Charge existCharge = chargeRepository.findByName(charge.getName());
        if(existCharge!=null)
            charge.setId(existCharge.getId());
        return chargeRepository.save(charge);
    }

    @Override
    public void deleteById(Long id) { chargeRepository.deleteById(id);}

    @Override
    public void deleteByName(String name) {chargeRepository.deleteByName(name);}
}
