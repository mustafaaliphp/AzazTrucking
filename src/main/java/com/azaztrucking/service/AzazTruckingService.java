package com.azaztrucking.service;

import static com.azaztrucking.constant.AzazTruckingConstants.GET_ALL_DRIVERS;
import static com.azaztrucking.constant.AzazTruckingConstants.ADD_DRIVER;
import org.springframework.stereotype.Service;

import com.azaztrucking.common.AzazTruckingCommonUtils;
import com.azaztrucking.exception.AzazTruckingExceptions.GlobalExceptionHandler;
import com.azaztrucking.exception.AzazTruckingExceptions.InvalidInputException;
import com.azaztrucking.handler.AddDriverHandler;
import com.azaztrucking.handler.GetAllDriversHandler;
import com.azaztrucking.model.AzazTruckingRequest;
import com.azaztrucking.model.AzazTruckingResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class AzazTruckingService {

	private final GetAllDriversHandler getAllDriversHandler;
	private final AddDriverHandler addDriverHandler;;
	public AzazTruckingResponse processAZInq(AzazTruckingRequest azazTruckingRequest) {
		
		log.info("[BEGIN] - processAzInq method: ");
		log.info("Access Time : " + AzazTruckingCommonUtils.getTime());
		AzazTruckingResponse azazTruckingResponse = new AzazTruckingResponse();
		try {
			log.debug("[BEGIN] - processAzInq method in try block: ");
			log.debug("Access Time : " + AzazTruckingCommonUtils.getTime());
			String taskName = azazTruckingRequest.getTaskName();
			switch(taskName) {
			case GET_ALL_DRIVERS:
				azazTruckingResponse = getAllDriversHandler.getDrivers(azazTruckingRequest);
				log.debug("GET_ALL_DRIVERS : " + azazTruckingResponse);
				break;
			case ADD_DRIVER:
				azazTruckingResponse = addDriverHandler.addDriver(azazTruckingRequest);
				log.debug("ADD_DRIVER : " + azazTruckingResponse);
				break;
			default:
				throw new InvalidInputException("Invalid Task Name");
				
			}
			
		}catch(GlobalExceptionHandler ex) {
			log.error("Issue with processAZInq method - {}", ex.getMessage());
			throw new GlobalExceptionHandler("Internal Server Error");
		}catch(Exception ex) {
			log.error("Issue with processAZInq method - {}", ex.getMessage());
			throw new GlobalExceptionHandler(ex.getMessage());
		}finally {
			log.info("End processAzInq: " + azazTruckingRequest);
		}
		return azazTruckingResponse;
		
	}
}
