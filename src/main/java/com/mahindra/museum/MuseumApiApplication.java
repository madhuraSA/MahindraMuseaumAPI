package com.mahindra.museum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.config.BootstrapMode;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@EnableJpaRepositories(bootstrapMode = BootstrapMode.DEFERRED)
public class MuseumApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MuseumApiApplication.class, args);
	}

}
