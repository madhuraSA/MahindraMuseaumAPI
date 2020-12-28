package com.mahindra.museum.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.mahindra.museum.service.JwtUserDetailsService;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		/*-- Configure AuthenticationManager so that it knows from where to load
		 user for matching credentials
		 Use BCryptPasswordEncoder */
		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		// -- Disable CSRF
		httpSecurity.csrf().disable()
				// -- Authentication not required for below
				.authorizeRequests().antMatchers("/user/hello","/authenticate/**","/user/signup","/user/login", "/user/forgotPassword/**","/swagger-ui.html",
						"/v2/api-docs", "/configuration/ui", "/swagger-resources", "/configuration/security", 
						"/swagger-ui.html", "/webjars/**", "/swagger-resources/configuration/ui", "/swagge‌​r-ui.html", 
						"/swagger-resources/configuration/security","/h2-console/**"
						).permitAll().
				// -- All other requests need to be authenticated
				anyRequest().authenticated().and().
				// -- As its stateless session, session won't be used to store user's state.
				exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).
				and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		// -- Add a filter to validate the tokens with every request
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		httpSecurity.headers().frameOptions().sameOrigin();
		httpSecurity.headers().frameOptions().disable();
		
	}
	
	


}
