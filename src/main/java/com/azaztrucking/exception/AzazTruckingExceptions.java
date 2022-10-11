package com.azaztrucking.exception;

import java.sql.SQLException;

public class AzazTruckingExceptions {

	public static class MissingInputException extends RuntimeException {
		public MissingInputException(String msg) {
			super(msg);
		}
	}
	
	public static class ResourceNotFoundException extends RuntimeException {
		  public ResourceNotFoundException(String msg) {
		    super(msg);
		  }
		}
	
	public static class InvalidInputException extends RuntimeException {
		  public InvalidInputException(String msg) {
		    super(msg);
		  }
		}

	public static class SQLExceptionHandler extends SQLException {
		  public SQLExceptionHandler(String msg) {
		    super(msg);
		  }
		}
	
	public static class GlobalExceptionHandler extends RuntimeException {
		  public GlobalExceptionHandler(String msg) {
		    super(msg);
		  }
		}
	
}
