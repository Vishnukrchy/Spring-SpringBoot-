package com.ibm.springBoot_SimpleProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ibm.springBoot_SimpleProject.Entity.College;

public interface CollegeRepository extends JpaRepository<College, Integer>{
	//@Query annotation  Is  used To Write JPQL Query
   @Query(  value= "select c from College as c where c.name=:name")
	List<College> findByName(String name);

}
