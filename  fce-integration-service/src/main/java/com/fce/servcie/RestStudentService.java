package com.fce.servcie;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fce.pojo.QuoteResponse;
import com.fce.util.AppConstants;

@RequestMapping(AppConstants.URL_ROOT)
public interface RestStudentService {

	@GetMapping(AppConstants.URL_GET)
	public List<QuoteResponse> getStudent() throws Exception;

}
