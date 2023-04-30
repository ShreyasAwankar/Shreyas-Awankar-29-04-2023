package com.avisys.cim.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avisys.cim.Customer;
import com.avisys.cim.services.CustomerServises;

@RestController
@RequestMapping("/cim/api")
public class CustomerController {
	
	@Autowired
	private CustomerServises customerServices;
	
	@GetMapping("/get-all-customers")
	public ResponseEntity <List<Customer>> getAllCustomers(){
		List<Customer> allCustomers = this.customerServices.getAllCustomers();
		return new ResponseEntity <List<Customer>>(allCustomers, HttpStatus.OK);
	}
	
	@GetMapping("/get-customers-by-first-name/{firstName}")
	public ResponseEntity <List<Customer>> getCustomersByFirstName(@PathVariable String firstName){
	List<Customer> customersMatchedByFirstName = this.customerServices.findByFirstName(firstName);
	return new ResponseEntity <List<Customer>>(customersMatchedByFirstName, HttpStatus.OK);
	}
	
	@GetMapping("/get-customers-by-last-name/{lastName}")
	public ResponseEntity <List<Customer>> getCustomersByLastName(@PathVariable String lastName){
	List<Customer> customersMatchedByLastName = this.customerServices.findByLastName(lastName);
	return new ResponseEntity <List<Customer>>(customersMatchedByLastName, HttpStatus.OK);
	}

	@GetMapping("/get-customers-by-mobile-number/{mobileNumber}")
	public ResponseEntity <Customer> getCustomersByMobileNumber(@PathVariable String mobileNumber){
	Customer customerMatchedByMobileNumber = this.customerServices.findByMobileNumber(mobileNumber);
	return new ResponseEntity <Customer>(customerMatchedByMobileNumber, HttpStatus.OK);
	}
	
	@PostMapping("/new-customer")
	public ResponseEntity <Customer> saveNewCustomer(@RequestBody Customer customer){
		Customer newCustomer = this.customerServices.saveCustomer(customer);
		return new ResponseEntity<Customer> (newCustomer, HttpStatus.CREATED);
	}
	
	@PutMapping("/update-customer/{mobileNumber}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable String mobileNumber, @RequestBody Customer customer){
		Customer updateCustomer = this.customerServices.updateCustomer(mobileNumber, customer);
		return new ResponseEntity<Customer> (updateCustomer, HttpStatus.OK);
	}
	
	
}
