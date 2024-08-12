package com.jsp.many_to_one.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.many_to_one.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
