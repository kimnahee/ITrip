package co.itrip.prj.cbtCustom.service;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

/**
* 나만의CBT 채점
* @author 박경아
* @date 2022.10.04
*/
@Getter
@Setter
public class CbtCustomHderVO {
	int mcSn; //단순순번
	int mcNo; //문제지생성번호
	int cbtNo; //문제번호
	int cnsr; //내가선택한정답
	Date dt; //문제푼날짜
	String memberId; // 문제푼사람
	int chk; // 정답유무

	String langCd;
	String cdName;
	
}
