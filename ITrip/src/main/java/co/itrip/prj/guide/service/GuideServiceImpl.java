package co.itrip.prj.guide.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.itrip.prj.guide.mapper.GuideMapper;
import co.itrip.prj.iclass.service.ClassVO;

/**
 * 
 * @author 박은지, 권소정
 *
 */

@Service
public class GuideServiceImpl implements GuideService {

	@Autowired
	private GuideMapper map;
	
	/** 가이드 단건조회
	 *  @param GuideVO vo
	 *  @return vo
	 *  2022.09.21 박은지
	 */
	@Override
	public GuideVO guideSelect(GuideVO vo) {
		// 은지 - 가이드 단건조회
		return map.guideSelect(vo);
	}

	@Override
	public int guideInsert(GuideVO vo) {
		// 가이드 등록
		return map.guideInsert(vo);
	}
	
	/** 가이드 정보수정
	 *  @param GuideVO vo
	 *  @return vo
	 *  2022.09.22 박은지
	 */
	@Override
	public int guideUpdate(GuideVO vo) {
		// 은지 -가이드 정보 수정
		return map.guideUpdate(vo);
	}

	@Override
	public List<ClassVO> userList(ClassVO vo) {
		//  은지 - 클래스 수강생 리스트
		return map.userList(vo);
	}

	@Override
	public List<ClassVO> myIClassList(ClassVO vo) {
		// 은지 - 가이드 마이클래스 전체조회
		// myIClassList의 리턴값들을 ClassVO list에 담음
		// List<ClassVO> list =  map.myIClassList(vo);// 인스턴스(list)  
		return  map.myIClassList(vo);
	}



}
