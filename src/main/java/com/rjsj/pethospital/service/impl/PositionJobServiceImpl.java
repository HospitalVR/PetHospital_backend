package com.rjsj.pethospital.service.impl;

import com.rjsj.pethospital.entity.PositionJob;
import com.rjsj.pethospital.repository.PositionJobRepository;
import com.rjsj.pethospital.service.PositionJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PositionJobServiceImpl implements PositionJobService {

    @Autowired
    PositionJobRepository positionJobRepository;


    @Override
    public List<String> getAllPosition() {
        return positionJobRepository.getAllPosition();
    }

    @Override
    public List<String> findAllByPosition(String position) {
        List<PositionJob> all = positionJobRepository.findAllByPosition(position);
        List<String> jobs = new ArrayList<>();
        all.forEach(p -> jobs.add(p.getJob()));
        return jobs;
    }

    @Override
    public PositionJob findByPositionAndAndJob(String position, String job) {
        return positionJobRepository.findByPositionAndAndJob(position,job).orElse(null);
    }
}
