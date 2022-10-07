package com.az.exception;

public class MissingInputException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	 public MissingInputException(String msg) {
		    super(msg);
		  }
}
