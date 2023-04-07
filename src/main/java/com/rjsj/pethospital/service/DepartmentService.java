package com.rjsj.pethospital.service;

import com.rjsj.pethospital.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    List<Department> findAll();

    List<String> findAllByName(String name);

    Optional<Department> findById(Long id);

    Department findByName(String name);

    Department save(Department hospitalDepartment);

    void deleteById(Long id);

    void deleteByName(String name);
}
