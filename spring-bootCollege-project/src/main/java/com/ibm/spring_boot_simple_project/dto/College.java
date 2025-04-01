package com.ibm.spring_boot_simple_project.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class College {
	
	@Id
	private int id;
	private String name;
	private String address;
	private String type;

}
