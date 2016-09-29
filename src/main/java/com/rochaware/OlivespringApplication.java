package com.rochaware;

import com.rochaware.model.DatabaseObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OlivespringApplication {

	public static void main(String[] args) {
		DatabaseObject.init("olivespring","localhost");
		SpringApplication.run(OlivespringApplication.class, args);
	}
}
