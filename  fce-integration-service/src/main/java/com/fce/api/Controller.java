package com.fce.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fce.api.serice.QuoteService;
import com.fce.pojo.QuoteResponse;
import com.fce.pojo.QuoteRequest;

@RestController
public class Controller implements RestQuoteService {

	@Autowired
	QuoteService quoteService;

	@Override
	public QuoteResponse getQuote(@RequestBody QuoteRequest request) throws Exception {
		return
		// Passing Students to Camel exchange after fetching data from DB
		quoteService.getQuote(request);
	}

}
