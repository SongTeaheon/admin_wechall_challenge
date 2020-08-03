package com.wechall.admin.domain.challenge.controller.api;

import java.util.ArrayList;
import java.util.List;

import com.wechall.admin.domain.challenge.model.vo.Challenge;
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
    public String getChallenge(
            @RequestParam(value = "inputData", required = false, defaultValue = Constant.EMPTY_STRING) final String inputData) {
            List<Challenge> list = new ArrayList<>();
            list.add(new Challenge(1, "test1"));
            list.add(new Challenge(2, "test2"));
        return list.toString();
    }

    @GetMapping("/challenge/{challengeSeqno}")
    @ResponseBody
    public Challenge getChallengeInfo(
            @RequestParam(value = "inputData", required = false, defaultValue = Constant.EMPTY_STRING) final String inputData,
            @PathVariable("challengeSeqno") int challengeSeqno) {

        return challengeService.getChallengeInfo(challengeSeqno);
    }

    @PostMapping("/challenge")
    @ResponseBody
    public void registChallengeInfo(
            @RequestParam(value = "inputData", required = false, defaultValue = Constant.EMPTY_STRING) final String inputData,
            @PathVariable("challengeSeqno") int challengeSeqno) {
    }

    @PutMapping("/challenge")
    @ResponseBody
    public void modifyChallengeInfo(
            @RequestParam(value = "inputData", required = false, defaultValue = Constant.EMPTY_STRING) final String inputData,
            @PathVariable("challengeSeqno") int challengeSeqno) {
    }

    @DeleteMapping("/challenge")
    @ResponseBody
    public void removeChallengeInfo(
            @RequestParam(value = "inputData", required = false, defaultValue = Constant.EMPTY_STRING) final String inputData,
            @PathVariable("challengeSeqno") int challengeSeqno) {
    }
}
