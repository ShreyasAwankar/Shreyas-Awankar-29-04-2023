package com.avisys.cim.services;

import java.util.List;

import com.avisys.cim.Customer;

public interface CustomerServises {

	List <Customer> getAllCustomers();
	
	List <Customer> findByFirstName(String FirstName);
	
	List<Customer> findByLastName(String lastName);
	
	List<Customer> findByMobileNumber(String mobileNumber);

}
