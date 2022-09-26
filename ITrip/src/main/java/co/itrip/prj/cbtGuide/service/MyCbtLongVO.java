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

}
