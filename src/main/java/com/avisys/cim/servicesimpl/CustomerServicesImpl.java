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
	public Customer findByMobileNumber(String mobileNumber) {
		// TODO Auto-generated method stub
		Customer customersByMobileNumber = this.customerRepository.findByMobileNumber(mobileNumber);
		return customersByMobileNumber;
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		// TODO Auto-generated method stub 
		if(customerRepository.findByMobileNumber(customer.getMobileNumber()) != null) throw new RuntimeException("Unable to create Customer. Mobile number already present.");
			
		return this.customerRepository.save(customer);
	}

	@Override
	public Customer updateCustomer(String mobileNumber, Customer customer) {
		// TODO Auto-generated method stub
		
		Customer updateCustomer = this.customerRepository.findByMobileNumber(mobileNumber);
		if(updateCustomer == null) throw new RuntimeException( "Customer with given mobile number dose not exist");
		
		updateCustomer.setFirstName(customer.getFirstName());
		updateCustomer.setLastName(customer.getLastName());
		updateCustomer.setMobileNumber(customer.getMobileNumber());

		this.customerRepository.save(updateCustomer);
		return updateCustomer;
	}



}
