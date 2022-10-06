package com.azaztrucking.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

import com.azaztrucking.controller.AzazTruckingController;
import com.azaztrucking.model.ErrorMessage;
import com.azaztrucking.model.AzRequest;
import com.azaztrucking.model.AzResponse;
import com.azaztrucking.model.ErrorDetail;

import lombok.extern.slf4j.Slf4j;


@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

	  //@ResponseStatus(HttpStatus.BAD_REQUEST)
	  //@ExceptionHandler(value = {Exception.class, MissingInputException.class})
	  @ExceptionHandler(MissingInputException.class)
	  public ResponseEntity<AzResponse> missingInputException(MissingInputException ex, WebRequest webRequest) {
		  AzRequest azRequest = (AzRequest) webRequest.getAttribute("azRequest", RequestAttributes.SCOPE_REQUEST);
		  AzResponse azResponse = new AzResponse();
		  List<ErrorDetail> errorDetailList = new ArrayList<>();
		  
		  if(StringUtils.isEmpty(azRequest.getCallerRequestId())){
			  ErrorDetail errorDetail = new ErrorDetail();
			  errorDetail.setExCode(AzazTruckingExCodeEnum.MANDATORY_INPUT.getCode());
			  errorDetail.setExMsg(AzazTruckingExCodeEnum.MANDATORY_INPUT.getMessage() + " :" +"CallerRequestId");
			  errorDetailList.add(errorDetail);
		  }
		  
		  
		  if(StringUtils.isEmpty(azRequest.getCallerApplicationName())){
			  ErrorDetail errorDetail = new ErrorDetail();
			  errorDetail.setExCode(AzazTruckingExCodeEnum.MANDATORY_INPUT.getCode());
			  errorDetail.setExMsg(AzazTruckingExCodeEnum.MANDATORY_INPUT.getMessage() + " :" +"CallerApplicationName");
			  errorDetailList.add(errorDetail);
		  }
		  
		  if(StringUtils.isEmpty(azRequest.getCallerId())){
			  ErrorDetail errorDetail = new ErrorDetail();
			  errorDetail.setExCode(AzazTruckingExCodeEnum.MANDATORY_INPUT.getCode());
			  errorDetail.setExMsg(AzazTruckingExCodeEnum.MANDATORY_INPUT.getMessage() + " :" +"CallerId");
			  errorDetailList.add(errorDetail);
		  }
		  
		  
		  if(StringUtils.isEmpty(azRequest.getTaskName())){
			  ErrorDetail errorDetail = new ErrorDetail();
			  errorDetail.setExCode(AzazTruckingExCodeEnum.MANDATORY_INPUT.getCode());
			  errorDetail.setExMsg(AzazTruckingExCodeEnum.MANDATORY_INPUT.getMessage() + " :" +"TaskName");
			  errorDetailList.add(errorDetail);
		  }
		  
		  ErrorMessage message = new ErrorMessage(
	        HttpStatus.BAD_REQUEST.value(),
	        new Date(),
	        ex.getMessage(),
	        webRequest.getDescription(false),
	        errorDetailList);
		  azResponse.setErrorMessage(message);
		  azResponse.setAzId(azRequest.getAzId());
		  azResponse.setCallerApplicationName(azRequest.getCallerApplicationName());
		  azResponse.setCallerId(azRequest.getCallerId());
		  
		  
	    return new ResponseEntity<AzResponse>(azResponse, HttpStatus.OK);
	  }
  
  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<AzResponse> resourceNotFoundException(ResourceNotFoundException ex, WebRequest webRequest) {

	  AzRequest azRequest = (AzRequest) webRequest.getAttribute("azRequest", RequestAttributes.SCOPE_REQUEST);
	  System.out.println("azReqest" + azRequest.getCallerApplicationName());
	  AzResponse azResponse = new AzResponse();
	  List<ErrorDetail> errorDetailList = new ArrayList<>();
	  ErrorDetail errorDetail = new ErrorDetail();
		  
		  errorDetail.setExCode(AzazTruckingExCodeEnum.NOT_FOUND.getCode());
		  errorDetail.setExMsg(AzazTruckingExCodeEnum.NOT_FOUND.getMessage());
		  errorDetailList.add(errorDetail);
	  
	  
	  ErrorMessage message = new ErrorMessage(
        HttpStatus.NOT_FOUND.value(),
        new Date(),
        ex.getMessage(),
        webRequest.getDescription(false),
        errorDetailList);
	  azResponse.setErrorMessage(message);
	  azResponse.setAzId(azRequest.getAzId());
	  azResponse.setCallerApplicationName(azRequest.getCallerApplicationName());
	  azResponse.setCallerId(azRequest.getCallerId());
	  azResponse.setTaskName(azRequest.getTaskName());
	  
	  
    return new ResponseEntity<AzResponse>(azResponse, HttpStatus.OK);
  }

//  @ExceptionHandler(Exception.class)
//  public ResponseEntity<ErrorMessage> globalExceptionHandler(Exception ex, WebRequest request) {
//    ErrorMessage message = new ErrorMessage(
//        HttpStatus.INTERNAL_SERVER_ERROR.value(),
//        new Date(),
//        ex.getMessage(),
//        request.getDescription(false));
//    
//    return new ResponseEntity<ErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
//  }
//  

}