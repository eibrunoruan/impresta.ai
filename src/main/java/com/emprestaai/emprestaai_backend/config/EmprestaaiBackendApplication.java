package com.emprestaai.emprestaai_backend.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.emprestaai.emprestaai_backend.config",
		"com.emprestaai.emprestaai_backend.controller",
		"com.emprestaai.emprestaai_backend.exception",
		"com.emprestaai.emprestaai_backend.model",
		"com.emprestaai.emprestaai_backend.service"
})
public class EmprestaaiBackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(EmprestaaiBackendApplication.class, args);
	}
}
