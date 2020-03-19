package org.javacream.training.demo.async;

import java.util.HashMap;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
@RequestMapping("demo")
public class AsyncDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsyncDemoApplication.class, args);
	}

	private HashMap<String, String> names;
	
	@PostConstruct public void init() {
		names = new HashMap<>();
		names.put("Id1", "Sawitzki");
	}
	
	@GetMapping("/{id}")
	private Mono<String> getNameById(@PathVariable String id) {
	    return Mono.just(names.get(id));
	}
}
