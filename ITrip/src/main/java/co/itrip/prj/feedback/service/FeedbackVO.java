package co.itrip.prj.feedback.service;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 경아
 * 유저CBT의 피드백(=댓글)
 * 2022/09/22시작 
 * */

@Getter
@Setter
public class FeedbackVO {
	int feedbackNo;
	String content;
	int cbtNo;
	String memberId;
	String nick;
}
