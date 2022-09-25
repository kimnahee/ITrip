package co.itrip.prj.cbtGuide.service;

import lombok.Data;

/**
* 가이드가 등록한 서술형 문제의 키워드
* @author 김하은
* @date 2022.09.16
* @version 1.0
*/
@Data
public class CbtKeywordVO {
	private int kyNo; // 키워드 순번
	private String cKwrd; // 키워드
	private int cbtNo; // cbt 번호

}
