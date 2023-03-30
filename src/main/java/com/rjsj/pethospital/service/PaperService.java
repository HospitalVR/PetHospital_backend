package com.rjsj.pethospital.service;

import com.rjsj.pethospital.entity.Paper;

import java.util.List;
import java.util.Optional;

public interface PaperService {
    List<Paper> findAll();
    Optional<Paper> findById(Long id);

    Paper addQuestion( Paper paper, List<Long> questions_id);

    Paper deleteQuestion(Paper paper, List<Long> questions_id);

    Paper save(Paper paper);
    void deleteById(Long id);
}
