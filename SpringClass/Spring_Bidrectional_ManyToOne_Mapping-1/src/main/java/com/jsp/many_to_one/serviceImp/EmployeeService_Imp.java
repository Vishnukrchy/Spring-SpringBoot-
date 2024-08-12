package com.jsp.many_to_one.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.many_to_one.model.Employee;
import com.jsp.many_to_one.repository.EmployeeRepository;
import com.jsp.many_to_one.repository.RoleRepository;
import com.jsp.many_to_one.service.EmployeeService;
@Service
public class EmployeeService_Imp implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> all = employeeRepository.findAll();
		return all;
	}

	@Override
	public Employee getEmployeeById(Long id) {
		Optional<Employee> byId = employeeRepository.findById(id);
		Employee employee = null;
		if (byId.isPresent()) {
			employee = byId.get();
		}
		return employee;

	}

	@Override
	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

}
