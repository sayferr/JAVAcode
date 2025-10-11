package com.studeis.junit.intro_junit;

import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IntroJUnitApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntroJUnitApplication.class, args);
	}

    @Bean
    public Faker faker(){
        return new Faker();
    }

//    @Bean
//    public MockMvc mockMvc(){ return new MockMvc(); }
}
