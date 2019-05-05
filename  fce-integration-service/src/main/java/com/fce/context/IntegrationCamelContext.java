package com.fce.context;

import org.apache.camel.CamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fce.pojo.QuoteResponse;
import com.fce.pojo.QuoteRequest;
import com.fce.util.AppConstants;

@Component
public class IntegrationCamelContext {

	@Autowired
	private CamelContext context;

	public void sendBody(QuoteRequest request) {
		context.createProducerTemplate().sendBody(AppConstants.DIRECT_START, request);
	}

	public QuoteResponse receiveBody() {
		return context.createConsumerTemplate().receiveBody(AppConstants.SEDA_END, QuoteResponse.class);
	}

}
