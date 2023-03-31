package com.rjsj.pethospital.repository;

import com.rjsj.pethospital.entity.Assay;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface AssayRepository extends JpaRepository<Assay,Long> {
    Assay findByName(String name);


    @Transactional
    void deleteByName(String name);

    List<Assay> findAllByNameContains(String name);
}
