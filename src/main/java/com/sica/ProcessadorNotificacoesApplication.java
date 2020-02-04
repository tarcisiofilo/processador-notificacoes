package com.sica;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProcessadorNotificacoesApplication {

	@Bean
	public CommandLineRunner runner() {
		return new RabbitAmqpRunner();
	}

	public static void main(String[] args) {
		SpringApplication.run(ProcessadorNotificacoesApplication.class, args);
	}

}
