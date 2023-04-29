package com.avisys.cim.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avisys.cim.Customer;
import com.avisys.cim.repository.CustomerRepository;
import com.avisys.cim.services.CustomerServises;


@Service
public class CustomerServicesImpl implements CustomerServises {

	@Autowired 
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		List<Customer> allCustomers = this.customerRepository.findAll();
		return allCustomers;
	}

	@Override
	public List<Customer> findByFirstName(String firstName) {
		// TODO Auto-generated method stub
		List<Customer> customersByFirstName = this.customerRepository.findByFirstName(firstName);
		return customersByFirstName;
	}

	@Override
	public List<Customer> findByLastName(String lastName) {
		// TODO Auto-generated method stub
		List<Customer> customersByLastName = this.customerRepository.findByLastName(lastName);
		return customersByLastName;
	}

	@Override
	public List<Customer> findByMobileNumber(String mobileNumber) {
		// TODO Auto-generated method stub
		List<Customer> customersByMobileNumber = this.customerRepository.findByMobileNumber(mobileNumber);
		return customersByMobileNumber;
	}

}
