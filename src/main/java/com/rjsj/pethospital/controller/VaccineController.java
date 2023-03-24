package com.rjsj.pethospital.controller;

import com.rjsj.pethospital.entity.Vaccine;
import com.rjsj.pethospital.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("vaccine")
public class VaccineController {

    @Autowired
    VaccineService vaccineService;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseEntity<List<Vaccine>> findAll(){
        try {
            List<Vaccine> vaccines = vaccineService.findAll();
            if(vaccines.isEmpty())
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            return ResponseEntity.status(HttpStatus.OK).body(vaccines);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/findAllByName", method = RequestMethod.GET)
    public ResponseEntity<List<String>> findAllByName(String name) {
        try {
            List<String> vaccinesName = vaccineService.findAllByName(name);
            return ResponseEntity.status(HttpStatus.OK).body(vaccinesName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public ResponseEntity<Vaccine> findById(Long id) {
        try {
            Vaccine hospitalVaccine = vaccineService.findById(id).orElse(null);
            return ResponseEntity.status(HttpStatus.OK).body(hospitalVaccine);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/findByName", method = RequestMethod.GET)
    public ResponseEntity<Vaccine> findByName(String name) {
        try {
            Vaccine hospitalVaccine = vaccineService.findByName(name);
            if (hospitalVaccine == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            return ResponseEntity.status(HttpStatus.OK).body(hospitalVaccine);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Vaccine> save(HttpServletRequest request){
        Vaccine vaccine = new Vaccine();
        vaccine.setName(request.getParameter("name"));
        vaccine.setAnimal(request.getParameter("animal"));
        vaccine.setType(request.getParameter("type"));
        vaccine.setMethod(request.getParameter("method"));
        vaccine.setTime(request.getParameter("time"));
        vaccine.setProtection(request.getParameter("protection"));
        vaccine.setSide_effects(request.getParameter("side_effects"));
        Vaccine saveVaccine = vaccineService.save(vaccine);
        return ResponseEntity.status(HttpStatus.OK).body(saveVaccine);
    }

    @RequestMapping(value = "/deleteById", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteById(Long id) {
        vaccineService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(value = "/deleteByName", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteByName(String name) {
        vaccineService.deleteByName(name);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
