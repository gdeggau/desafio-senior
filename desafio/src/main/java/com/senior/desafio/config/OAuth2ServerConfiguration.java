package com.senior.desafio.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import com.senior.desafio.service.UsuarioService;

@Configuration
public class OAuth2ServerConfiguration extends ResourceServerConfigurerAdapter{
	
	private static final String RESOURCE_ID = "restservice";

	@Configuration
    @EnableResourceServer
    protected static class ResourceServerConfiguration extends
            ResourceServerConfigurerAdapter {

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) {
            resources
                    .resourceId(RESOURCE_ID);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http
                    .logout()
                    .invalidateHttpSession(true)
                    .clearAuthentication(true)
                    .and().authorizeRequests()
                    .anyRequest().fullyAuthenticated()
                    .antMatchers(HttpMethod.OPTIONS, "/**").permitAll();
        }

    }

	
	@Configuration
	@EnableAuthorizationServer
	protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter{
		private TokenStore tokerStore = new InMemoryTokenStore();
		
		
		@Autowired
		private AuthenticationManager authenticationManager;
		
		@Autowired
		private UsuarioService usuarioService;
		
		@Autowired
		private PasswordEncoder passwordEncoder;
		
		@Override
		public void configure(AuthorizationServerEndpointsConfigurer endpointsConfigurer) throws Exception{
			endpointsConfigurer.tokenStore(this.tokerStore)
			.authenticationManager(this.authenticationManager)
			.userDetailsService(usuarioService)
			.allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
		}
		
		@Override
		public void configure(ClientDetailsServiceConfigurer clients) throws Exception{
			clients.inMemory()
			.withClient("client")
			.authorizedGrantTypes("password","authorization_code","refresh_token").scopes("all")
			.refreshTokenValiditySeconds(300000)
			.resourceIds(RESOURCE_ID)
			.secret(passwordEncoder.encode("123"))
			.accessTokenValiditySeconds(50000);
		}
		
		@Bean
		@Primary
		public DefaultTokenServices tokenServices() {
			DefaultTokenServices tokenServices = new DefaultTokenServices();
			tokenServices.setSupportRefreshToken(true);
			tokenServices.setTokenStore(this.tokerStore);
			return tokenServices;
		}
	}
	
}
