package co.itrip.prj;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.ui.Model;

/**
* 시큐리티 성공했을때 처리하는 핸들러
* @author 김하은
* @date 2022.09.21
* @version 1.0
*/
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
		                             	Authentication authentication) throws IOException, ServletException {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();	
		HttpSession session = request.getSession();
		session.setAttribute("name", userDetails.getUsername());
		String cpath = request.getContextPath();
		response.sendRedirect("/");		
	}

}
