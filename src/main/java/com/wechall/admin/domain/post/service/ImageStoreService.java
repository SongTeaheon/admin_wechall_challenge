package com.wechall.admin.domain.post.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
public class ImageStoreService {
    
    private ServletContext context;

    public ImageStoreService(ServletContext context){
        this.context = context;
    }

    public List<String> saveImages(MultipartFile[] images, long challengeNo){
        
        List<String> imgPaths = new ArrayList<>();
        String baseDir = context.getRealPath("resources/uploads/images/post");
        try {
            for(MultipartFile img : images) {
                String uploadFileName = img.getOriginalFilename();
                log.info(uploadFileName);

                //IE has file path
                uploadFileName = uploadFileName.substring(uploadFileName.indexOf("\\")+1);

                String path = baseDir + "/" + uploadFileName;
                img.transferTo(new File(path));
                imgPaths.add(path);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return imgPaths;
    }
}