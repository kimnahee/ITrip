package co.itrip.prj.member.service;

import lombok.Data;

@Data
public class MemberVO {
	
	// 멤버 테이블
	String memberId;
	String nick;
	String pw;
	String name;
	String email;
	String attach;
	String attach_Dir;
	String auth;

}
