package de.techem.lukas.books.executable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("de.techem.lukas")
public class JavacreamApplication {

	public static void main(String[] args) {
		System.out.println("************** STARTING ****************+");
		SpringApplication.run(JavacreamApplication.class, args);
	}

}
