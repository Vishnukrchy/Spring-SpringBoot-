package com.jspider.springbootsimplecrud.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Customer {
	
	@Id
	private int id;
	private String name;
	private String email;
	private long phone;
	
	

}
