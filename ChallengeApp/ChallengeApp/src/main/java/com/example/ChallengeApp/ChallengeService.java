package com.example.ChallengeApp;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChallengeService {
    private static List<Challenge> challenges =new ArrayList<>();
    private static Long nextId=1L;


    public ChallengeService(){

    }
    public static List<Challenge> getAllChallenges(){
        return challenges;
    }
    public static boolean addChallenge(Challenge challenge){
        if(challenge !=null){
            challenge.setId(nextId++);
            challenges.add(challenge);
            return true;
        }else return false;


    }

    public Challenge getChallenge(String month) {
        for (Challenge challenge: challenges){
            if (challenge.getMonth().equals(month)){
                return challenge;
            }
        }
        return null;
    }
}
