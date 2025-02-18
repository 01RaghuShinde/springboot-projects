package com.example.ChallengeApp;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  // This annotation tells Spring that this is a configuration class
public class AppConfig {

    @Bean  // This annotation tells Spring to create a bean of type Challenge
    public Challenge challenge() {
        return new Challenge(1L, "February", "Solve Spring challenge");
    }
}
