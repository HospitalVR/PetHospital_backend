package com.rjsj.pethospital.controller;

import com.rjsj.pethospital.entity.Record;
import com.rjsj.pethospital.service.RecordService;
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
@RequestMapping("record")
public class RecordController {
    @Autowired
    private RecordService recordService;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseEntity<List<Record>> findAll(){
        try {
            List<Record> records = recordService.findAll();
            if(records.isEmpty())
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            return ResponseEntity.status(HttpStatus.OK).body(records);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/findAllByName", method = RequestMethod.GET)
    public ResponseEntity<List<String>> findAllByName(String name) {
        try {
            List<String> recordsName = recordService.findAllByName(name);
            return ResponseEntity.status(HttpStatus.OK).body(recordsName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public ResponseEntity<Record> findById(Long id) {
        try {
            Record record = recordService.findById(id).orElse(null);
            if (record == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

            return ResponseEntity.status(HttpStatus.OK).body(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/findByName", method = RequestMethod.GET)
    public ResponseEntity<Record> findByName(String name) {
        try {
            Record record = recordService.findByName(name);
            if (record == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

            return ResponseEntity.status(HttpStatus.OK).body(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Record> save(HttpServletRequest request) {
        Record record = new Record();
        record.setName(request.getParameter("name"));
        record.setBreed(request.getParameter("breed"));
        record.setAge(Integer.parseInt(request.getParameter("age")));
        record.setGender(request.getParameter("gender"));
        record.setColor(request.getParameter("color"));
        record.setOwner(request.getParameter("owner"));
        record.setPhone(request.getParameter("phone"));

        Record saveRecord = recordService.save(record);
        return ResponseEntity.status(HttpStatus.OK).body(saveRecord);
    }

    @RequestMapping(value = "/deleteById", method = RequestMethod.GET)
    public ResponseEntity<Void> deleteById(Long id) {
        recordService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(value = "/deleteByName", method = RequestMethod.GET)
    public ResponseEntity<Void> deleteByName(String name) {
        recordService.deleteByName(name);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
