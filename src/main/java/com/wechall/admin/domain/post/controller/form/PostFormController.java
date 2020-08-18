package com.wechall.admin.domain.post.controller.form;

import java.util.List;

import com.wechall.admin.domain.post.service.ImageStoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/form/post")
public class PostFormController {
    
    private final ImageStoreService imageStoreService;

    public PostFormController(ImageStoreService imageStoreService){
        this.imageStoreService = imageStoreService;
    }

    @PostMapping(value = "/upload")
    @ResponseBody
    public String fileUpload(@RequestParam("files") MultipartFile[] images) {
        log.info("image size " + images.length);
        if(images == null) {
            log.info("images is null");
        }
        List<String> imgPaths = imageStoreService.saveFiles(images, 1);
        log.info(imgPaths.toString());

        return imgPaths.toString();
    }

    @GetMapping("/test")
    public ModelAndView fileUploadPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("fileUpload");
        return modelAndView;
    }

}