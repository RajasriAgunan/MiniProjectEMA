package com.example.MiniProjectEmployeeManagementSystem;

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
@OpenAPIDefinition(
		info=@Info(
		title="Employee Management API",
		version="1.0",
		description="API for managing employees",


		contact=@Contact(
				name="John",
				url="http://google.com",
				email="John@gmail.com"),

				license=@License(
				name="Apache 2.0") ),


externalDocs=@ExternalDocumentation
		(description="MiniProject Documentation for Employee Management Application") )

public class MiniProjectEmployeeManagementSystemApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}


	public static void main(String[] args) {
		SpringApplication.run(MiniProjectEmployeeManagementSystemApplication.class, args);
	}

}
