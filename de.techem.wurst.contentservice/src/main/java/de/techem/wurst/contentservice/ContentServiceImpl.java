package de.techem.wurst.contentservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	InitalContent initialContent;

	@Override
	public Content findById(String id) {
		return initialContent.getContentMap().get(id);
	}

	@Override
	public List<Content> findByTag(String tag) {
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
