package com.rjsj.pethospital.controller;

import com.rjsj.pethospital.entity.Staff;
import com.rjsj.pethospital.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("staff")
public class StaffController {
    @Autowired
    StaffService staffService;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseEntity<List<Staff>> findAll(){
        try {
            List<Staff> staffs = staffService.findAll();
            if(staffs.isEmpty())
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            return ResponseEntity.status(HttpStatus.OK).body(staffs);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/findAllByPosition", method = RequestMethod.GET)
    public ResponseEntity<List<String>> findAllByPosition(String position) {
        try {
            List<String> staffsName = staffService.findAllByPosition(position);
            return ResponseEntity.status(HttpStatus.OK).body(staffsName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public ResponseEntity<Staff> findById(Long id) {
        try {
            Staff staff = staffService.findById(id).orElse(null);
            if (staff == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

            return ResponseEntity.status(HttpStatus.OK).body(staff);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/findByName", method = RequestMethod.GET)
    public ResponseEntity<Staff> findByName(String name) {
        try {
            Staff staff = staffService.findByName(name);
            if (staff == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

            return ResponseEntity.status(HttpStatus.OK).body(staff);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/findByIdnumber", method = RequestMethod.GET)
    public ResponseEntity<Staff> findByIdnumber(String idnumber) {
        try {
            Staff staff = staffService.findByIdnumber(idnumber);
            if (staff == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

            return ResponseEntity.status(HttpStatus.OK).body(staff);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Staff> save(HttpServletRequest request) {
        Staff staff = new Staff();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        staff.setName(request.getParameter("name"));
        staff.setAge(Integer.parseInt(request.getParameter("age")));
        staff.setGender(request.getParameter("gender"));
        staff.setPosition(request.getParameter("position"));
        staff.setExperience(Integer.parseInt(request.getParameter("experience")));
        staff.setPhone(request.getParameter("phone"));
        staff.setIdnumber(request.getParameter("idnumber"));
        try {
            staff.setDate(sdf.parse(request.getParameter("date")));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        staff.setPlace(request.getParameter("place"));
        staff.setEdu(request.getParameter("edu"));

        Staff saveStaff = staffService.save(staff);
        return ResponseEntity.status(HttpStatus.OK).body(saveStaff);
    }
    @RequestMapping(value = "/deleteById", method = RequestMethod.GET)
    public ResponseEntity<Void> deleteById(Long id) {
        staffService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(value = "/deleteByName", method = RequestMethod.GET)
    public ResponseEntity<Void> deleteByName(String name) {
        staffService.deleteByName(name);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
