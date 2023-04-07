package com.rjsj.pethospital.service.impl;

import com.rjsj.pethospital.entity.Department;
import com.rjsj.pethospital.repository.DepartmentRepository;
import com.rjsj.pethospital.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public List<String> findAllByName(String name) {
        List<Department> departments = departmentRepository.findAllByNameContains(name);
        List<String> departmentName = new ArrayList<>();
        for(Department department: departments){
            departmentName.add(department.getName());
        }
        return departmentName;
    }

    @Override
    public Optional<Department> findById(Long id) {
        return departmentRepository.findById(id);
    }

    @Override
    public Department findByName(String name) {
        return departmentRepository.findByName(name);
    }

    @Override
    public Department save(Department hospitalDepartment) {
        Department existDepartment = departmentRepository.findByName(hospitalDepartment.getName());
        if(existDepartment != null){
            hospitalDepartment.setId(existDepartment.getId());
        }
        return departmentRepository.save(hospitalDepartment);
    }

    @Override
    public void deleteById(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public void deleteByName(String name) {
        departmentRepository.deleteByName(name);
    }
}
