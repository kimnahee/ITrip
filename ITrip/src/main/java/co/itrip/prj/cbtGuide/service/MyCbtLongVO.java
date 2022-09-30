package co.itrip.prj.cbtGuide.service;

import lombok.Data;

/**
* 사용자가 서술형 문제를 풀면 생성되는 변수를 담은 클래스
* @author 김하은
* @date 2022.09.26 
* @version 1.0
*/
@Data
public class MyCbtLongVO {
	private int mkyNo; //응시번호
	private String mcKwrd; // 서술형 입력한 답
	private int chk; //정답유무
	private int cbtNo; // cbt번호
	//서술형 문제에서 ajax처리 후 받아올 값을 담는 변수 선언(join 3개)
	private String ques; // 문제내용
	private String cnsr; // 가이드가 입력한 정답
	private String cKwrd; // 키워드 나열 처리 된 값
	
	

}
