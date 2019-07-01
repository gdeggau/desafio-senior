package com.senior.desafio.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.client.resource.UserRedirectRequiredException;
import org.springframework.stereotype.Service;

import com.senior.desafio.model.Role;
import com.senior.desafio.model.Usuario;
import com.senior.desafio.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> findAll(){
		return usuarioRepository.findAll();
	}
	
	public Usuario findByIdUsuario (Long id) {
		return usuarioRepository.findByIdUsuario(id);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = usuarioRepository.findByDsEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Usuário ou senha incorretos!");
		}
		return new UsuarioRepositoryUserDetails(user);
	}
	
	private final static class UsuarioRepositoryUserDetails extends Usuario implements UserDetails{

		public UsuarioRepositoryUserDetails(Usuario usuario) {
			super(usuario);
			// TODO Auto-generated constructor stub
		}
		

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			// TODO Auto-generated method stub
			return getRoles();
		}

		@Override
		public String getPassword() {
			// TODO Auto-generated method stub
			return super.getDsSenha();
		}

		@Override
		public String getUsername() {
			// TODO Auto-generated method stub
			return this.getDsEmail();
		}

		@Override
		public boolean isAccountNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return true;
		}
		
	}

}
