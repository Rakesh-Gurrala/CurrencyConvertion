package com.currency.conversion.exceptionHandling;

public class ExternalAPIException extends RuntimeException{
	public ExternalAPIException(String message) {
        super(message);
    }
}
