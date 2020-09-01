package com.wechall.admin.domain.comn.controller;

import java.io.File;

import com.wechall.admin.domain.comn.model.dto.ImagePathDto;
import com.wechall.admin.global.util.ImageStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/comn")
public class ImageController {
    
    private final ImageStoreService imageStoreService;

    @Autowired
    public ImageController(ImageStoreService imageStoreService){
        this.imageStoreService = imageStoreService;
    }

    @PostMapping("/upload")
    public ResponseEntity<ImagePathDto> uploadImage(@RequestParam("file") MultipartFile file){
        File createdFile = imageStoreService.saveTempFile(file);
        return new ResponseEntity<>(new ImagePathDto(createdFile.getPath()), HttpStatus.OK);
    }
}