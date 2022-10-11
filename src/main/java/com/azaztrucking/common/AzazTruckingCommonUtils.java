package com.azaztrucking.common;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.Base64;
import java.util.Calendar;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

public class AzazTruckingCommonUtils {

	private AzazTruckingCommonUtils() {
		
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
	
	public static Timestamp getTime() {
		return new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
		
	}
	public static String addLeft(String num, int padSzise) {
		return StringUtils.leftPad(num, padSzise,"0");
	}
	
	public static String readFileAsString(String file) {
		try(InputStream is = AzazTruckingCommonUtils.class.getResourceAsStream(file)){
			return IOUtils.toString(is, StandardCharsets.UTF_8);
		}catch(IOException e) {
			return StringUtils.EMPTY;
		}
		
	}
}
