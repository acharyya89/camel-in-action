package com.fce.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fce.pojo.QuoteRequest;
import com.fce.pojo.QuoteResponse;
import com.fce.util.AppConstants;

@RequestMapping(AppConstants.URL_ROOT)
public interface RestQuoteService {

	@PostMapping(AppConstants.URL_GET)
	public QuoteResponse getQuote(@RequestBody QuoteRequest request) throws Exception;

}
