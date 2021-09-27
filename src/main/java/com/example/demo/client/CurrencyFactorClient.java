package com.example.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="CONVERSIONFACTOR")
public interface CurrencyFactorClient {

	@GetMapping(value="/get")
	public ResponseEntity<Double> getConversionFactor(@RequestParam String countryCode) ;
}
