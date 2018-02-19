package com.bhasad.api.controller;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bhasad.api.domain.model.Employee;
import com.bhasad.api.repository.EmployeeRepository;


@RestController
@RequestMapping(value = "/api/v1")
public class bhasadEmpCrudController {

	private static final Logger LOGGER = LoggerFactory.getLogger(bhasadEmpCrudController.class);
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/employees/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> findData (
			@RequestHeader (value = "uuid", required = true) String uuid,
			@RequestHeader (value = "Accept", required = false) String accept,
			@RequestHeader (value = "Accept-Language", required = false) String acceptLanguage,
			@RequestHeader (value = "Content-Type", required = false) String contentType

	) throws Exception {
		
		LOGGER.info("Inside Controller::findAllEmployees");
		return new ResponseEntity<List<Employee>>(employeeRepository.findAll(), HttpStatus.OK);

	}
	
	@RequestMapping(value = "/employees/salesCount", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> findSalesRep (
			@RequestHeader (value = "uuid", required = true) String uuid,
			@RequestHeader (value = "Accept", required = false) String accept,
			@RequestHeader (value = "Accept-Language", required = false) String acceptLanguage,
			@RequestHeader (value = "Content-Type", required = false) String contentType

	) throws Exception {
		
		LOGGER.info("Inside Controller::findSalesRep");
		ResultSet rs = employeeRepository.returnSalesRep("Sales Rep");
		return new ResponseEntity<String>(rs.toString(), HttpStatus.OK);
	}
	
}