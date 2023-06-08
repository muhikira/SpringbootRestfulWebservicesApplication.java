package com.muhikira.springboot;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Spring Boot Rest API Documentation", version = "1.0", description = "All the APIs Information about Spring Boot Rest API Documentation",
		contact=@Contact(name = "Ishmael ", email = "imuhikira@gmail.com",url="https://www.javaguides.net/user_management.html"),
license= @License(name = "Apache 2.0",
url = "https://www.javaguides.net/license")),
externalDocs = @ExternalDocumentation(
		description ="Spring Boot USER Management Documentation",
		url = "https://www.javaguides.net/user_management.html"
))
public class SpringbootRestfulWebservicesApplication {
	@Bean
	public ModelMapper modelMapper(){
		return	new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestfulWebservicesApplication.class, args);
	}

}
