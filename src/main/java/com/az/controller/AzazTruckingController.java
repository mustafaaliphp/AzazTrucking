package com.az.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

import com.az.aspect.AzazTruckingLog;
import com.az.common.AzazCommonUtils;
import com.az.doa.LogInfoDAO;
import com.az.exception.MissingInputException;
import com.az.exception.ResourceNotFoundException;
import com.az.model.AzRequest;
import com.az.model.AzResponse;
import com.az.model.Driver;
import com.az.model.LogInfo;
import com.az.service.DriverService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RequiredArgsConstructor
@RestController
@Slf4j
public class AzazTruckingController {

	private final LogInfoDAO logInfoDAO;
	
	private final DriverService driverService;
	
	//@AzazTruckingLog
	@PostMapping(path="/azinq", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AzResponse> addDriver(@RequestBody AzRequest azRequest, WebRequest webRequest){
		webRequest.setAttribute("azRequest", azRequest, RequestAttributes.SCOPE_REQUEST);
		azRequest.setAzId(AzazCommonUtils.getUuiBuilder("AZ").toString());
		
		if(StringUtils.isEmpty(azRequest.getCallerRequestId())
			|| StringUtils.isEmpty(azRequest.getCallerApplicationName())
			|| StringUtils.isEmpty(azRequest.getCallerId())
			|| StringUtils.isEmpty(azRequest.getTaskName())) {
			throw new MissingInputException("Missing input");
		}
		
		return new ResponseEntity<AzResponse>(HttpStatus.OK);
	}
	
	
	
//	@GetMapping(path="/getDrivers", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Object> getDriver(@RequestBody Driver driver, WebRequest webRequest){
//		webRequest.setAttribute("driver", driver, 0);
//
//		List<Driver> drivers;
//		
//		try {
//
//			
//			 drivers =  driverService.getListOfDriverByEmail(driver.getEmail());
//			
//		}
//		catch(Exception ex){
//			throw new ResourceNotFoundException(ex.getMessage());
//		}
//		return  ResponseEntity.ok(drivers);
//		
//		
//	}
}
