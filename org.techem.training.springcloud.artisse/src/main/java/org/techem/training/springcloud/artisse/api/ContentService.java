package org.techem.training.springcloud.artisse.api;

import java.util.List;


public interface ContentService {
	Content findById(String id);
	List<String> findByTag(String tag);
}
