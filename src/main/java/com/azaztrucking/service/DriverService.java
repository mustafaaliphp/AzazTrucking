package com.azaztrucking.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.azaztrucking.doa.DriverDAO;
import com.azaztrucking.exception.ResourceNotFoundException;
import com.azaztrucking.model.Driver;

@Service
public class DriverService {

	@Autowired 
	DriverDAO driverDAO;
	@Transactional
	public int insertDriver(Driver driver) {

		try {
			
			driverDAO.insertDriver(driver);
		}
		catch(Exception ex) {
			throw new ResourceNotFoundException("Sql exception");
		}
		return 1;
	}
	
	public List<Driver> findAllDrivers(){
		return driverDAO.findAllDrivers();
	}
	
	public Driver findDriver(Long driverID) {
		return driverDAO.findDriver(driverID);
	}
	
	public List<Driver> getListOfDriverByEmail(String eamil){
		return driverDAO.findDriversByEmail(eamil);
	}
	
	
}
