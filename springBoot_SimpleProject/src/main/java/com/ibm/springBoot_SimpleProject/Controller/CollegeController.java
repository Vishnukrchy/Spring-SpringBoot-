package com.ibm.springBoot_SimpleProject.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.springBoot_SimpleProject.Dao.CollegeDao;
import com.ibm.springBoot_SimpleProject.Entity.College;

@RestController
public class CollegeController {
	@Autowired
	private CollegeDao collegeDao;

	@GetMapping(value = "/getTodaysDate")
	public String getDetails() {
		return "Today Date Is => " + LocalDate.now() + " ";
	}

	@PostMapping(value = "/saveCollege")
	public College saveCollge(@RequestBody College college) {
		System.out.println(college);
		collegeDao.saveCollegeDao(college);
		return college;
	}

	@PostMapping(value = "/savemultipleCollge")
	public List<College> saveCollegesController(@RequestBody List<College> colleges) {
		collegeDao.saveMultipleCollege(colleges);
		return colleges;
	}
 //only get the data
//	@GetMapping(value = "fetchCollegeById/{id}") // simply get The College Details
//	public College fetchCollegeByIdDao(@PathVariable int id) {
//		return collegeDao.fetchCollegeByIdDao(id);
//	}

	// get Data And Print some massage used ResponceEntity Class
	 @GetMapping(value = "/fetchCollegeById/{id}")
	    public ResponseEntity<Object> fetchCollegeById_1(@PathVariable Integer id) {
	        College college = collegeDao.fetchCollegeByIdDao(id);
	        if (college != null) {
	            return new ResponseEntity<>(college, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("Given ID is Not Found", HttpStatus.NOT_FOUND);
	        }
	    }

	//print All Data without massage
	@GetMapping(value = "/fetchAllCollege")
	public List<College> fetchAllCollegeDetails() {
		List<College> fetchAllCollege = collegeDao.fetchAllCollege();
		return fetchAllCollege;

	}
	 // Get all College Data And Print The Massage From the User Side we use ResponseEntity Class
//	 @GetMapping(value = "/fetchAllCollege")
//	 public ResponseEntity<List<College>> getAllCollegeController() {
//		 return new ResponseEntity<List<College>>(collegeDao.fetchAllCollege(),HttpStatus.OK);
//	}

	@DeleteMapping(value = "/deletCollegeBy")
	// @RequestParam is used to passed the details at key and value in Postman
	public ResponseEntity<?> deleteCollegeById(@RequestParam int id) {
		return collegeDao.deleteProduct(id);

	}

	@PutMapping(value = "updateCollegeById/{id}")
	public College updateCollegeById(@PathVariable int id, @RequestBody College college) {
		return collegeDao.updateCollegeById(id, college);
	}

	@PutMapping(value = "updateCollegeById_1")
	public ResponseEntity<String> updateCollegeById_1(@RequestParam int id, @RequestBody College college) {
		return collegeDao.updateProductByid_1(id, college);
	}

	@GetMapping(value = "/getCollegeDetails")
	public List<College> getCollegeByName(@RequestParam String name) {
		return collegeDao.getCollegeByName(name);
	}
}
