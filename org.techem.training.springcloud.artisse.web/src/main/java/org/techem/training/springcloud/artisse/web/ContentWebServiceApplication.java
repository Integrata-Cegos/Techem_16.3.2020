package org.techem.training.springcloud.artisse.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.techem.training.springcloud.artisse.api.Content;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ContentWebServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ContentWebServiceApplication.class, args);

	}

	@Bean
	@Qualifier("contentStore")
	Map<String, Content> contentStore() {
		HashMap<String, Content> testData = new HashMap<>();
		List<String> tags1 = new ArrayList<String>();
		tags1.add("IT");
		tags1.add("Java");
		tags1.add("Spring");
		Content content = new Content("SpringInAction", tags1, "A very good book");
		testData.put(content.getId(), content);

		List<String> tags2 = new ArrayList<String>();
		tags2.add("IT");
		Content content2 = new Content("DockerInAction", tags2, "Another very good book");
		testData.put(content2.getId(), content2);

		return testData;
	}

}
