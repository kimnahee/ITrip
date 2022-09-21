package co.itrip.prj.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import co.itrip.prj.member.mapper.MemberMapper;

public class MemberDetailService implements UserDetailsService {
    @Autowired
    private MemberMapper map;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVO vo = new MemberVO();
		vo.setMemberId(username);
		vo = map.memberSelect(vo);
		if (vo == null) {
			throw new UsernameNotFoundException("no user");
		}
		return new DetailMemberVO(vo);
	}
}
