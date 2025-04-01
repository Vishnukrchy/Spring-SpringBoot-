package com.ibm.spring_boot_simple_project.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.spring_boot_simple_project.dao.CollegeDao;
import com.ibm.spring_boot_simple_project.dto.College;

@RestController
public class CollegeController {
	
	@Autowired
	private CollegeDao collegeDao;
	
	@GetMapping(value="/getTodaysDate")
	public String getData() {
		return "Today's Date is "+LocalDate.now()+" ";
	}
	
	@PostMapping(value="/saveCollege") // (It is used to save the data)
	public College saveCollegeController(@RequestBody College college) {
//		System.out.println(college);
		collegeDao.saveCollegeDao(college);
		return college;
	}
	
	@PostMapping(value="/saveMultipleCollege")
	public List<College> saveMultipleCollegeController(@RequestBody List<College> college){
		collegeDao.saveMultipleCollegeDao(college);
		return college;
	}
	
	@GetMapping(value="/fetchCollegeById/{collegeId}")
	public ResponseEntity<Object> fetchCollegeByIdController(@PathVariable int collegeId) {
		College college= collegeDao.fetchCollegeByIdDao(collegeId);
		if(college!=null) {
			return new ResponseEntity<Object>(college, HttpStatusCode.valueOf(200)); 
		}else {
			return new ResponseEntity<Object>("given id is not found", HttpStatusCode.valueOf(404));
		}
	}
	
	
	// To fetch all data 
	@GetMapping(value="/getAllCollegeData")
	public List<College> getAllCollegeController(){
		return collegeDao.getAllCollegeDao();
	}
	
	// code to fetch all data and print message from user side we use response entity class 
	@GetMapping(value="/getAllCollegeData")
	public ResponseEntity<List<College>> getAllCollegeController(){
		return new ResponseEntity<List<College>>(collegeDao.getAllCollegeDao(), HttpStatus.OK) ;
	}
	
	
	// when single data is present with the given condition 
	@GetMapping(value="/getCollegeByName/{name}")
	public College getCollegeByNameController(@PathVariable String name) {
		return collegeDao.getCollegeByNameDao(name);
	}
	
	// when multiple data is present with the given condition
//	@GetMapping(value="/getCollegeByName/{name}")
//	public List<College> getCollegeByNameController(@PathVariable String name) {
//		return collegeDao.getCollegeByNameDao(name);
//	}
	
	@GetMapping(value="/getCollegeByType/{type}")
	public List<College> getCollegeByTypeDao(@PathVariable String type){
		return collegeDao.getCollegeByTypeDao(type);
	}
}


