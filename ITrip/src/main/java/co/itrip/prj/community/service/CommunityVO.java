package co.itrip.prj.community.service;

import java.sql.Date;

import lombok.Data;

@Data
public class CommunityVO {

	//커뮤니티 게시판
	private int comNo;
	private String title;
	private String content;
	private String memberId;
	private String nick;
	private Date dt;
	private int hit;
	private String attach;
	private String attachDir;
	private String ctgry;
	
	private String key; // 검색할 키워드
	private String val; // 검색할 값
}
