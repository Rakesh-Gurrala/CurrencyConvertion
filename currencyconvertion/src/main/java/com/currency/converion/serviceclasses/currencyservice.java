package com.currency.converion.serviceclasses;

import com.currency.converion.modelClasses.*;
import com.currency.conversion.exceptionHandling.ExternalAPIException;
import com.currency.conversion.exceptionHandling.InvalidCurrencyCodeException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@Service
public class currencyservice {

	 @Value("${api.url}")
	    private String apiUrl;

	    private final RestTemplate restTemplate;

	    public currencyservice(RestTemplate restTemplate) {
	        this.restTemplate = restTemplate;
	    }

	    public currencyresponce getExchangeRates(String base) {
	        String url = apiUrl + base;
	        try {
	        	return restTemplate.getForObject(url, currencyresponce.class);
	        } catch (Exception e) {
	            throw new ExternalAPIException("Error calling the external API for base currency: " + base);
	        }
	    }

	    public double convertCurrency(double amount, String from, String to) {
	    	currencyresponce response = getExchangeRates(from);
	        Map<String, Double> rates = response.getRates();
	        Double rate = rates.get(to);
	        if (rate != null) {
	        	 throw new InvalidCurrencyCodeException("Invalid target currency: " + to);
	        } else {
	            throw new IllegalArgumentException("Invalid target currency");
	        }
	    }
}
