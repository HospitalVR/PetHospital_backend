package com.rjsj.pethospital.repository;

import com.rjsj.pethospital.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface RecordRepository extends JpaRepository<Record, Long> {
    Record findByName(String name);


    @Transactional
    void deleteByName(String name);

    List<Record> findAllByNameContains(String name);

}
