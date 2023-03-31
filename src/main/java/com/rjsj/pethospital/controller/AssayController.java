package com.rjsj.pethospital.controller;

import com.rjsj.pethospital.entity.Assay;
import com.rjsj.pethospital.service.AssayService;
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
@RequestMapping("assay")
public class AssayController {
    @Autowired
    private AssayService assayService;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseEntity<List<Assay>> findAll(){
        try {
            List<Assay> assays = assayService.findAll();
            if(assays.isEmpty())
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            return ResponseEntity.status(HttpStatus.OK).body(assays);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/findAllByName", method = RequestMethod.GET)
    public ResponseEntity<List<String>> findAllByName(String name) {
        try {
            List<String> assayNames = assayService.findAllByName(name);
            return ResponseEntity.status(HttpStatus.OK).body(assayNames);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public ResponseEntity<Assay> findById(Long id) {
        try {
            Assay assay = assayService.findById(id).orElse(null);
            if (assay == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

            return ResponseEntity.status(HttpStatus.OK).body(assay);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/findByName", method = RequestMethod.GET)
    public ResponseEntity<Assay> findByName(String name) {
        try {
            Assay assay = assayService.findByName(name);
            if (assay == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

            return ResponseEntity.status(HttpStatus.OK).body(assay);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Assay> save(HttpServletRequest request) {
        Assay assay = new Assay();
        assay.setName(request.getParameter("name"));
        assay.setPrice(Double.parseDouble(request.getParameter("price")));
        assay.setDescription(request.getParameter("description"));
        Assay saveAssay = assayService.save(assay);
        return ResponseEntity.status(HttpStatus.OK).body(saveAssay);
    }

    @RequestMapping(value = "/deleteById", method = RequestMethod.GET)
    public ResponseEntity<Void> deleteById(Long id) {
        assayService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(value = "/deleteByName", method = RequestMethod.GET)
    public ResponseEntity<Void> deleteByName(String name) {
        assayService.deleteByName(name);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
