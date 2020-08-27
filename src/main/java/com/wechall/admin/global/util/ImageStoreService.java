package com.wechall.admin.global.util;

import java.io.File;
import java.io.IOException;
import java.net.URLConnection;
import java.nio.file.Paths;
import java.util.UUID;

import javax.servlet.ServletContext;

import com.wechall.admin.global.common.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Component
public class ImageStoreService {

    private ServletContext context;

    public ImageStoreService(ServletContext context) {
        this.context = context;
    }

    public File saveTempFile(MultipartFile file) {
        
        if (file == null) {
            log.info("file is null");
            return null;
        }

        File newFile = null;
        try {
            newFile = saveSingleFile(file, context.getRealPath(Constant.IMG_PATH_TEMP));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return newFile;
    }

    public File copyFile(String srcAbsolutePath, String targetAbsolutePath) throws IOException{

        String filename = Paths.get(srcAbsolutePath).getFileName().toString();
        createFolder(targetAbsolutePath);

        File in = new File(srcAbsolutePath);
        File out = new File(targetAbsolutePath + "/" + filename);
        FileCopyUtils.copy(in, out);
        return out;
    }
    

    private File createFolder(String path) {
        File createdDir = new File(path);
        if (!createdDir.exists()) {
            createdDir.mkdirs();
        }
        return createdDir;
    }

    private File saveSingleFile(MultipartFile file, String uploadPath) throws IOException{
        
        //path만들기
        String uploadFileName = file.getOriginalFilename();
        uploadFileName = uploadFileName.substring(uploadFileName.indexOf("\\")+1);//IE has file path
        String path = uploadPath + "/" + UUID.randomUUID() + "_" + uploadFileName;

        //파일 생성 및 저장
        File imgFile = new File(path);
        file.transferTo(imgFile);

        return imgFile;
    }

    public boolean isImage(File file){
        try{
            String contentType = URLConnection.guessContentTypeFromName(file.getName());
            return contentType.startsWith("image");
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public String getRealPath(String relativePath){
        return context.getRealPath(relativePath);
    }

    
}