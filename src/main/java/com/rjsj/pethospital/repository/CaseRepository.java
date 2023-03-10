package com.rjsj.pethospital.repository;

import com.rjsj.pethospital.entity.Case;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CaseRepository extends JpaRepository<Case, Long> {

    List<Case> findAllByType(String type);

    List<Case> findAllByName1Contains(String name1);

    Case findByName1(String name1);

    void deleteByName1(String name1);
}
