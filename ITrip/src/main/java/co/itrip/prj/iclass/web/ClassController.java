package co.itrip.prj.iclass.web;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import co.itrip.prj.alarm.service.AlarmService;
import co.itrip.prj.alarm.service.AlarmVO;
import co.itrip.prj.cmmncd.service.CmmnCdService;
import co.itrip.prj.follow.service.FollowService;
import co.itrip.prj.follow.service.FollowVO;
import co.itrip.prj.iclass.service.ClassAttendVO;
import co.itrip.prj.iclass.service.ClassChatVO;
import co.itrip.prj.iclass.service.ClassDtVO;
import co.itrip.prj.iclass.service.ClassService;
import co.itrip.prj.iclass.service.ClassVO;

@Controller
public class ClassController {

	@Autowired
	private ClassService cService; // 가이드 서비스

	@Autowired
	private CmmnCdService cmService; // 공통코드서비스

	@Value("${file.dir}")
	private String fileDir; // 파일 저장할 디폴트 경로 C:/Temp

	@Autowired
	private FollowService fService; // 팔로우 서비스

	@Autowired
	private AlarmService aService; // 알람 서비스

	// 클래스리스트
	@GetMapping("/iClassList.do")
	public String iClass(ClassVO vo, Model model, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "6") int pageSize) {
		PageHelper.startPage(pageNum, pageSize);

		model.addAttribute("pageInfo", PageInfo.of(cService.classList(vo)));
		model.addAttribute("job", cmService.cdList("J"));
		return "class/iclassList";
	}

	// Class insert & 파일처리

	@PostMapping("/classInsert.do")
	public String classInsert(AlarmVO avo, FollowVO fvo, ClassVO vo, ClassDtVO dtvo, MultipartFile file)
			throws IllegalStateException, IOException {

		// 새로운파일저장경로
		String oFileName = file.getOriginalFilename();
		if (!oFileName.isEmpty()) {
			String sFileName = UUID.randomUUID().toString() + oFileName.substring(oFileName.lastIndexOf(".")); // 마지막.뒤에값
																												// 가져오기
			String path = fileDir + "/Thumbnail/" + sFileName;
			file.transferTo(new File(path));
			vo.setAttach(oFileName);
			vo.setAttachDir(sFileName);

		}
		cService.classInsert(vo);

		// 알람 처리
		int classNo = vo.getClassNo(); // class 번호
		String guideId = vo.getGuideId(); // guideId

		fvo.setGuideId(guideId);
		List<FollowVO> flist = fService.followerSelectList(fvo);

		avo.setClassNo(classNo);
		avo.setGuideId(guideId);
		for (int i = 0; i < flist.size(); i++) {
			avo.setMemberId(flist.get(i).getMemberId().toString());
			avo.setAlarmMsg(guideId + "님의 새로운 클래스가 개설되었습니다.");
			aService.alarmInsert(avo);
		} // 나를 팔로우하는 멤버 리스트(flist)


		return "guide/gclass";
	}

		
		
		// 수료증 띄우기(pdf 다운로드)
		@GetMapping("/certificate.do")
		public String certificate(ClassVO vo, ClassAttendVO avo, Model model, HttpServletRequest request) {
			int classNo = Integer.parseInt(request.getParameter("classNo")); //클래스번호
			String memberId = request.getParameter("memberId"); //이름
			vo.setClassNo(classNo);
			model.addAttribute("class", cService.classSelectOne(vo));
			avo.setMemberId(memberId);
			return "class/certification";
		}


	// 경아 - 클래스상세보기certificate.do
	@RequestMapping("/iClassSelectOne.do")
	public String iClassSelectOne(ClassVO vo, Model model, ClassDtVO dvo) {
		model.addAttribute("classOne", cService.classSelectOne(vo));
		model.addAttribute("classDt", cService.classDtList(dvo));
		return "class/iclassSelectOne";
	}

	// 경아 - 클래스 검색
	@RequestMapping("/ajaxJobSearch.do")
	@ResponseBody
	public PageInfo<ClassVO> ajaxJobSearch(ClassVO vo, Model model, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "6") int pageSize) {
		PageHelper.startPage(pageNum, pageSize);

		return PageInfo.of(cService.ajaxJobSearch(vo));
	}


	// 채팅방 연결
	@GetMapping("/classChat.do")
	public String classChat(ClassVO vo, ClassChatVO chatvo, Model model, HttpServletRequest request) {
		int classNo = Integer.parseInt(request.getParameter("classNo"));
		chatvo.setClassNo(classNo);
		model.addAttribute("chat", cService.classChatLink(chatvo));
		return "chat/classChat";
	}

	// 출석체크
	@PostMapping("/classChk.do")
	@ResponseBody
	public int classChk(ClassAttendVO vo, Model model, HttpServletRequest request) {
		int classNo = Integer.parseInt(request.getParameter("classNo"));
		String memberId = request.getParameter("memberId");
		System.out.println("classNo : " + classNo + ", memberId : " + memberId);
		vo.setClassNo(classNo);
		vo.setMemberId(memberId);
		return cService.classChk(vo);
	}

	// 소정 //////////////////////////////////////////////////

	// 이미 신청한 클래스 리스트
	@GetMapping("/alreadyClass")
	public String alreadyClass(Principal principal, Model model, ClassVO vo) {
		vo.setGuideId(principal.getName());
		model.addAttribute("alreadyList", cService.alreadyClass(vo));
		return "guide/alreadyclass";
	}

	// 이미 신청한 클래스 상세보기
	@RequestMapping("/alreadyClassOne.do")
	public String alreadyClassOne(ClassVO vo, Model model, ClassDtVO dtvo) {
		model.addAttribute("class", cService.classSelectOne(vo));
		model.addAttribute("classdt", cService.classDtList(dtvo));
		return "class/alreadyclassone";
	}

}
