package com.cfc.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.cfc.pojo.Quote;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class QuoteService {
	public Quote getQuote() throws JsonParseException, JsonMappingException, IOException {
		return new ObjectMapper().readValue(ResourceUtils.getFile("classpath:quote.json"), Quote.class);
	}
}
