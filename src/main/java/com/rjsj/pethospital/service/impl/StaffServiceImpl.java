package com.rjsj.pethospital.service.impl;

import com.rjsj.pethospital.entity.Staff;
import com.rjsj.pethospital.repository.StaffRepository;
import com.rjsj.pethospital.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    StaffRepository staffRepository;

    @Override
    public List<Staff> findAll() {
        return staffRepository.findAll();
    }

    @Override
    public List<String> findAllByPosition(String position) {
        List<Staff> staffs = staffRepository.findAllByPositionContains(position);
        List<String> staffName = new ArrayList<>();
        for(Staff staff:staffs)
            staffName.add(staff.getName());
        return staffName;
    }

    @Override
    public Optional<Staff> findById(Long id) {
        return staffRepository.findById(id);
    }

    @Override
    public Staff findByIdnumber(String Idnumber) {
        return staffRepository.findByIdnumber(Idnumber);
    }

    @Override
    public Staff findByName(String name) {
        return staffRepository.findByName(name);
    }

    @Override
    public Staff save(Staff hospitalStaff) {
        Staff existStaff = staffRepository.findByIdnumber(hospitalStaff.getIdnumber());
        if(existStaff != null)
            hospitalStaff.setId(existStaff.getId());
        staffRepository.save(hospitalStaff);
        return null;
    }

    @Override
    public void deleteById(Long id) {
        staffRepository.deleteById(id);
    }

    @Override
    public void deleteByName(String name) {
        staffRepository.deleteByName(name);
    }
}
