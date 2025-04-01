package com.jspider.springbootsimplecrud.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspider.springbootsimplecrud.dao.CustomerDao;
import com.jspider.springbootsimplecrud.dto.Customer;

@RestController
public class CustomerController {

	
//	creating object of customerDao
	
	@Autowired 
	private CustomerDao customerDao;
	
//	here value = "/getData" is the endpoint of my project by using this with port "localhost:8080/myendpointname", i can run my project on webpage or postman.
		@GetMapping(value ="/getData")
		public String getUserName() {
			return "My first String Program "+ LocalDate.now();
		}
		
		@GetMapping(value= "/addTwoNumber/{a}/{b}")
		public double addTwoNumber(@PathVariable int a, @PathVariable int b) {
			return a+b;
			
		}
		
//		 to return single data
//		@GetMapping(value = "/saveCustomer")
//		public long saveCustomerController(@RequestBody Customer customer) {
//			return customer.getPhone();
//		}
//		
//		to get all data 
		@GetMapping(value = "/getCustomer")
		public Customer getCustomerController(@RequestBody Customer customer) {
			return customer;
		}
		
//		To saveCustomer using repositoryClass
		
		@GetMapping(value = "/saveCustomer")
		public Customer saveCustomerController(@RequestBody Customer customer) {
			return customerDao.saveCustomerDao(customer);
		}
}
