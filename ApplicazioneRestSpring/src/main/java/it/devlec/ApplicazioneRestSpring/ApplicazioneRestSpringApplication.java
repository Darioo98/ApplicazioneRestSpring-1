package it.devlec.ApplicazioneRestSpring;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Array;
import java.util.Arrays;

@SpringBootApplication
public class ApplicazioneRestSpringApplication {
	//creazione log4j
	private static final Logger logger =
			LoggerFactory.getLogger(ApplicazioneRestSpringApplication.class);

	//Utilizzo  di una chiave della proprietà di Spring
	@Value("${it.devlec.ApplicazioneRestSpring.saluti}")
	public String salutoIniziale;
	//main
	public static void main(String[] args) {
		SpringApplication.run(ApplicazioneRestSpringApplication.class, args);
	}

	//Definito il mio primo bean
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx){
		return arg -> {
			logger.debug(salutoIniziale);
			String[] beans = ctx.getBeanDefinitionNames();
			Arrays.sort(beans);
			for(String b : beans){
				logger.debug(b);
			}

			for (int i=0;i<beans.length;i++){
				logger.warn(beans[i]);
			}
		};
	}
}
