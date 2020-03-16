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
	}

	public Map<String, Content> getContentMap() {
		return contentMap;
	}
	
	

}
