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

/**
* 시큐리티 환경설정 처리
* @author 김하은
* @date 2022.09.21
* @version 1.0
*/
@Configuration
@EnableWebSecurity //CsrfRequestDataValueProcessor가 적용되어 form 에 CSRF 토큰이 자동적으로 들어감
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
		http.authorizeHttpRequests((requests) ->  requests
							.antMatchers("/", "/loginForm.do","/signupForm.do", "/login","/memberInsert.do", "/chk/**").permitAll()
							.antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
							.anyRequest().authenticated())
				.formLogin().loginPage("/loginForm.do")
				             .loginProcessingUrl("/login")
							.usernameParameter("memberId")
							.passwordParameter("pw")
							.successHandler(loginHandler())
							.defaultSuccessUrl("/")
							//.failureUrl(null) 로그인 실패했을 때 이동하는 페이지 주소
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

		//http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());// 모든 요청에 대해 CSRF Token생성


	}
     //시큐리티 처리 안할 부분
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/css/**", "/bootstrap/**","/files/**");
	}
	
}
