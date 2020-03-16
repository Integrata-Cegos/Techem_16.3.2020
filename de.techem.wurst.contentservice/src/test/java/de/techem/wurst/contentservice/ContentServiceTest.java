package de.techem.wurst.contentservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ContentServiceTest {

	private static final String VALID_ID = "1";
	private static final String INVALID_ID = "3";
	private static final String VALID_TAG = "schinkenspeck";
	private static final String INVALID_TAG = "kaese";
	
	@Autowired
	ContentService contentService;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void validIdIsFound() {
		Assert.assertNotNull(contentService.findById(VALID_ID));
	}
	
	@Test
	public void validTagIsFound() {
		Assert.assertNotNull(contentService.findByTag(VALID_TAG));
	}
}
