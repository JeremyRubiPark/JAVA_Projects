package org.o7planning.springmvcshoppingcart.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
//@EnableWebMVCSecurity+ other features
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{
	@Autowired
	private MyDBAuthenticationService myDBAuthenticationService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		//For database users
		auth.userDetailsService(myDBAuthenticationService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		super.configure(http);
		http.csrf().disable();
		//This requires login as Employee or Manager.
		//If no login, it will redirect to login page.
		http.authorizeRequests().antMatchers("/orderList","/order", "/accountInfo").access("hasAnyRole('ROLE_EMPLOYEE', 'ROLE_MANAGER')");
		
		//For Manager only
		http.authorizeRequests().antMatchers("/product").access("hasRole('ROLE_MANAGER')");
		
		// When the user has logged in as XX.
	    // But access a page that requires role YY,
	    // AccessDeniedException will throw.
		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
		
		//Config for Login form
		http.authorizeRequests().and().formLogin()
								.loginProcessingUrl("/j_spring_security_check")
								.loginPage("/login")
								.defaultSuccessUrl("/accountInfo")
								.failureUrl("/login?error=true")
								.usernameParameter("userName")
								.passwordParameter("password")
								.and().logout().logoutUrl("/logout").logoutSuccessUrl("/");
	}
}
