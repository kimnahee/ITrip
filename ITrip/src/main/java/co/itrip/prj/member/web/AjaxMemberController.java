package co.itrip.prj.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.itrip.prj.member.service.MemberService;

/**
 * 회원가입에 필요한 ajax 처리
 * @author 김하은
 * @date 2022.09.28
 */
@RestController
@RequestMapping("/chk")
public class AjaxMemberController {
	@Autowired
	private MemberService mService;
	
	// id 중복 검사
	@PostMapping("/ajaxIdChk.do")
	public int ajaxIdChk(String mId) {
		return mService.ajaxIdChk(mId);
	}
	
	// 닉네임 중복 검사
	@PostMapping("/ajaxNickChk.do")
	public int ajaxNickChk(String mNick) {
		System.out.println(mNick);
		return mService.ajaxNickChk(mNick);
		
	}  
	// 패스워드 확인
	@PostMapping("/ajaxpwChk.do")
	public int ajaxpwChk(String mPw) {
		int r = mService.ajaxpwChk(mPw);
		return r;
		
	}  
}
