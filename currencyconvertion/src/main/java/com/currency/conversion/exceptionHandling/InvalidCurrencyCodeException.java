package com.currency.conversion.exceptionHandling;

public class InvalidCurrencyCodeException extends RuntimeException {
	
	 public InvalidCurrencyCodeException(String message) {
	        super(message);
	    }
}
