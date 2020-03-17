package de.techem.lukas.content.library.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import de.techem.lukas.content.library.api.ContentService;
import de.techem.lukas.content.library.model.Content;

@Service
public class ContentServiceImpl implements ContentService {
	
	@Autowired @Qualifier("contentStore")
	private HashMap<Integer, Content> contentStore;
	
//	@PostConstruct
//	public void initContentServiceImpl(){
//		List<String> tags1 = new ArrayList<>();
//		tags1.add("Human");
//		tags1.add("Techem");
//		List<String> tags2 = new ArrayList<>();
//		tags2.add("Dog");
//		tags2.add("Techem");
//		this.contentStore.put(1, new Content("Hans", tags1, "blabla"));
//		this.contentStore.put(2, new Content("Bello", tags2, "wuff"));
//	}

	public ContentServiceImpl(HashMap<Integer, Content> demoDaten) {
		super();
		this.contentStore = demoDaten;
	}

	public HashMap<Integer, Content> getDemoDaten() {
		return contentStore;
	}

	public void setDemoDaten(HashMap<Integer, Content> demoDaten) {
		this.contentStore = demoDaten;
	}

	@Override
	public Content findById(String ressource) {
		try {
			Content content = contentStore.values().stream().filter(c -> c.getId().equals(ressource))
					.findFirst().get();
			return content;
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public List<String> findByTag(String tag) {
		try {
			List<String> content = contentStore.values().stream().filter(c -> c.getTags().contains(tag))
					.map(c -> c.getId()).collect(Collectors.toList());
			return content;
		} catch (Exception e) {
			return null;
		}

	}

	public void addData(int ID, Content content) {
		contentStore.put(ID, content);
	}

}
