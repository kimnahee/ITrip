package co.itrip.prj.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import co.itrip.prj.member.mapper.MemberMapper;

/**
 * 시큐리티 처리를 위한 service
 * @author 김하은
 * @Date 2022.09.21
 * @version 1.0
 *
 */
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
