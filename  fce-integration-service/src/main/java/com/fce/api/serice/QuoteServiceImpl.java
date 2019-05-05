package com.fce.api.serice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fce.context.IntegrationCamelContext;
import com.fce.pojo.QuoteResponse;
import com.fce.pojo.QuoteRequest;

@Service
public class QuoteServiceImpl implements QuoteService {

	@Autowired
	IntegrationCamelContext context;

	@Override
	public QuoteResponse getQuote(QuoteRequest request) throws Exception {

		return quoteExchange(request);
	}

	@Override
	public QuoteResponse quoteExchange(QuoteRequest request) throws Exception {

		// Sending data to Router
		context.sendBody(request);

		// Receiving data from Router
		return context.receiveBody();
	}

}
