package de.techem.contents.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import de.techem.contents.api.Content;
import de.techem.contents.api.ContentService;

@Service
public class ContentsServiceImpl implements ContentService {

	public static Map<String, Content> contentMap;
	static Content content1 = new Content("1", new ArrayList<String>(), "myData1");
	static Content content2 = new Content("2", new ArrayList<String>(), "myData2");
	
	static {
		contentMap = new HashMap<>();
		contentMap.put("ar01", content1);
		contentMap.put("ar02", content2);
	}
	
	@SuppressWarnings("finally")
	@Override
	@Transactional
	public Content findById(String id) {
		Content result = null;
		
		
		try {
			result = (Content) contentMap.get(id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally 
		{
			return result;
		}
	}

	@Override
	public List<String> findByTag(String tag) {
		// TODO Auto-generated method stub
		return null;
	}

}
