package co.itrip.prj;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

/**
 * 로그인 실패했을때 처리하는 핸들러
 * 
 * @author 김하은
 * @date 2022.10.07
 * @version 1.0
 */
@Component // Bean을 따로 등록하지 않아도 사용할 수 있다.
public class CustomLoginFailHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

		String msg = "아이디 또는 비밀번호가 일치하지 않습니다.";
		
		if(exception instanceof BadCredentialsException) {
			
		}else if(exception instanceof InsufficientAuthenticationException) {
			msg ="Invalid Secret Key";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/login?error=true&exception="+msg);
		dispatcher.forward(request, response);

	}
}
