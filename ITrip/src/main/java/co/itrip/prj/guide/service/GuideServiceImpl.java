package co.itrip.prj.guide.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.itrip.prj.guide.mapper.GuideMapper;

/**
 * 
 * @author 박은지, 권소정
 *
 */

@Service
public class GuideServiceImpl implements GuideService {

	@Autowired
	private GuideMapper map;
	
	@Override
	public List<GuideVO> guideSelectList() {
		// 가이드 전체조회
		return map.guideSelectList();
	}

	/** 가이드 단건조회
	 *  @param GuideVO vo
	 *  @return vo
	 *  2022.09.21 박은지
	 */
	@Override
	public GuideVO guideSelect(GuideVO vo) {
		// 가이드 단건조회
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
		// 가이드 정보 수정
		return map.guideUpdate(vo);
	}

	@Override
	public int guideDelete(GuideVO vo) {
		// 가이드 삭제
		return map.guideDelete(vo);
	}

}
