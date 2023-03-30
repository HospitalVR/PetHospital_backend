package com.rjsj.pethospital.service;

import com.rjsj.pethospital.entity.Paper;
import com.rjsj.pethospital.entity.Test;

import java.util.List;
import java.util.Optional;

public interface TestService {
    List<Test> findAll();

    Optional<Test> findById(Long id);

    Test addTest(Test test,Paper paper, List<Long> user_id);

    Test deleteTestPaper(Test test);

    Test deleteTestStudent(Test test, List<Long> user_id);

    Test save(Test test);

    void deleteById(Long id);
}
