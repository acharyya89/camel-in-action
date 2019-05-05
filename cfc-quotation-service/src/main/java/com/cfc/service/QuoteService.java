package com.cfc.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.cfc.pojo.Quote;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class QuoteService {
	public Quote getQuote() throws JsonParseException, JsonMappingException, IOException {
		return new ObjectMapper().readValue(new File("quote.json"), Quote.class);
	}
}
