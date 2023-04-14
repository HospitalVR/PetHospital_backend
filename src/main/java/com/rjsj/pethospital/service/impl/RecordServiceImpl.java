package com.rjsj.pethospital.service.impl;

import com.rjsj.pethospital.entity.Record;
import com.rjsj.pethospital.repository.RecordRepository;
import com.rjsj.pethospital.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    RecordRepository recordRepository;

    @Override
    public List<Record> findAll() {
        return recordRepository.findAll();
    }

    @Override
    public List<String> findAllByName(String name) {
        List<Record> records = recordRepository.findAllByNameContains(name);
        List<String> recordName = new ArrayList<>();
        for(Record record: records){
            recordName.add(record.getName());
        }
        return recordName;
    }

    @Override
    public List<Record> findAllByDisease(String disease){ return recordRepository.findAllByDiseaseContains(disease); }

    @Override
    public Optional<Record> findById(Long id) {
        return recordRepository.findById(id);
    }

    @Override
    public Record findByName(String name) {
        return recordRepository.findByName(name);
    }

    @Override
    public Record save(Record hospitalRecord) {
        Record existRecord = recordRepository.findByName(hospitalRecord.getName());
        if(existRecord != null){
            hospitalRecord.setId(existRecord.getId());
        }
        return recordRepository.save(hospitalRecord);
    }

    @Override
    public void deleteById(Long id) {
        recordRepository.deleteById(id);
    }

    @Override
    public void deleteByName(String name) {
        recordRepository.deleteByName(name);
    }

}
