package org.javacream.training.demo.async;

import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

public class AsyncDemoClient {

	public static void main(String[] args) throws InterruptedException {
		WebClient client = WebClient.create("http://localhost:8080");
		Mono<String> nameMono = client.get().uri("/demo/{id}", "Id1").retrieve().bodyToMono(String.class);

		nameMono.subscribe(System.out::println);
		synchronized(client) {
			client.wait();
		}
	}

}
