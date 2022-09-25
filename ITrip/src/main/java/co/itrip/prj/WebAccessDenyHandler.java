package co.itrip.prj;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

/**
* 에러 떴을 때 처리하는 핸들러
* @author 김하은
* @date 2022.09.21
* @version 1.0
*/
@Component
public class WebAccessDenyHandler implements AccessDeniedHandler {
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
			request.getRequestDispatcher("/error403").forward(request, response);
	}

}
