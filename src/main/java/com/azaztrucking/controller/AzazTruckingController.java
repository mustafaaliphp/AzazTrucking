package com.azaztrucking.controller;



import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

import com.azaztrucking.aspect.AzazTruckingLog;
import com.azaztrucking.common.AzazTruckingCommonUtils;
import com.azaztrucking.doa.LogInfoDAO;
import com.azaztrucking.exception.AzazTruckingExceptions.MissingInputException;
import com.azaztrucking.model.AzazTruckingRequest;
import com.azaztrucking.model.AzazTruckingResponse;
import com.azaztrucking.service.AzazTruckingService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RequiredArgsConstructor
@RestController
@Slf4j
public class AzazTruckingController {

	private final LogInfoDAO logInfoDAO;
	private final AzazTruckingService azService;
	
	@AzazTruckingLog
	@PostMapping(path="/azinq", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AzazTruckingResponse> addDriver(@RequestBody AzazTruckingRequest azazTruckingRequest, WebRequest webRequest){
		webRequest.setAttribute("azRequest", azazTruckingRequest, RequestAttributes.SCOPE_REQUEST);
		azazTruckingRequest.setAzId(AzazTruckingCommonUtils.getUuiBuilder("AZ").toString());
		
		if(StringUtils.isEmpty(azazTruckingRequest.getCallerRequestId())
			|| StringUtils.isEmpty(azazTruckingRequest.getCallerApplicationName())
			|| StringUtils.isEmpty(azazTruckingRequest.getCallerId())
			|| StringUtils.isEmpty(azazTruckingRequest.getTaskName())) {
			throw new MissingInputException("Missing input");
		}
		AzazTruckingResponse azazTruckingResponse =  azService.processAZInq(azazTruckingRequest);
		return  ResponseEntity.ok(azazTruckingResponse);
	}
}
