package com.fce.api.serice;

import com.fce.pojo.QuoteResponse;
import com.fce.pojo.QuoteRequest;

public interface QuoteService {

	QuoteResponse getQuote(QuoteRequest request) throws Exception;

	QuoteResponse quoteExchange(QuoteRequest request) throws Exception;
}
