package co.itrip.prj.alarm.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.itrip.prj.alarm.service.AlarmService;
import co.itrip.prj.alarm.service.AlarmVO;

@Controller
public class AlarmController {
	
	@Autowired
	private AlarmService service;
	
	@PostMapping("/alarmList.do")
	@ResponseBody
	public List<AlarmVO> myAlarmList(AlarmVO vo, HttpServletRequest request, Model model){
		System.out.println(request.getParameter("memberId"));
		vo.setMemberId(request.getParameter("memberId"));
		return service.alarmList(vo);
	}
	
	@PostMapping("/alarmCount.do")
	@ResponseBody
	public int myAlarm(AlarmVO vo, HttpServletRequest request, Model model) {
		System.out.println(request.getParameter("memberId"));
		vo.setMemberId(request.getParameter("memberId"));
		return service.alarmCount(vo);
	}
}
