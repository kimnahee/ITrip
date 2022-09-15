package co.itrip.prj.cbtGuide.service;

import lombok.Data;

@Data
public class MyCbtVO {
	private int cbtNo; // cbt번호
	private int mcNo; // 응시번호
	private int choice; // 유저가 선택한 답
	private int cnsrEnnc; // 정답유무 0(틀림), 1(맞음)
}
