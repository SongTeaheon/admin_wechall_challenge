package com.wechall.admin.controller.api;

import java.util.List;

import com.wechall.admin.common.Constant;
import com.wechall.admin.service.ChallengeService;
import com.wechall.admin.vo.Challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChallengeApiController {
    private final ChallengeService challengeService;

    @Autowired
    public ChallengeApiController(final ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @GetMapping("/challenge")
    @ResponseBody
    public List<Challenge> getChallenge(
            @RequestParam(value = "inputData", required = false, defaultValue = Constant.EMPTY_STRING) final String inputData) {

        return challengeService.getChallenge();
    }

    @GetMapping("/challenge/{challengeSeqno}")
    @ResponseBody
    public Challenge getChallengeInfo(
            @RequestParam(value = "inputData", required = false, defaultValue = Constant.EMPTY_STRING) final String inputData,
            @PathVariable("challengeSeqno") int challengeSeqno) {

        return challengeService.getChallengeInfo(challengeSeqno);
    }
}
