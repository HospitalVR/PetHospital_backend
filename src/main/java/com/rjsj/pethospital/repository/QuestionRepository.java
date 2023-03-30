package com.rjsj.pethospital.repository;

import com.rjsj.pethospital.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface QuestionRepository extends JpaRepository<Question, Long>{
    List<Question> findAllByType(String type);

    Question findByContent(String content);

}
