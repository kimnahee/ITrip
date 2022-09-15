package co.itrip.prj.member.service;

import lombok.Data;

@Data
public class MemberVO {
	String memberId;
	String nick;
	String pw;
	String name;
	String email;
	String attach;
	String attach_Dir;
	String auth;

}
