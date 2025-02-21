package com.example.ChallengeApp;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChallengeController {
    private ChallengeService challengeService;
    public ChallengeController(Challenge challenge){
        this.challengeService=  challengeService;
    }



    @GetMapping("/challenges")
    public List<Challenge> getAllChallenges(){
        return ChallengeService.getAllChallenges();
    }
    @PostMapping("/challenges")
    public String addChallenge(@RequestBody Challenge challenge){
        boolean isChallengeAdded =
                ChallengeService.addChallenge(challenge);
        if (isChallengeAdded){
        return "Challenge added Successfully !";
        }else return "Challenge not added";

    }
    @GetMapping("/challenges/{month}")
    public Challenge getChallenge(@PathVariable String month) {
        Challenge challenge = challengeService.getChallenge(month);
        if (challenge != null) {
            return challenge;
        } else {
            return null; // You could return ResponseEntity.notFound() here instead of null.
        }
    }


}




