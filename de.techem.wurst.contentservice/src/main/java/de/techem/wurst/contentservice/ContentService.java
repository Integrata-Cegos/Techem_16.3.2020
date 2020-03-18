package de.techem.wurst.contentservice;

import java.util.List;

public interface ContentService {

	Content findById(String id);

	List<Content> findByTag(String tag);

}