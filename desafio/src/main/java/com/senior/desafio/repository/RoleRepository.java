package com.senior.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senior.desafio.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	
	Role findByNmRole(String nome);

}
