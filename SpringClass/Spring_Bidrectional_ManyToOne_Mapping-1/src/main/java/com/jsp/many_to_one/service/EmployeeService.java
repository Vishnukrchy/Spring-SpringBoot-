package com.jsp.many_to_one.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.many_to_one.model.Employee;
import com.jsp.many_to_one.repository.EmployeeRepository;


public interface EmployeeService {

    public List<Employee> getAllEmployees();

    public Employee getEmployeeById(Long id);

    public Employee createEmployee(Employee employee);

}
