package com.fce.util;

public class AppConstants {
	// @API
	public static final String URL_ROOT = "/quote";
	public static final String URL_GET = "/get";
	// @Camel
	public static final String DIRECT_START = "direct:start";
	public static final String SEDA_END = "seda:end";
	public static final String ADDRESS_PROCESSOR = "AddressProcessor";
	public static final String INTEGRATION_ROUTER = "IntegrationRouter";
	public static final String INTEGRATION_ROUTER_DETAILS = "This Router is responsible modify Student details.";
	public static final String INTEGRATION_ROUTER_GROUP = "SMS-GROUP";
	// @General
	public static final String COMMA_SEPARATOR = ", ";
	public static final String KEYWORD_INDIA = "India";
	// @Log-message
	public static final String LOG_KEY_MSG1 = "{{camel.log.msg1}}";
	public static final String LOG_KEY_MSG2 = "{{camel.log.msg2}}";
}
