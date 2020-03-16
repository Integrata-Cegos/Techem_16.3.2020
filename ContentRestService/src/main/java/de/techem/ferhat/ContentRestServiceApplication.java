package de.techem.ferhat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import de.techem.lukas.content.library.model.Content;

@SpringBootApplication
@ComponentScan("de.techem.lukas")
public class ContentRestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContentRestServiceApplication.class, args);

	}

	@Bean
	@Qualifier("contentStore")
	HashMap<Integer, Content> contentStore() {
		HashMap<Integer, Content> testData = new HashMap<>();
		List<String> tags1 = new ArrayList<String>();
		tags1.add("Human");
		tags1.add("Techem");
		tags1.add("Spring");
		Content content = new Content("Hans", tags1, "blablabla");
		testData.put(1, content);

		List<String> tags2 = new ArrayList<String>();
		tags2.add("Dog");
		tags2.add("Techem");
		Content content2 = new Content("Bello", tags2, "Wuff");
		testData.put(2, content2);

		return testData;
	
	}

}
