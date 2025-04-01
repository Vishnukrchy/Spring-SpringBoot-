package com.ibm.springBoot_SimpleProject.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
public class College {
	@Id
	private int id;
	private String name;
	private String address;
	private String type;

//	public College(int id, String name, String address, String type) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.address = address;
//		this.type = type;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "College [id=" + id + ", name=" + name + ", address=" + address + ", type=" + type + "]";
	}



}
