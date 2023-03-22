package com.rjsj.pethospital.repository;

import com.rjsj.pethospital.entity.Charge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChargeRepository extends JpaRepository<Charge, Long> {

    Charge findByName(String name);

    void deleteByName(String name);

    List<Charge> findAllByNameContains(String name);


}
