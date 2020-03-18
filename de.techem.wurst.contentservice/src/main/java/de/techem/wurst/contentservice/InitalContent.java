package de.techem.wurst.contentservice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class InitalContent {
	
	Map<String, Content> contentMap = new HashMap<String, Content>();

	public InitalContent() {
		contentMap.put("1", new Content("1", Arrays.asList("blutwurst", "salami", "bockwurst"), "schmeckt gut"));
		contentMap.put("2", new Content("2", Arrays.asList("wildscheinsalami", "schinkenspeck", "fleischkaese"), "schmeckt nicht so gut"));
	}

	public Map<String, Content> getContentMap() {
		return contentMap;
	}
	
}
