package org.javacream.books.warehouse.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.techem.lukas.books.library.isbngenerator.api.IsbnGenerator;
import de.techem.lukas.books.library.isbngenerator.api.IsbnGenerator.RandomStrategy;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class IsbnGeneratorTest {

	@Autowired
	@RandomStrategy
	//@Qualifier("sequence")
	//@Resource(name = "randomIsbnGenerator")
	private IsbnGenerator isbnGenerator;
	@Test
	public void testBusinessObjects() {
		System.out.println(isbnGenerator.next());

	}

	

}
