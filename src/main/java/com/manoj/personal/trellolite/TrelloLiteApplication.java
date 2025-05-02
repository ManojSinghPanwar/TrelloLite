package com.manoj.personal.trellolite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class TrelloLiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrelloLiteApplication.class, args);
	}

}
