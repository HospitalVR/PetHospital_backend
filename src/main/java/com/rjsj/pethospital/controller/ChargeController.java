package com.rjsj.pethospital.controller;


import com.rjsj.pethospital.entity.Charge;
import com.rjsj.pethospital.entity.Charge;
import com.rjsj.pethospital.service.ChargeService;
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
@RequestMapping("charge")
public class ChargeController {

    @Autowired
    private ChargeService chargeService;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseEntity<List<Charge>> findAll(){
        try {
            List<Charge> charges = chargeService.findAll();
            if(charges.isEmpty())
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            return ResponseEntity.status(HttpStatus.OK).body(charges);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/findAllByName", method = RequestMethod.GET)
    public ResponseEntity<List<String>> findAllByName(String name) {
        try {
            List<String> casesName = chargeService.findAllByName(name);
            return ResponseEntity.status(HttpStatus.OK).body(casesName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Charge> save(HttpServletRequest request) {
        Charge charge = new Charge();
        charge.setName(request.getParameter("name"));
        charge.setPrice(Double.parseDouble(request.getParameter("price")));
        charge.setDescription(request.getParameter("description"));
        Charge saveCharge = chargeService.save(charge);
        return ResponseEntity.status(HttpStatus.OK).body(saveCharge);
    }

    @RequestMapping(value = "/deleteById", method = RequestMethod.GET)
    public ResponseEntity<Void> deleteById(Long id) {
        chargeService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(value = "/deleteByName", method = RequestMethod.GET)
    public ResponseEntity<Void> deleteByName(String name) {
        chargeService.deleteByName(name);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
