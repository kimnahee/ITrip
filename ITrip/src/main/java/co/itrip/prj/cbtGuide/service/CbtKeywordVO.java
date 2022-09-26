package co.itrip.prj.cbtGuide.service;

import java.util.List;

import lombok.Data;

/**
* 가이드가 등록한 서술형 문제의 키워드
* @author 김하은
* @date 2022.09.16
* @version 1.1
*/
@Data
public class CbtKeywordVO {
	private int kyNo; // 키워드 순번
	private String cKwrd; // 키워드
	private int cbtNo; // cbt 번호
	private int mkyNo; // 사용자가 푼 서술형 문제지번호
	private List<Integer> chklist; // 키워드 기준올 사용자 정답여부를 체크할 임시 변수

}
