package com.wechall.admin.domain.post.controller.form;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/form/post")
public class PostFormController {

    @GetMapping("/test")
    public ModelAndView fileUploadPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("fileUpload");
        return modelAndView;
    }

}