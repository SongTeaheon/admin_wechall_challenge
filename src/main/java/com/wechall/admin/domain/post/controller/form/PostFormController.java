package com.wechall.admin.domain.post.controller.form;

import java.util.List;

import com.google.gson.Gson;
import com.wechall.admin.domain.post.model.entity.Post;
import com.wechall.admin.domain.post.model.entity.PostImg;
import com.wechall.admin.domain.post.service.ImageStoreService;
import com.wechall.admin.domain.post.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/form/post")
public class PostFormController {
    
    private final ImageStoreService imageStoreService;
    private final PostService postService;
    
    public PostFormController(ImageStoreService imageStoreService, PostService postService){
        this.imageStoreService = imageStoreService;
        this.postService = postService;
    }

    @PostMapping(value = "/upload")
    @ResponseBody
    public String fileUpload(@RequestParam("files") MultipartFile[] images, @RequestParam("post") String postJson){

        Gson gson = new Gson();
        Post post = gson.fromJson(postJson, Post.class);

        List<PostImg> postImages = imageStoreService.saveFiles(images, post);
        post.setImages(postImages);

        postService.createPost(post);
        postService.savePostImg(postImages);

        return post.getImages().toString();
    }

    @GetMapping("/test")
    public ModelAndView fileUploadPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("fileUpload");
        return modelAndView;
    }

}