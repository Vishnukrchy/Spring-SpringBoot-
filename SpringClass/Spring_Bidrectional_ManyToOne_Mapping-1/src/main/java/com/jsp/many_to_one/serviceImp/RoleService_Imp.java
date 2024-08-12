package com.jsp.many_to_one.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.many_to_one.model.Role;
import com.jsp.many_to_one.repository.EmployeeRepository;
import com.jsp.many_to_one.repository.RoleRepository;
import com.jsp.many_to_one.service.RoleService;
@Service
public class RoleService_Imp implements RoleService {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<Role> getAllRoles() {
		List<Role> all = roleRepository.findAll();
		return all;
	}

	@Override
	public Role getRoleById(Long id) {
		Optional<Role> byId = roleRepository.findById(id);
		Role role = null;
		if (byId.isPresent()) {
			role = byId.get();
		}
		return role;

	}

	@Override
	public Role createRole(Role role) {
		Role save = roleRepository.save(role);
		return save;

	}

}
