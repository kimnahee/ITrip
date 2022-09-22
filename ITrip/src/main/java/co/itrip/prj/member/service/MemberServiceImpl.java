package co.itrip.prj.member.service;

import java.util.List;

/**
 * 
 * @author 박은지, 권소정
 *
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Override
	public int memberInsert(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
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
		return 0;
	}

}
