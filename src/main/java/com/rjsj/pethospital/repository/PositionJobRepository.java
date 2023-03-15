package com.rjsj.pethospital.repository;

import com.rjsj.pethospital.entity.Case;
import com.rjsj.pethospital.entity.PositionJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PositionJobRepository extends JpaRepository<PositionJob, Long> {

    @Query("select distinct p.position from PositionJob p")
    List<String> getAllPosition();

    List<PositionJob> findAllByPosition(String position);

    Optional<PositionJob> findByPositionAndAndJob(String position, String job);
}
