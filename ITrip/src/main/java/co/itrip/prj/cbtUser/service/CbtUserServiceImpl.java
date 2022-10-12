package co.itrip.prj.cbtUser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.itrip.prj.cbtGuide.service.CbtGuideVO;
import co.itrip.prj.cbtUser.mapper.CbtUserMapper;
import co.itrip.prj.cmmncd.mapper.CmmnCdMapper;

@Service
public class CbtUserServiceImpl implements CbtUserService {
	@Autowired
	private CbtUserMapper map;

	@Autowired
	private CmmnCdMapper cdMap;
	
	/*
	 * @Override public List<CbtUserVO> cbtUserList(CbtUserVO vo) { return
	 * map.cbtUserList(vo); }
	 */

	@Override
	public int cbtUserInsert(CbtUserVO vo) {
		return map.cbtUserInsert(vo);
	}

	@Override
	public CbtUserVO cbtUserSelectOne(CbtUserVO vo) {
		return map.cbtUserSelectOne(vo);
	}

	@Override
	public CbtUserVO ajaxQuestion(CbtUserVO vo) {
		return map.ajaxQuestion(vo);
	}
	
	@Override
	public List<CbtUserVO> cbtUserMyList(CbtUserVO vo) {	

		/*List<CbtUserVO> list = map.cbtUserMyList(vo);
		 * String gcds; String lcds; for (int i = 0; i < list.size(); i++) { gcds =
		 * cdMap.cdNameList("U", list.get(i).getUtpCd()); lcds = cdMap.cdNameList("L",
		 * list.get(i).getLangCd()); list.get(i).setUtpCdName(gcds);
		 * list.get(i).setLangCdName(lcds);
		 * 
		 * }
		 */
		return map.cbtUserMyList(vo);

    }

	@Override
	public CbtUserVO cbtUserMyOne(CbtUserVO vo) {

		/*
		 * String ucd = cdMap.cdNameList("U", vo.getUtpCd()); String lcd =
		 * cdMap.cdNameList("L", vo.getLangCd()); vo= map.cbtUserMyOne(vo);
		 * vo.setUtpCdName(ucd); vo.setLangCdName(lcd);
		 */
		
		return map.cbtUserMyOne(vo);

	}

	@Override
	public int cbtUserMyUpdate(CbtUserVO vo) {
		return map.cbtUserMyUpdate(vo);
	}

	@Override
	public int cbtUserMyDelete(CbtUserVO vo) {
		return map.cbtUserMyDelete(vo);
	}


}
