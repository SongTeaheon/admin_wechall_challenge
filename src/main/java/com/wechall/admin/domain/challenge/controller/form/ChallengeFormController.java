package com.wechall.admin.domain.challenge.controller.form;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChallengeFormController {
    @GetMapping("/challenge")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("wechall");       
        modelAndView.addObject(new String("WE_CHALL"));
        return modelAndView;
    }
}