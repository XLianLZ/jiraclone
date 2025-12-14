package com.code.jiraclone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JiracloneApplication {
	public static void main(String[] args) {
		SpringApplication.run(JiracloneApplication.class, args);
	}
}
