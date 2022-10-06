package com.azaztrucking;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AzaztruckingApplication {

	public static void main(String[] args) {
		
		String num = "999";
		System.out.println(StringUtils.leftPad(num, 11,"0"));
		
		SpringApplication.run(AzaztruckingApplication.class, args);
	}

}
