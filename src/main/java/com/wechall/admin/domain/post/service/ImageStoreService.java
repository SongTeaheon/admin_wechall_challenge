package com.wechall.admin.domain.post.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

import com.wechall.admin.domain.post.model.entity.Post;
import com.wechall.admin.domain.post.model.entity.PostImg;
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

    public List<PostImg> saveFiles(MultipartFile[] files, Post post) {

        if(files == null ){
            log.info("files is null");
            return null;
        }

        if(post == null ){
            log.info("post is null");
            return null;
        }

        List<PostImg> images = new ArrayList<>();

        String uploadPath = createFolder("challengeNo" + post.getChallengeNo());

        try {
            for (MultipartFile multipartFile : files) {

                //이미지 생성
                File createdFile = saveSingleFile(multipartFile, uploadPath);
                File thumbFile = null;

                //썸네일 생성
                if(isImage(createdFile)){
                    thumbFile = saveThumbnail(createdFile, uploadPath);
                }

                //객체로 담는다
                PostImg postImg = PostImg.builder()
                                    .imgPath(createdFile.getAbsolutePath())
                                    .thumnailPath(thumbFile.getAbsolutePath())
                                    .post(post)
                                    .build();
                //list에 넣는다                    
                images.add(postImg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return images;
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

    private File saveThumbnail(File imgFile, String uploadPath){

        File thumbFile = null;
        String originFileName =imgFile.getName();
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
            thumbFile = new File(uploadPath, "thumbnail_"+originFileName);
            String formatName = originFileName.substring(originFileName.lastIndexOf(".")+1);
            ImageIO.write(destImg, formatName, thumbFile);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return thumbFile;
    }
}