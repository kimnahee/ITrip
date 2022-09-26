package co.itrip.prj.iclass.service;

import lombok.Data;

@Data
public class ClassDtVO {
	
	// 클래스 운영 시간
	private int ctimeNo; // 순번
	private int classNo; // 클래스 번호
	private String term; // 운영기간
	private String beginTime; // 시작시간
	private String endTime; // 종료시간
	

}
