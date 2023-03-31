package com.rjsj.pethospital.service;

import com.rjsj.pethospital.entity.Record;

import java.util.List;
import java.util.Optional;

public interface RecordService {
    List<Record> findAll();

    List<String> findAllByName(String name);

    Optional<Record> findById(Long id);

    Record findByName(String name);

    Record save(Record hospitalDrug);

    void deleteById(Long id);

    void deleteByName(String name);

}
