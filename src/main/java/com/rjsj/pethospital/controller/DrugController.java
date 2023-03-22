package com.rjsj.pethospital.controller;

import com.rjsj.pethospital.entity.Drug;
import com.rjsj.pethospital.entity.FullCase;
import com.rjsj.pethospital.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("drug")
public class DrugController {

    @Autowired
    private DrugService drugService;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseEntity<List<Drug>> findAll(){
        try {
            List<Drug> drugs = drugService.findAll();
            if(drugs.isEmpty())
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            return ResponseEntity.status(HttpStatus.OK).body(drugs);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/findAllByName", method = RequestMethod.GET)
    public ResponseEntity<List<String>> findAllByName(String name) {
        try {
            List<String> casesName = drugService.findAllByName(name);
            return ResponseEntity.status(HttpStatus.OK).body(casesName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public ResponseEntity<Drug> findById(Long id) {
        try {
            Drug drug = drugService.findById(id).orElse(null);
            if (drug == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

            return ResponseEntity.status(HttpStatus.OK).body(drug);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/findByName", method = RequestMethod.GET)
    public ResponseEntity<Drug> findByName(String name) {
        try {
            Drug drug = drugService.findByName(name);
            if (drug == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

            return ResponseEntity.status(HttpStatus.OK).body(drug);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Drug> save(HttpServletRequest request) {
        Drug drug = new Drug();
        drug.setName(request.getParameter("name"));
        drug.setPrice(Double.parseDouble(request.getParameter("price")));
        drug.setDescription(request.getParameter("description"));
        Drug saveDrug = drugService.save(drug);
        return ResponseEntity.status(HttpStatus.OK).body(saveDrug);
    }

    @RequestMapping(value = "/deleteById", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteById(Long id) {
        drugService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(value = "/deleteByName", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteByName(String name) {
        drugService.deleteByName(name);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
