package com.fce.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fce.processor.QuoteProcessor;
import com.fce.util.AppConstants;

@Component(AppConstants.INTEGRATION_ROUTER)
public class IntegrationRoute extends RouteBuilder {

    private static final Logger LOGGER = LoggerFactory.getLogger(IntegrationRoute.class);
    
	@Override
	public void configure() throws Exception {
		// Receiving - Channel
		from(AppConstants.DIRECT_START)
		
		// Router details
		.id(AppConstants.INTEGRATION_ROUTER)
		.routeGroup(AppConstants.INTEGRATION_ROUTER_GROUP)
		.description(AppConstants.INTEGRATION_ROUTER_DETAILS)
		
		// Processor details
		// Modifying address details
		.log(LoggingLevel.INFO, LOGGER, AppConstants.LOG_KEY_MSG1)
		.process(new QuoteProcessor())
		.log(LoggingLevel.INFO, LOGGER, AppConstants.LOG_KEY_MSG2)
		
		
		// Routing - Channel 
		.to(AppConstants.SEDA_END);
	}
}
