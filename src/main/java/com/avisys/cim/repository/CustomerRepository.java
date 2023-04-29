package com.avisys.cim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.avisys.cim.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	@Query("SELECT c FROM Customer c WHERE LOWER(c.firstName) LIKE LOWER(CONCAT('%', :firstName, '%'))")
    List<Customer> findByFirstName(@Param("firstName") String firstName);
	
	@Query("SELECT c FROM Customer c WHERE LOWER(c.lastName) LIKE LOWER(CONCAT('%', :lastName, '%'))")
    List<Customer> findByLastName(@Param("lastName") String lastName);
	
	@Query("SELECT c FROM Customer c WHERE c.mobileNumber =:mobileNumber")
	List<Customer> findByMobileNumber(@Param("mobileNumber") String mobileNumber);
}
