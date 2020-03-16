package de.techem.wurst.contentservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContentService {

	@Autowired
	InitalContent initialContent;

	@GetMapping("/ids/{id}")
	public Content findById(@PathVariable String id) {
		return initialContent.getContentMap().get(id);
	}

	@GetMapping("/tags")
	public List<Content> findByTag(@RequestParam String tag) {

		List<Content> contentResult = new ArrayList<>();

		initialContent.getContentMap().forEach((String key, Content content) -> {
			try {
				if (content.getTags().contains(tag)) {
					contentResult.add(content);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		});

		return contentResult;
	}

}
