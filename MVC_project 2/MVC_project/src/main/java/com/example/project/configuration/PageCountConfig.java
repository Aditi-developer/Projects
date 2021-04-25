package com.example.project.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.project.classes.PageCounter;


@Configuration
public class PageCountConfig {

	@Bean
	public PageCounter getPageCounter() {
		
		return new PageCounter();
	}
}
