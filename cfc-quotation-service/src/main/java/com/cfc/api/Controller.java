package com.cfc.api;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cfc.pojo.Quote;
import com.cfc.service.QuoteService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class Controller {

	@Autowired
	QuoteService quoteService;

	@RequestMapping(value = "/get/quote", method = RequestMethod.GET)
	public Quote getQuote() throws JsonParseException, JsonMappingException, IOException {
		return quoteService.getQuote();
	}

}
