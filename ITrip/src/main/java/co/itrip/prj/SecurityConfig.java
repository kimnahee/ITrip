package co.itrip.prj;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;


import co.itrip.prj.member.service.MemberDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public MemberDetailService memberService() {
		return new MemberDetailService();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public CustomLoginSuccessHandler loginHandler() {
		return new CustomLoginSuccessHandler();
	}

	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		return new WebAccessDenyHandler();
	}
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((requests) -> 
							requests
							.antMatchers("/", "/loginForm.do","/signupForm.do", "/login").permitAll()
							.antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
							.anyRequest().authenticated())
				.formLogin().loginPage("/loginForm.do")
				             .loginProcessingUrl("/login")
							.usernameParameter("memberId")
							.passwordParameter("pw")
							.successHandler(loginHandler())
							.defaultSuccessUrl("/")
							.and()
				.logout()//.logoutUrl("/logout")
					      .logoutSuccessUrl("/")
						 .invalidateHttpSession(true)
						 //.deleteCookies("JSESSIONID")
						 .and()
				.exceptionHandling()
					     .accessDeniedHandler(accessDeniedHandler())
					     .and()
					     //.csrf().disable()
				.userDetailsService(memberService());
				
				return http.build();

	}
     //시큐리티 처리 안할 부분
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/css/**", "/bootstrap/**","/files/**");
	}

	
}
