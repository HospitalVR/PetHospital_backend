package com.rjsj.pethospital.repository;


import com.rjsj.pethospital.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface StaffRepository extends JpaRepository<Staff, Long> {

    Staff findByName(String name);

    @Transactional
    void deleteByName(String name);

    Staff findByIdnumber(String idnumber);

    List<Staff> findAllByPositionContains(String position);
}
