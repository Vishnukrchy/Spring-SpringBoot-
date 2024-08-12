package com.jsp.many_to_one.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.many_to_one.model.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
