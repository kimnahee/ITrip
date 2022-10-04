package co.itrip.prj.iclass.service;

import lombok.Data;

@Data
public class ClassAttendVO {

	// 클래스 출결
	private String memberId; // 유저 아이디
	private int classNo; // 클래스 번호
	private int attendCnt; // 유저 출석 횟수
	private int complete; // 수료여부 (수업횟수 = 출석횟수)
	
}
