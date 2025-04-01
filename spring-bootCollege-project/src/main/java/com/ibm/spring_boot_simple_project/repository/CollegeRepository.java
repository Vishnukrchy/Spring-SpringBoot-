package com.ibm.spring_boot_simple_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ibm.spring_boot_simple_project.dto.College;

public interface CollegeRepository extends JpaRepository<College, Integer>{
	
	// To fetch single data by the given condition using query related to that condition
	
	public College findByName(String name);  // it will generate the query 
//	public List<College> findByName(String name); 
	
	/*
	 if there is multiple data with the same condition then we use list 
	 jis bhi condition se aapko data find karna hai to method name me condition ke sath entity class kk variable ka same name likhna 
	 either in capital or small or pass same variable in argument with same datatype
	 
	 */
	
//	@Query(value="SELECT c FROM College c Where c.type=?1") //  By jpql query
	@Query(value="SELECT * FROM College Where Type=?1 " , nativeQuery = true)
	public List<College> getCollegeByType(String type);
}

