package com.rjsj.pethospital.repository;

import com.rjsj.pethospital.entity.Drug;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrugRepository extends JpaRepository<Drug, Long> {

    Drug findByName(String name);

    void deleteByName(String name);

    List<Drug> findAllByNameContains(String name);
}
