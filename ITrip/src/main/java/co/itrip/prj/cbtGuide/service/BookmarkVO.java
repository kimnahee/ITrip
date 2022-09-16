package co.itrip.prj.cbtGuide.service;

import lombok.Data;

@Data
public class BookmarkVO {
	private String bkmk; // 즐겨찾기 폴더
	private String tpCd; // cbt유형코드
	private String memberId; // 즐겨찾기 한 사람
	private String cbtNo; // cbt 번호
	

}
