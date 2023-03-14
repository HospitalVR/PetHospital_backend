package com.rjsj.pethospital.service.impl;

import com.rjsj.pethospital.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public String saveFile(String fileName, MultipartFile file) {
        if (file == null)
            return null;
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        File newFile = new File("E:/res", fileName + suffix);
        try {
            file.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newFile.getName();
    }

}
