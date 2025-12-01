package com.studeis.mysql_intro.createssms;

import net.datafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CreateSsmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreateSsmsApplication.class, args);
	}

    @Bean
    public Faker faker(){
        return new Faker();
    }
}
