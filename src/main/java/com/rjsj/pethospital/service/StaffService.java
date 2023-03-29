package com.rjsj.pethospital.service;

import com.rjsj.pethospital.entity.Staff;

import java.util.List;
import java.util.Optional;

public interface StaffService {
    List<Staff> findAll();

    List<String> findAllByPosition(String position);

    Optional<Staff> findById(Long id);

    Staff findByIdnumber(String Idnumber);

    Staff findByName(String name);

    Staff save(Staff hospitalStaff);

    void deleteById(Long id);

    void deleteByName(String name);

}
