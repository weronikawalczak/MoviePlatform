package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class App {

	private static final Logger log = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

//	@Bean
//	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
//		return args -> {
//			Quote quote = restTemplate.getForObject(
//					"https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
//			System.out.println("myTest " + quote.toString());
//			System.out.println("myTest " + quote.getType());
//			System.out.println("myTest " + quote.getValue().getId());
//			System.out.println("myTest " + quote.getValue().getQuote());
//			log.info(quote.toString());
//		};
//	}
}