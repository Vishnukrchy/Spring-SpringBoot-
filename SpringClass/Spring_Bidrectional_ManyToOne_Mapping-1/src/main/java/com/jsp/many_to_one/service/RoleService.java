package com.jsp.many_to_one.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.many_to_one.model.Role;
import com.jsp.many_to_one.repository.RoleRepository;

@Service
public interface RoleService {


    public List<Role> getAllRoles();

    public Role getRoleById(Long id);

    public Role createRole(Role role);

}
