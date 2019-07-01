package com.senior.desafio.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="usuarios")
public class Usuario {
	
	@Id
	@Column(name="id_usuario")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idUsuario;
	
	@Column(name="nm_usuario")
	private String nmUsuario;
	
	@Column(name="ds_email", unique = true)
	private String dsEmail;
	
	@JsonIgnore
	@Column(name="ds_senha")
	private String dsSenha;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="usuarios_roles",
            joinColumns=@JoinColumn(name="usuarios_id_usuario"),
            inverseJoinColumns=@JoinColumn(name="roles_id_role")
    )
	private List<Role> roles;
	
	public Usuario() {
		
	}

	public Usuario(String nome, String email, String senha, List<Role> roles) {
		this.nmUsuario = nome;
		this.dsEmail = email;
		this.dsSenha = senha;
		this.roles = roles;
	}

	public Usuario(Usuario usuario) {
		super();
		this.nmUsuario = usuario.getNmUsuario();
		this.dsEmail = usuario.getDsEmail();
		this.dsSenha = usuario.getDsSenha();
		this.roles = usuario.getRoles();
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNmUsuario() {
		return nmUsuario;
	}

	public void setNmUsuario(String nmUsuario) {
		this.nmUsuario = nmUsuario;
	}

	public String getDsEmail() {
		return dsEmail;
	}

	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}

	public String getDsSenha() {
		return dsSenha;
	}

	public void setDsSenha(String dsSenha) {
		this.dsSenha = dsSenha;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
}
