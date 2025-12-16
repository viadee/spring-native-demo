package com.example.demo;

import com.example.demo.config.NativeReflectionRuntimeHintConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportRuntimeHints;

@SpringBootApplication
@ImportRuntimeHints(NativeReflectionRuntimeHintConfig.class)
public class SpringNativeDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringNativeDemoApplication.class, args);
	}

}
