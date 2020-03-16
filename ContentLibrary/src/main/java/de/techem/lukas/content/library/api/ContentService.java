package de.techem.lukas.content.library.api;

import java.util.List;

import de.techem.lukas.content.library.model.Content;

public interface ContentService {
	
	public Content findById(String ressource);
	
	public List<String> findByTag(String tag);
	

}
