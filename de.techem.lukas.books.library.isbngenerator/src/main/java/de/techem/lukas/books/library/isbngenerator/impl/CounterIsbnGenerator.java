package de.techem.lukas.books.library.isbngenerator.impl;

import de.techem.lukas.books.library.isbngenerator.api.IsbnGenerator;
import de.techem.lukas.books.library.isbngenerator.api.IsbnGenerator.SequenceStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
//@Qualifier("sequence")
@SequenceStrategy
public class CounterIsbnGenerator implements IsbnGenerator {

	public CounterIsbnGenerator(@Value("${isbngenerator.prefix}") String prefix,
			@Value("${isbngenerator.countryCode}") String countryCode) {
		super();
		this.prefix = prefix;
		this.countryCode = countryCode;
	}

	private String prefix;
	private String countryCode;

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String suffix) {
		this.countryCode = suffix;
	}

	private int counter;

	public String next() {
		return prefix + counter++ + countryCode;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
}
