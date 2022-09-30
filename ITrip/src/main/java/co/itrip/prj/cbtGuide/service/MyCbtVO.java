package co.itrip.prj.cbtGuide.service;

import lombok.Data;

/**
* 사용자가 문제를 풀면 생성되는 변수를 담은 클래스
* @author 김하은
* @date 2022.09.16 
* @version 1.0, 2022.09.23 역정규화로 인해 사용 안 할 클래스
*/
@Data
public class MyCbtVO {
	private int mc_no; // cbt번호
	private int cbtNo1; //문제1번
	private int cbtNo2; //문제2번
	private int cbtNo3; //문제3번
	private int cbtNo4; //문제4번
	private int cbtNo5; //문제5번
	// 정답유무체크 0(틀림), 1(맞음)
	private int chk1; //정답체크1번
	private int chk2; //정답체크2번
	private int chk3; //정답체크3번
	private int chk4; //정답체크4번
	private int chk5; //정답체크5번
}
