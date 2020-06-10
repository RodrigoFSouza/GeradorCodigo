package com.rfs.data.GeradorDTO;

import com.rfs.data.GeradorDTO.config.ApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationProperties.class)
public class GeradorDtoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeradorDtoApplication.class, args);
	}

}
