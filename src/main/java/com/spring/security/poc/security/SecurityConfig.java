package com.spring.security.poc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	// Authentication : User --> Roles(Create Users ad in memory)
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	  auth.inMemoryAuthentication().withUser("mkyong").password("123456").roles("USER");
	  auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
	  auth.inMemoryAuthentication().withUser("dba").password("123456").roles("DBA");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	  http.authorizeRequests()
	  	.antMatchers("/").fullyAuthenticated()
	  	.antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/dba/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')")
		.anyRequest().authenticated()
		.and().formLogin()
		.and().logout()
	    .logoutUrl("/logout").logoutUrl("/j_spring_security_logout")
        .logoutSuccessUrl("/")
        .permitAll();

	}
	
	// Authorization : Role -> Access
//	@Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//        .authorizeRequests()
//            .antMatchers("/", "/home", "/public/**").permitAll()
//            .antMatchers("/students/**").hasRole("ADMIN")
//            .anyRequest().fullyAuthenticated()
//            .and()
//        .formLogin()
//            .loginPage("/login")
//            .failureUrl("/login?error")
//            .permitAll()
//            .and()
//        .logout()
//         .logoutUrl("/logout")
//            .logoutSuccessUrl("/")
//            .permitAll();
//    }
}
