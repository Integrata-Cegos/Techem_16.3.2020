package de.techem.wurst.books.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestStoreService {
	
	@Autowired @Qualifier("store")
	private RestTemplate restTemplate;
	public int getStock(String category, String id) {
	
		return Integer.parseInt(restTemplate.getForObject("http://localhost:8080/store/" + category + "/" + id, String.class));
	}
	
}
