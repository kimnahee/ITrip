package co.itrip.prj.member.service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
/**
 * 시큐리티 처리를 위한 회원vo
 * @author 김하은
 * @Date 2022.09.21
 * @version 1.0
 *
 */
@Getter
public class DetailMemberVO extends User{
	//시큐리티 처리하기 위한 MemberVO (CustomUser)
	
	private MemberVO member;

	public DetailMemberVO(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password,authorities);
	}
	
	public DetailMemberVO(MemberVO vo) {
		super(vo.getMemberId(),vo.getPw(),Collections.singletonList(new SimpleGrantedAuthority(vo.getAuth())));
		this.member = vo;
	}

}
