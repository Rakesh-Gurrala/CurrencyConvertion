package com.currency.converion.controllerclasses;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Value;

import com.currency.converion.modelClasses.conversionRequest;
import com.currency.converion.modelClasses.conversionResponse;
import com.currency.converion.serviceclasses.*;

@RestController
@RequestMapping("/api")
public class currencyController {

	private currencyservice currencyservice;
	
	@Value("${currency.base}")
    private String defaultBaseCurrency;

    public currencyController(currencyservice currencyService) {
        this.currencyservice = currencyService;
    }

    @GetMapping("/rates")
    public ResponseEntity<?> getExchangeRates(@RequestParam(required = false, defaultValue = "USD") String base) {
        try {
            return ResponseEntity.ok(currencyservice.getExchangeRates(base));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error fetching exchange rates");
        }
    }

    @PostMapping("/convert")
    public ResponseEntity<?> convertCurrency(@RequestBody conversionRequest request) {
        try {
            double convertedAmount = currencyservice.convertCurrency(request.getAmount(), request.getFrom(), request.getTo());
            return ResponseEntity.ok(new conversionResponse(request.getFrom(), request.getTo(), request.getAmount(), convertedAmount));
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Error during conversion");
        }
    }



  
}
