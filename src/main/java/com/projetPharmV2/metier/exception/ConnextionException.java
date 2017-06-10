package com.projetPharmV2.metier.exception;

public class ConnextionException extends Exception {
	public ConnextionException(String message) {
		super(message);
	}
	public ConnextionException(String message, Throwable throwable){
		super(message,throwable);
	}
}
