package com.ibm.springBoot_SimpleProject.Dao;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.ibm.springBoot_SimpleProject.Entity.College;
import com.ibm.springBoot_SimpleProject.repository.CollegeRepository;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManagerFactory;

@Repository // the class which is directly communicate with database this annotation inform
			// the complier in this class only database
// related code are written and its become part of spring Container

public class CollegeDao {
	@Autowired
	CollegeRepository collegeRepository;

	public College saveCollegeDao(College college) {
		/*
		 * collegeRepository.save() Method are used to save the single object
		 */
		return collegeRepository.save(college);
	}

	public List<College> saveMultipleCollege(List<College> listcolleges) {

		return collegeRepository.saveAll(listcolleges);

	}

	public College fetchCollegeByIdDao(int id) {
		Optional<College> optional = collegeRepository.findById(id);
		if (optional.isPresent()) {
			College college = (College) optional.get();// this is retrun as an object
//		return (College)optional.get();
			return college;
		} else {
			return null;
		}
	}
  // Fetch All Data
	public List<College> fetchAllCollege() {
		List<College> colleges = collegeRepository.findAll();
		if (colleges != null) {
			return colleges;
		} else {
			return null;
		}

	}
	
//	public ResponseEntity<List<College>> fetchAllCollegeWithMassage() {
//		//return new ResponseEntity<List<College>>(colleged)
//	}

	public ResponseEntity<String> deleteProduct(int id) {
		collegeRepository.deleteById(id);
		return ResponseEntity.ok(" Data is Deletd Sucessfully");
	}

	public College updateCollegeById(int id, College updatecollege) {

		Optional optional = collegeRepository.findById(id);

		if (optional.isPresent()) {
			College college = (College) optional.get();
			// Set the Updated College Details
			college.setName(updatecollege.getName());
			college.setAddress(updatecollege.getAddress());
			// After The Set we have to Save The in College With The Helped Of save(college)
			// Method
			return collegeRepository.save(college);
		} else {
			return null;
		}
	}

	public ResponseEntity<String> updateProductByid_1(int id, College uptcollCollege) {
		Optional optional = collegeRepository.findById(id);
		if (optional.isPresent()) {
			College college = (College) optional.get();
			// Set the Updated College Details
			college.setName(uptcollCollege.getName());
			college.setType(uptcollCollege.getType());
			college.setAddress(uptcollCollege.getAddress());
			// After The Set we have to Save The in College With The Helped Of save(college)
			// Method
			College saveCollege = collegeRepository.save(college);
			return ResponseEntity.ok(" College Details Updated Sucessfully");
		} else {
			return null;
		}
	}
	
	public List<College> getCollegeByName(String name) {
	

		List<College> listcollege=collegeRepository.findByName(name);
		return listcollege;
		
	}
	
	
}
