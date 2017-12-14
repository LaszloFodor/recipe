package com.alkfejl.recipeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@ComponentScan
@SpringBootApplication/*(scanBasePackages = {"com.alkfejl.recipeapp.config", "com.alkfejl.recipeapp.service"})*/
public class RecipeappApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeappApplication.class, args);
	}
}
