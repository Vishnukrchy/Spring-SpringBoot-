package com.ibm.spring_web_mvc_crud.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

	@Id
	private Integer id;
	private String name;
	private String email;
	
	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] image;
	
	@Transient
	private String dispImage;

	public User(Integer id, String name, String email, String dispImage) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dispImage = dispImage;
	}
}
