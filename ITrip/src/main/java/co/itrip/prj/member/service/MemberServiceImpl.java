package co.itrip.prj.member.service;

import java.util.List;

/**
 * 
 * @author 박은지, 권소정
 *
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;
import co.itrip.prj.member.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberMapper map;

	@Override
	public List<MemberVO> memberSelectList(MemberVO vo) {
		return map.memberSelectList(vo);
	}
	
	/** 유저 단건조회
	 *  @param MemberVO vo
	 *  @return vo
	 *  2022.09.22 박은지
	 */
	@Override
	public MemberVO memberSelect(MemberVO vo) {
		// 유저 단건조회
		return map.memberSelect(vo);
	}
	
	/**
	 * 회원가입
	 * @author 김하은 
	 * @Date 2022.09.28 
	 */
	@Override
	public int memberInsert(MemberVO vo) {
		
		/* 패스워드 암호화*/
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); // 암호화처리를 위한 인스턴스 생성
		String result = encoder.encode(vo.getPw()); // 사용자가 입력한 pw값을 암호화처리
		vo.setPw(result);
		//boolean pwchk = encoder.matches(vo.getPw(), result); //사용자가 입력한 값과 암호화 처리된 값이 동일한지 확인

		int r = map.memberInsert(vo);
		
		return r;
	}
	
	/** 유저 정보수정
	 *  @param MemberVO vo
	 *  @return vo
	 *  2022.09.22 박은지
	 */
	@Override
	public int memberUpdate(MemberVO vo) {
		// 유저 정보수정
		return map.memberUpdate(vo);
	}

	@Override
	public int memberDelete(MemberVO vo) {
		// TODO Auto-generated method stub
		return map.memberDelete(vo);
	}
	
	// id 중복 검사
	@Override
	public int ajaxIdChk(String mId) {
		return map.ajaxIdChk(mId);
	}
	// 닉네임 중복검사
	@Override
	public int ajaxNickChk(String mNick) {
		return map.ajaxNickChk(mNick);
	}
	// 패스워드 확인
	@Override
	public int ajaxpwChk(String mPw) {
		return map.ajaxpwChk(mPw);
	}
	
	

}
