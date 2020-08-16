package com.wechall.admin.domain.challenge.controller.api;


import com.google.gson.GsonBuilder;
import com.wechall.admin.domain.challenge.service.ChallengeService;
import com.wechall.admin.global.common.Constant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ChallengeApiController {
    private final ChallengeService challengeService;

    @Autowired
    public ChallengeApiController(final ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @GetMapping("/challenge")
    @ResponseBody
    public String getChallengeList(
            @RequestParam(value = "inputData", required = false, defaultValue = Constant.EMPTY_STRING) final String inputData) {
        return new GsonBuilder().create().toJson(challengeService.getChallengeList());
    }

    @PostMapping("/challenge")
    @ResponseBody
    public void registChallengeInfo(
            @RequestParam(value = "inputData", required = false, defaultValue = Constant.EMPTY_STRING) final String inputData,
            @PathVariable("challengeNo") long challengeNo) {
    }

    @PutMapping("/challenge")
    @ResponseBody
    public void modifyChallengeInfo(
            @RequestParam(value = "inputData", required = false, defaultValue = Constant.EMPTY_STRING) final String inputData,
            @PathVariable("challengeNo") long challengeNo) {
    }

    @DeleteMapping("/challenge")
    @ResponseBody
    public void removeChallengeInfo(
            @RequestParam(value = "inputData", required = false, defaultValue = Constant.EMPTY_STRING) final String inputData,
            @PathVariable("challengeNo") long challengeNo) {
    }
}
