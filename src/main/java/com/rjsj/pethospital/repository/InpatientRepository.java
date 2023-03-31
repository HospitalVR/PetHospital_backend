package com.rjsj.pethospital.repository;

import com.rjsj.pethospital.entity.Inpatient;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface InpatientRepository extends JpaRepository<Inpatient, Long> {

    Inpatient findByName(String name);

    @Transactional
    void deleteByName(String name);

    List<Inpatient> findAllByNameContains(String name);
}
