package com.fce.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fce.pojo.QuoteRequest;
import com.fce.pojo.QuoteResponse;
import com.fce.util.AppConstants;

@Component(AppConstants.ADDRESS_PROCESSOR)
public class QuoteProcessor implements Processor {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Override
	public void process(Exchange exchange) throws Exception {

		// Getting data from Exchange
		QuoteRequest request = exchange.getIn().getBody(QuoteRequest.class);

		// CFC Service Call
		//final String  URI = "http://localhost:8888/quote/get";
		final String  URI = "https://cfc-quotation-service.cfapps.io/quote/get";
		QuoteResponse response = restTemplate().postForObject(
				URI,
				request,
				QuoteResponse.class);

		// Sending data to ExchangeSSSS
		exchange.getOut().setBody(response);
	}
}