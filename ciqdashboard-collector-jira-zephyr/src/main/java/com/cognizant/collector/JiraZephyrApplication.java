package com.cognizant.collector;

import com.ulisesbocchio.jasyptspringboot.annotation.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.cloud.openfeign.*;
import org.springframework.scheduling.annotation.*;

@EnableFeignClients
@SpringBootApplication
@EnableScheduling
@EnableAutoConfiguration
@EnableEncryptableProperties
public class JiraZephyrApplication {

	public static void main(String[] args) {
		SpringApplication.run(JiraZephyrApplication.class, args);
	}

}
