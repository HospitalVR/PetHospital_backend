package com.rjsj.pethospital.repository;


import com.rjsj.pethospital.entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VaccineRepository extends JpaRepository<Vaccine,Long> {
    Vaccine findByName(String name);

    void deleteByName(String name);


    List<Vaccine> findAllByNameContains(String name);

}
