package de.techem.wurst;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ContextConfiguration {

	@Bean @Qualifier("store") public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}
