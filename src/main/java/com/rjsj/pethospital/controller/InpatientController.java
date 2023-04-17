package com.rjsj.pethospital.controller;

import com.rjsj.pethospital.entity.Inpatient;
import com.rjsj.pethospital.service.InpatientService;
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
@RequestMapping("inpatient")
public class InpatientController {
    @Autowired
    private InpatientService inpatientService;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseEntity<List<Inpatient>> findAll(){
        try {
            List<Inpatient> inpatients = inpatientService.findAll();
            if(inpatients.isEmpty())
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            return ResponseEntity.status(HttpStatus.OK).body(inpatients);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/findAllByName", method = RequestMethod.GET)
    public ResponseEntity<List<String>> findAllByName(String name) {
        try {
            List<String> inpatientsName = inpatientService.findAllByName(name);
            return ResponseEntity.status(HttpStatus.OK).body(inpatientsName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/findAllByReason", method = RequestMethod.GET)
    public ResponseEntity<List<Inpatient>> findAllByReason(String reason) {
        try {
            List<Inpatient> inpatientsName = inpatientService.findAllByReason(reason);
            return ResponseEntity.status(HttpStatus.OK).body(inpatientsName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public ResponseEntity<Inpatient> findById(Long id) {
        try {
            Inpatient inpatient = inpatientService.findById(id).orElse(null);
            if (inpatient == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

            return ResponseEntity.status(HttpStatus.OK).body(inpatient);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/findByName", method = RequestMethod.GET)
    public ResponseEntity<Inpatient> findByName(String name) {
        try {
            Inpatient inpatient = inpatientService.findByName(name);
            if (inpatient == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

            return ResponseEntity.status(HttpStatus.OK).body(inpatient);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Inpatient> save(HttpServletRequest request) {
        Inpatient inpatient = new Inpatient();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        inpatient.setName(request.getParameter("name"));
        inpatient.setBreed(request.getParameter("breed"));
        inpatient.setOwner(request.getParameter("owner"));
        inpatient.setPhone(request.getParameter("phone"));
        inpatient.setReason(request.getParameter("reason"));
        try {
            inpatient.setAdmission(sdf.parse(request.getParameter("admission")));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        try {
            inpatient.setDischarge(sdf.parse(request.getParameter("discharge")));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        inpatient.setDay(Long.parseLong(request.getParameter("day")));
        inpatient.setCost(Double.parseDouble(request.getParameter("cost")));

        Inpatient saveInpatient = inpatientService.save(inpatient);
        return ResponseEntity.status(HttpStatus.OK).body(saveInpatient);
    }

    @RequestMapping(value = "/deleteById", method = RequestMethod.GET)
    public ResponseEntity<Void> deleteById(Long id) {
        inpatientService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(value = "/deleteByName", method = RequestMethod.GET)
    public ResponseEntity<Void> deleteByName(String name) {
        inpatientService.deleteByName(name);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
