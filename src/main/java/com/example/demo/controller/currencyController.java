package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.client.CurrencyFactorClient;

@RestController
public class currencyController {
	private static final Logger logger = LoggerFactory.getLogger(currencyController.class);
	

	@Autowired
	CurrencyFactorClient currencyFactorSvcClient;
	
	@GetMapping("/getCurrency")
	public String getCurrency() {
		logger.info("HII");
		return "HIII";
	}
	
	@GetMapping("/convertAmount")
	public Double convertAmount(@RequestParam("countryCode") String cc , @RequestParam long amount ) {
//		return 0.01;
		Double conversionFactor  = currencyFactorSvcClient.getConversionFactor(cc).getBody();
		logger.info("Conversion Factor {} , amount {} , CountryCode {}",conversionFactor,amount,cc);
		return amount/conversionFactor;
		
	}

}
