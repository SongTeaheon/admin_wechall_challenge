package com.wechall.admin.domain.post.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

import lombok.extern.slf4j.Slf4j;
import org.imgscalr.Scalr;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
public class ImageStoreService {

    private ServletContext context;

    public ImageStoreService(ServletContext context) {
        this.context = context;
    }

    public List<String> saveFiles(MultipartFile[] files, long challengeNo) {

        List<String> filePaths = new ArrayList<>();

        String uploadPath = createFolder("challengeNo" + challengeNo);

        try {
            for (MultipartFile multipartFile : files) {
                File createdFile = saveSingleFile(multipartFile, uploadPath);
                if(isImage(createdFile)){
                    saveThumbnail(createdFile.getName(), uploadPath);
                }

                filePaths.add(createdFile.getAbsolutePath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return filePaths;
    }

    private String createFolder(String lastFolderName) {
        String baseDir = context.getRealPath("resources/uploads/images/post");
        File createdDir = new File(baseDir, lastFolderName);
        if (!createdDir.exists()) {
            createdDir.mkdirs();
        }
        return createdDir.getPath();
    }

    private File saveSingleFile(MultipartFile file, String uploadPath) throws Exception{
        
        //path만들기
        String uploadFileName = file.getOriginalFilename();
        uploadFileName = uploadFileName.substring(uploadFileName.indexOf("\\")+1);//IE has file path
        String path = uploadPath + "/" + UUID.randomUUID() + "_" + uploadFileName;

        //파일 생성 및 이미지 저장
        File imgFile = new File(path);
        file.transferTo(imgFile);

        return imgFile;
    }

    private boolean isImage(File file){
        try{
            String contentType = URLConnection.guessContentTypeFromName(file.getName());
            return contentType.startsWith("image");
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    private void saveThumbnail(String originFileName, String uploadPath){
        try{
            BufferedImage bufferedImage = ImageIO.read(new File(uploadPath, originFileName));

            int destWidth = 250, destHeight = 150; 
            int originWidth = bufferedImage.getWidth(); 
            int originHeight = bufferedImage.getHeight(); 

            int cropWidth = originWidth; 
            int cropHeight = (originWidth * destHeight) / destWidth; 
            
            if(cropHeight > originHeight) { 
                cropWidth = (originHeight * destWidth) / destHeight;
                cropHeight = originHeight; 
            } 
            
            // 계산된 크기로 원본이미지를 가운데에서 crop
            BufferedImage cropImg = Scalr.crop(bufferedImage,           
                                                (originWidth-cropWidth)/2, (originHeight-cropHeight)/2, 
                                                cropWidth, cropHeight);

            //목표 사이즈로 resize
            BufferedImage destImg = Scalr.resize(cropImg, destWidth, destHeight);
            File thumbFile = new File(uploadPath, "thumbnail_"+originFileName);
            String formatName = originFileName.substring(originFileName.lastIndexOf(".")+1);
            ImageIO.write(destImg, formatName, thumbFile);
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
}