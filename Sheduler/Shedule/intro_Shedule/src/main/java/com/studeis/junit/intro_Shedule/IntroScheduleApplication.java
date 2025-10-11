package com.studeis.junit.intro_Shedule;

import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class IntroScheduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntroScheduleApplication.class, args);
	}

}
