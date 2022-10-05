package co.itrip.prj.cbtGuide.service;


import java.util.List;

import lombok.Data;
/**
* 사용자가 열람한 문제 중 즐겨찾기 
* @author 김하은
* @date 2022.09.16
* @version 1.0
*/

@Data
public class BookmarkVO {
	private String bmCd; // 즐겨찾기 코드
	private String memberId; // 즐겨찾기 한 사람
	private int cbtNo; // cbt 번호
	
	List<Integer> cbtNos; // CBT번호들...
	

}
