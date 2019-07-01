package com.senior.desafio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="roles")
public class Role implements GrantedAuthority{

	@Id
	@Column(name="id_role")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idRole;
	
	@Column(name="nm_role")
	private String nmRole;

	@Override
	public String getAuthority() {
		return this.nmRole;
	}
	
	public Role() {
		
	}

	public long getIdRole() {
		return idRole;
	}

	public void setIdRole(long idRole) {
		this.idRole = idRole;
	}

	public String getNmRole() {
		return nmRole;
	}

	public void setNmRole(String nmRole) {
		this.nmRole = nmRole;
	}
	
}
