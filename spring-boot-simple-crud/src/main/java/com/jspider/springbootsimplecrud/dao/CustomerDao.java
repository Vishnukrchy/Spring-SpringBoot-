package com.jspider.springbootsimplecrud.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspider.springbootsimplecrud.dto.Customer;
import com.jspider.springbootsimplecrud.repository.CustomerRepository;

@Repository
public class CustomerDao {
	
	@Autowired
	private CustomerRepository customerRepository;
	public Customer saveCustomerDao(Customer customer) {
		return customerRepository.save(customer);
	}
	

	
}
