package com.rjsj.pethospital.repository;

import com.rjsj.pethospital.entity.Case;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CaseRepository extends JpaRepository<Case, Long> {

    List<Case> findCasesByType(String type);

}
