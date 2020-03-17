package de.techem.contents.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import de.techem.contents.api.ContentService;

@RestController
public class ContentRestService {
	@Autowired 
	private ContentService contentService;

	@GetMapping(path = "content/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public String getStock(@PathVariable("id") String id) {
		return "Stock: " + contentService.findById(id);
	}
}
