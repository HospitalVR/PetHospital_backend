package com.rjsj.pethospital.service;

import com.rjsj.pethospital.entity.PositionJob;

import java.util.List;

public interface PositionJobService {

    List<String> getAllPosition();

    List<String> findAllByPosition(String position);

    PositionJob findByPositionAndAndJob(String position, String job);

}
