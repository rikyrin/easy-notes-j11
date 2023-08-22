package com.example.easynotesj11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class EasyNotesJ11Application {

	public static void main(String[] args) {
		SpringApplication.run(EasyNotesJ11Application.class, args);
	}

}
