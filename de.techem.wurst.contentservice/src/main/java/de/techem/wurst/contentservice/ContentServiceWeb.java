package de.techem.wurst.contentservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContentServiceWeb {

	@Autowired
	ContentService contentService;

	@GetMapping("/ids/{id}")
	public Content findById(@PathVariable String id) {
		return contentService.findById(id);
	}

	@GetMapping("/tags")
	public List<Content> findByTag(@RequestParam String tag) {
		return contentService.findByTag(tag);
	}

}
