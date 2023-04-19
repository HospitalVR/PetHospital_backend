package com.rjsj.pethospital.controller;

import com.rjsj.pethospital.util.FileUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("file")
public class FileController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity handleFileUpload(@RequestParam("file") MultipartFile[] files) {
        try {
            for (MultipartFile file : files) {
                String fileName = file.getOriginalFilename();
                FileUtil.saveFile(fileName, file);
            }
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/getFilesName", method = RequestMethod.GET)
    public ResponseEntity<List<String>> getFilesName() {
        return ResponseEntity.status(HttpStatus.OK).body(FileUtil.getFilesName());
    }

    @RequestMapping(value = "/getImageFiles", method = RequestMethod.GET)
    public ResponseEntity<Map<String, byte[]>> getImageFiles() {
        return ResponseEntity.status(HttpStatus.OK).body(FileUtil.getImageFiles());
    }

    @RequestMapping(value = "/getVideoFiles", method = RequestMethod.GET)
    public ResponseEntity<Map<String, byte[]>> getVideoFiles() {
        return ResponseEntity.status(HttpStatus.OK).body(FileUtil.getVideoFiles());
    }
}
