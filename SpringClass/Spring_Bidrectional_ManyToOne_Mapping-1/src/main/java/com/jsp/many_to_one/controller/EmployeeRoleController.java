package com.jsp.many_to_one.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.many_to_one.model.Employee;
import com.jsp.many_to_one.model.Role;
import com.jsp.many_to_one.service.EmployeeService;
import com.jsp.many_to_one.service.RoleService;

@RestController
@RequestMapping("api")
public class EmployeeRoleController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private RoleService roleService;

    @GetMapping(path = "/get/employees")
    public ResponseEntity<List<Employee>> getEmployees() {
        return ResponseEntity.ok().body(employeeService.getAllEmployees());
    }

    @GetMapping(path = "/get_employees_by_id/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(employeeService.getEmployeeById(id));
    }

    @PostMapping(path = "/save/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.createEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping(path = "/get/roles")
    public ResponseEntity<List<Role>> getRoles() {
        return ResponseEntity.ok().body(roleService.getAllRoles());
    }

    @GetMapping(path = "/get_roles_by_id/{id}")
    public ResponseEntity<Role> getRole(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(roleService.getRoleById(id));
    }

    @PostMapping(path = "/save/employee/roles")
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        return new ResponseEntity<>(roleService.createRole(role), HttpStatus.CREATED);
    }

}
