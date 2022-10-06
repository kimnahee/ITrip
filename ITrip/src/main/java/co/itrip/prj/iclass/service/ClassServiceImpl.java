package co.itrip.prj.iclass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.itrip.prj.iclass.mapper.ClassMapper;

@Service
public class ClassServiceImpl implements ClassService {
	
	@Autowired
	private ClassMapper map;

	@Override
	public List<ClassVO> classList(ClassVO vo) {
		return map.classList(vo);
	}

	@Override
	public ClassVO classSelectOne(ClassVO vo) {
		return map.classSelectOne(vo);
	}

	@Override
	public int classInsert(ClassVO vo) {
		
		// ClassInsert처리가 먼저
		int r = map.classInsert(vo);
		
		ClassDtVO dtvo = new ClassDtVO(); // ClassDtVO 호출
		dtvo.setClassNo(vo.getClassNo());
		
		System.out.println("===="+vo.getClassDt().size());
		// 클래스 날짜&시간등록
		for(int i=0; i < vo.getClassDt().size(); i++) {
			if(vo.getClassDt().get(i) != null) {
				dtvo.setTerm(vo.getClassDt().get(i).getTerm());
			//	dtvo.setCtimeNo(1+i);
				dtvo.setBeginTime(vo.getClassDt().get(i).getBeginTime());
				dtvo.setEndTime(vo.getClassDt().get(i).getEndTime());
				map.classDtInsert(dtvo);
			}
			
		}
		return r;
	}

	@Override
	public int classDelete(ClassVO vo) {
		// TODO Auto-generated method stub
		return map.classDelete(vo);
	}

	@Override
	public List<ClassDtVO> classDtList(ClassDtVO vo) {
		return map.classDtList(vo);
	}

	@Override
	public List<ClassVO> ajaxJobSearch(ClassVO vo) {
		return map.ajaxJobSearch(vo);
	}

	@Override
	public List<ClassVO> myClassList(ClassVO vo) {
		// 마이페이지 class 전체조회
		return map.myClassList(vo);
	}

	@Override
	public List<ClassVO> alreadyClass(ClassVO vo) {
		// 가이드가 신청한 승인대기중인 클래스
		return map.alreadyClass(vo);
	}

	@Override

	public int classAttendInsert(ClassAttendVO vo) {
		return map.classAttendInsert(vo);
  }
	public ClassChatVO classChatLink(ClassChatVO vo) {
		//클래스 채팅방 연결
		return map.classChatLink(vo);

	}

	@Override
	public int classChk(ClassAttendVO vo) {
		//클래스 출석체크
		return map.classChk(vo);
	}

	@Override
	public ClassAttendVO classAttendSelect(ClassAttendVO vo) {
		// 수업 주차랑 출석횟수 비교
		return map.classAttendSelect(vo);
	}

	@Override
	public int classAttendUpdate(ClassAttendVO vo) {
		// 수강완료로 업데이트
		return map.classAttendUpdate(vo);
	}

	@Override
	public List<ClassAttendVO> myClassAttendList(ClassAttendVO vo) {
		// 내가 듣는 클래스출석 리스트
		return map.myClassAttendList(vo);
	}

	
	

	

}
