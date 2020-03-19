package org.javacream.store.web;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@RestController
@RequestMapping(path = "api")
public class StoreWebServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(StoreWebServiceApplication.class, args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}

	@Autowired
	StoreRepository storeRepository;

	@GetMapping(path = "store/{category}/{item}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getStock(@PathVariable("category") String category, @PathVariable("item") String item) {
		return Integer.toString(readStock(category, item));
	}

	@PostMapping(path = "store/{category}/{item}", produces = MediaType.TEXT_PLAIN_VALUE)
	@Transactional
	public void setStock(@PathVariable("category") String category, @PathVariable("item") String item,
			@RequestHeader("stock") int stock) {
		saveStock(category, item, stock);
	}

	private void saveStock(String category, String id, int stock) {
		if (category == null || id == null) {
			throw new IllegalArgumentException("category and id must not be null");
		}
		storeRepository.save(new StoreEntry(category, id, stock));
	}

	private int readStock(String category, String id) {
		Optional<StoreEntry> result = storeRepository.findById(new StoreId(category, id));
		if (result.isPresent()) {
			return result.get().getStock();
		} else {
			return 0;
		}
	}

}
