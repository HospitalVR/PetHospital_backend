package com.rjsj.pethospital.repository;

import com.rjsj.pethospital.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
    Department findByName(String name);


    @Transactional
    void deleteByName(String name);

    List<Department> findAllByNameContains(String name);
}
