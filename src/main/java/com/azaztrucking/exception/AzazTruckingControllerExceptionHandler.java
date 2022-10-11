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
import com.azaztrucking.exception.AzazTruckingExceptions.GlobalExceptionHandler;
import com.azaztrucking.exception.AzazTruckingExceptions.InvalidInputException;
import com.azaztrucking.exception.AzazTruckingExceptions.MissingInputException;
import com.azaztrucking.exception.AzazTruckingExceptions.ResourceNotFoundException;
import com.azaztrucking.exception.AzazTruckingExceptions.SQLExceptionHandler;
import com.azaztrucking.model.AzazTruckingRequest;
import com.azaztrucking.model.AzazTruckingResponse;
import com.azaztrucking.model.ErrorDetail;
import com.azaztrucking.model.ErrorMessage;

import lombok.extern.slf4j.Slf4j;


@ControllerAdvice
@Slf4j
public class AzazTruckingControllerExceptionHandler {

	  //@ResponseStatus(HttpStatus.BAD_REQUEST)
	  @ExceptionHandler(MissingInputException.class)
	  public ResponseEntity<AzazTruckingResponse> missingInputException(MissingInputException ex, WebRequest webRequest) {
		  log.error("missingInputException occured : ", ex);
		  AzazTruckingRequest azazTruckingRequest = (AzazTruckingRequest) webRequest.getAttribute("azRequest", RequestAttributes.SCOPE_REQUEST);
		  AzazTruckingResponse azazTruckingResponse = new AzazTruckingResponse();
		  List<ErrorDetail> errorDetailList = new ArrayList<>();
		  
		  if(StringUtils.isEmpty(azazTruckingRequest.getCallerRequestId())){
			  ErrorDetail errorDetail = new ErrorDetail();
			  errorDetail.setExCode(AzazTruckingExCodeEnum.MANDATORY_INPUT.getCode());
			  errorDetail.setExMsg(AzazTruckingExCodeEnum.MANDATORY_INPUT.getMessage() + " :" +"CallerRequestId");
			  errorDetailList.add(errorDetail);
		  }
		  
		  
		  if(StringUtils.isEmpty(azazTruckingRequest.getCallerApplicationName())){
			  ErrorDetail errorDetail = new ErrorDetail();
			  errorDetail.setExCode(AzazTruckingExCodeEnum.MANDATORY_INPUT.getCode());
			  errorDetail.setExMsg(AzazTruckingExCodeEnum.MANDATORY_INPUT.getMessage() + " :" +"CallerApplicationName");
			  errorDetailList.add(errorDetail);
		  }
		  
		  if(StringUtils.isEmpty(azazTruckingRequest.getCallerId())){
			  ErrorDetail errorDetail = new ErrorDetail();
			  errorDetail.setExCode(AzazTruckingExCodeEnum.MANDATORY_INPUT.getCode());
			  errorDetail.setExMsg(AzazTruckingExCodeEnum.MANDATORY_INPUT.getMessage() + " :" +"CallerId");
			  errorDetailList.add(errorDetail);
		  }
		  
		  
		  if(StringUtils.isEmpty(azazTruckingRequest.getTaskName())){
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
		  azazTruckingResponse.setErrorMessage(message);
		  azazTruckingResponse.setAzId(azazTruckingRequest.getAzId());
		  azazTruckingResponse.setCallerApplicationName(azazTruckingRequest.getCallerApplicationName());
		  azazTruckingResponse.setCallerId(azazTruckingRequest.getCallerId());
		  azazTruckingResponse.setStatus("Fail");
		  azazTruckingResponse.setCode("-1");
		  
		  
	    return new ResponseEntity<AzazTruckingResponse>(azazTruckingResponse, HttpStatus.OK);
	  }
  
  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<AzazTruckingResponse> resourceNotFoundException(ResourceNotFoundException ex, WebRequest webRequest) {

	  AzazTruckingRequest azazTruckingRequest = (AzazTruckingRequest) webRequest.getAttribute("azRequest", RequestAttributes.SCOPE_REQUEST);
	  System.out.println("azReqest" + azazTruckingRequest.getCallerApplicationName());
	  AzazTruckingResponse azazTruckingResponse = new AzazTruckingResponse();
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
	  azazTruckingResponse.setErrorMessage(message);
	  azazTruckingResponse.setAzId(azazTruckingRequest.getAzId());
	  azazTruckingResponse.setCallerApplicationName(azazTruckingRequest.getCallerApplicationName());
	  azazTruckingResponse.setCallerId(azazTruckingRequest.getCallerId());
	  azazTruckingResponse.setTaskName(azazTruckingRequest.getTaskName());
	  azazTruckingResponse.setStatus("Fail");
	  azazTruckingResponse.setCode("-1");
	  
	  
    return new ResponseEntity<AzazTruckingResponse>(azazTruckingResponse, HttpStatus.OK);
  }

  
  @ExceptionHandler(InvalidInputException.class)
  public ResponseEntity<AzazTruckingResponse> invalidInputException(InvalidInputException ex, WebRequest webRequest) {

	  AzazTruckingRequest azazTruckingRequest = (AzazTruckingRequest) webRequest.getAttribute("azRequest", RequestAttributes.SCOPE_REQUEST);
	  System.out.println("azReqest" + azazTruckingRequest.getCallerApplicationName());
	  AzazTruckingResponse azazTruckingResponse = new AzazTruckingResponse();
	  List<ErrorDetail> errorDetailList = new ArrayList<>();
	  ErrorDetail errorDetail = new ErrorDetail();
		  
		  errorDetail.setExCode(AzazTruckingExCodeEnum.INVALID_INPUT.getCode());
		  errorDetail.setExMsg(AzazTruckingExCodeEnum.INVALID_INPUT.getMessage());
		  errorDetailList.add(errorDetail);
	  
	  
	  ErrorMessage message = new ErrorMessage(
        HttpStatus.BAD_REQUEST.value(),
        new Date(),
        ex.getMessage(),
        webRequest.getDescription(false),
        errorDetailList);
	  azazTruckingResponse.setErrorMessage(message);
	  azazTruckingResponse.setAzId(azazTruckingRequest.getAzId());
	  azazTruckingResponse.setCallerApplicationName(azazTruckingRequest.getCallerApplicationName());
	  azazTruckingResponse.setCallerId(azazTruckingRequest.getCallerId());
	  azazTruckingResponse.setTaskName(azazTruckingRequest.getTaskName());
	  azazTruckingResponse.setStatus("Fail");
	  azazTruckingResponse.setCode("-1");
	  
	  
    return new ResponseEntity<AzazTruckingResponse>(azazTruckingResponse, HttpStatus.OK);
  }
  //SQLExceptionHandler
  @ExceptionHandler(SQLExceptionHandler.class)
  public ResponseEntity<AzazTruckingResponse> sqlExceptionHandler(SQLExceptionHandler ex, WebRequest webRequest) {

	  AzazTruckingRequest azazTruckingRequest = (AzazTruckingRequest) webRequest.getAttribute("azRequest", RequestAttributes.SCOPE_REQUEST);
	  AzazTruckingResponse azazTruckingResponse = new AzazTruckingResponse();
	  List<ErrorDetail> errorDetailList = new ArrayList<>();
	  ErrorDetail errorDetail = new ErrorDetail();
		  
		  errorDetail.setExCode(AzazTruckingExCodeEnum.SQL_EXCEPTION.getCode());
		  errorDetail.setExMsg(AzazTruckingExCodeEnum.SQL_EXCEPTION.getMessage());
		  errorDetailList.add(errorDetail);
	  
	  
	  ErrorMessage message = new ErrorMessage(
        HttpStatus.INTERNAL_SERVER_ERROR.value(),
        new Date(),
        ex.getMessage(),
        webRequest.getDescription(false),
        errorDetailList);
	  azazTruckingResponse.setErrorMessage(message);
	  azazTruckingResponse.setAzId(azazTruckingRequest.getAzId());
	  azazTruckingResponse.setCallerApplicationName(azazTruckingRequest.getCallerApplicationName());
	  azazTruckingResponse.setCallerId(azazTruckingRequest.getCallerId());
	  azazTruckingResponse.setTaskName(azazTruckingRequest.getTaskName());
	  azazTruckingResponse.setStatus("Fail");
	  azazTruckingResponse.setCode("-1");
	  
	  
    return new ResponseEntity<AzazTruckingResponse>(azazTruckingResponse, HttpStatus.OK);
  }
  @ExceptionHandler(value = {Exception.class, GlobalExceptionHandler.class})
  public ResponseEntity<AzazTruckingResponse> globalExceptionHandler(GlobalExceptionHandler ex, WebRequest webRequest) {
	  AzazTruckingRequest azazTruckingRequest = (AzazTruckingRequest) webRequest.getAttribute("azRequest", RequestAttributes.SCOPE_REQUEST);

	  AzazTruckingResponse azazTruckingResponse = new AzazTruckingResponse();
	  List<ErrorDetail> errorDetailList = new ArrayList<>();
	  ErrorDetail errorDetail = new ErrorDetail();
	  
	  errorDetail.setExCode(AzazTruckingExCodeEnum.INTERNAL_SERVER_ERROR.getCode());
	  errorDetail.setExMsg(AzazTruckingExCodeEnum.INTERNAL_SERVER_ERROR.getMessage());
	  errorDetailList.add(errorDetail);
	  
    ErrorMessage message = new ErrorMessage(
        HttpStatus.INTERNAL_SERVER_ERROR.value(),
        new Date(),
        ex.getMessage(),
        webRequest.getDescription(false),
        errorDetailList);
	  azazTruckingResponse.setErrorMessage(message);
	  azazTruckingResponse.setAzId(azazTruckingRequest.getAzId());
	  azazTruckingResponse.setCallerApplicationName(azazTruckingRequest.getCallerApplicationName());
	  azazTruckingResponse.setCallerId(azazTruckingRequest.getCallerId());
	  azazTruckingResponse.setTaskName(azazTruckingRequest.getTaskName());
	  azazTruckingResponse.setStatus("Fail");
	  azazTruckingResponse.setCode("-1");
  return new ResponseEntity<AzazTruckingResponse>(azazTruckingResponse, HttpStatus.OK);
  }


}