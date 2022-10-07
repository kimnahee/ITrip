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
import lombok.AllArgsConstructor;

/**
* 시큐리티 환경설정 처리
* @author 김하은
* @date 2022.09.21
* @version 1.1
*/
@Configuration
@EnableWebSecurity //CsrfRequestDataValueProcessor가 적용되어 form 에 CSRF 토큰이 자동적으로 들어감
@AllArgsConstructor //든 필드 값을 파라미터로 받는 생성자를 만들어줍니다.
public class SecurityConfig 
{
   private final CustomLoginFailHandler loginFailHandler;
   
	@Bean
	public MemberDetailService memberService() {
		return new MemberDetailService();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		// 비밀번호 암호화 객체,Service에서 비밀번호를 암호화할 수 있도록 Bean으로 등록
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
							.failureHandler(loginFailHandler)// 로그인 실패했을 때 이동하는 핸들러
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
