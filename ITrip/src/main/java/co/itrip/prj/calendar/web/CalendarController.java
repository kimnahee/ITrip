package co.itrip.prj.calendar.web;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.itrip.prj.calendar.service.CalendarService;
import co.itrip.prj.calendar.service.CalendarVO;

@Controller
public class CalendarController {
	
	@Autowired
	private CalendarService calService; // 캘린더 서비스
	
	
	// 상담 캘린더
	@GetMapping("/calendar.do")
	public String calendar(CalendarVO vo, Model model, Principal principal, HttpServletRequest request) {
		String id = request.getParameter("guideId");
		System.out.println("!!!!!!!!!" +id);
		vo.setGuideId(principal.getName());
		System.out.println(vo);
		//model.addAttribute("calendarList", calService.myCalendarList(vo));
		return "consult/calendar";
	}
	
	
	
	// 상담, 클래스 리스트
	@GetMapping("/calendarList.do")
	@ResponseBody
	public List<CalendarVO> calendarList(CalendarVO vo) {
		System.out.println(vo);
		return calService.myCalendarList(vo);
	}
	
	

}
