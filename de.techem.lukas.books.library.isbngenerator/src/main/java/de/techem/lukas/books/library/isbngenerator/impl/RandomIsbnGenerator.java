package de.techem.lukas.books.library.isbngenerator.impl;

import java.util.Random;

import de.techem.lukas.books.library.isbngenerator.api.IsbnGenerator;
import de.techem.lukas.books.library.isbngenerator.api.IsbnGenerator.RandomStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
@Service
//@Qualifier("random")
@RandomStrategy
public class RandomIsbnGenerator implements IsbnGenerator {

	@Value("${isbngenerator.prefix}")	
	private String prefix;
	@Value("${isbngenerator.countryCode}")	
	private String countryCode;
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String suffix) {
		this.countryCode = suffix;
	}
	private Random random;
	
	{
		random = new Random(this.hashCode() + System.currentTimeMillis());
	}
	
	public String next(){
		return prefix + random.nextInt() + countryCode;
	}

	public String getPrefix(){
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
}
