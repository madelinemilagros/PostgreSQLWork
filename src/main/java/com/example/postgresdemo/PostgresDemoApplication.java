package com.example.postgresdemo;

import com.example.postgresdemo.model.CatFact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableJpaAuditing
public class PostgresDemoApplication {

	private static final Logger log = LoggerFactory.getLogger(PostgresDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PostgresDemoApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

//	@Bean
//	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
//		return args -> {
//			Quote quote = restTemplate.getForObject(
//					"https://cat-fact.herokuapp.com/facts", Quote.class);
//			log.info(quote.toString());
//		};
//	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			CatFact fact = restTemplate.getForObject(
					"https://cat-fact.herokuapp.com/facts", CatFact.class);
			log.info(fact.toString());
		};
	}
}
