package com.rjsj.pethospital.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    String saveFile(String fileName, MultipartFile file);

}
