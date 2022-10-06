package com.azaztrucking.common;

import java.util.Base64;
import java.util.UUID;

public class AzazCommonUtils {

	private AzazCommonUtils() {
		
	}
	
	public static StringBuilder getUuiBuilder(String tla) {
		UUID uuidVal = UUID.randomUUID();
		StringBuilder builder = new StringBuilder();
		return builder
				.append(tla)
				.append(System.currentTimeMillis())
				.append(uuidVal.toString().replace("-", ""));
	}
	
	public static String base64Encode(String sInput) {
		byte[] encodedBytes = Base64.getEncoder().encode(sInput.getBytes());
		return new String(encodedBytes);
	}
	
	public static String base64Decode(String sInput) {
		byte[] encodedBytes = Base64.getDecoder().decode(sInput.getBytes());
		return new String(encodedBytes);
		
	}
}
